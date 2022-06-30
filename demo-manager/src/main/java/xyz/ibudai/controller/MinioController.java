package xyz.ibudai.controller;

import java.awt.print.PrinterException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ibudai.entity.Files;
import xyz.ibudai.entity.model.MinioRespond;
import xyz.ibudai.service.FilesService;
import xyz.ibudai.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/files")
public class MinioController {

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private FilesService filesService;

    @PostMapping("list")
    public List<Files> list() {
        return filesService.list();
    }

    @PostMapping("/upload")
    public boolean UploadFile(@RequestParam(name = "files") MultipartFile multipartFile,
                              @RequestParam(name = "ID") String ID) {
        if (multipartFile.isEmpty()) {
            return false;
        }

        MinioRespond minioRespond;
        boolean tag = false;
        String bucketName = "webtest";
        try {
            minioRespond = minioUtil.uploadFile(multipartFile, bucketName);
            if (minioRespond.getObjectWriteResponse() != null) {
                Files files = new Files();
                files.setAccountCode(ID);
                files.setInTime(new Date());
                files.setFileName(minioRespond.getOriginName());
                files.setMinioBucket(bucketName);
                files.setMinioPath(minioRespond.getFileName());

                int i = filesService.add(files);
                if (i > 0) {
                    tag = true;
                }
            }
        } catch (Exception e) {
            log.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    @PostMapping("/delete")
    public void Delete(@RequestParam(name = "fileID") String fileID) throws Exception {
        String bucketName = "webtest";
        Files file = filesService.get(fileID);
        try {
            minioUtil.removeObject(bucketName, file.getMinioPath());
        } catch (Exception e) {
            log.error("失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> Download(@RequestParam(name = "fileID") String fileID) throws Exception {
        String bucketName = "webtest";
        Files file = filesService.get(fileID);

        ResponseEntity<byte[]> responseEntity = null;

        try (InputStream stream = minioUtil.getObject(bucketName, file.getMinioPath())) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = stream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            byte[] bytes = output.toByteArray();

            //设置header
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Accept-Ranges", "bytes");
            httpHeaders.add("Content-Length", bytes.length + "");
            httpHeaders.add("Content-disposition", "attachment; filename=" + fileID);
            httpHeaders.add("Content-Type", "text/plain;charset=utf-8");
            responseEntity = new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new PrinterException();
        }
        return responseEntity;
    }
}
