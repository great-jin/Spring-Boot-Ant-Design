package xyz.greatinvincible.controller;

import java.util.Arrays;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import xyz.greatinvincible.entity.Files;
import xyz.greatinvincible.entity.MinioRespond;
import xyz.greatinvincible.services.FilesService;
import xyz.greatinvincible.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/files")
public class FilesController {

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private FilesService filesService;

    @PostMapping("/upload")
    public boolean upload(@RequestParam(name = "files", required = false) MultipartFile file) {
        if(file.isEmpty()){
            return false;
        }

        MinioRespond respond;
        boolean tag = false;
        String bucketName = "webtest";
        try {
            respond = minioUtil.uploadFile(file, bucketName);
            if(respond.getObjectWriteResponse() != null){
                Files files = new Files();
                files.setAccountCode("1");
                files.setInTime(new Date());
                files.setMinioBucket(bucketName);

                int i = filesService.add(files);
                if(i>0){
                    tag = true;
                }
            }
        } catch (Exception e) {
            log.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    @PostMapping("/uploadFiles")
    public boolean uploadFile(@RequestParam(name = "multipartFile") MultipartFile multipartFile,
                              @RequestParam(name = "userID") String userID) {
        if(multipartFile.isEmpty()){
            return false;
        }

        MinioRespond minioRespond = null;
        boolean tag = false;
        String bucketName = "webtest";
        try {
            minioRespond = minioUtil.uploadFile(multipartFile, bucketName);
            if(minioRespond.getObjectWriteResponse() != null){
                Files files = new Files();
                files.setAccountCode(userID);
                files.setInTime(new Date());
                files.setFileName(minioRespond.getOriginName());
                files.setMinioBucket(bucketName);
                files.setMinioPath(minioRespond.getFileName());

                int i = filesService.add(files);
                if(i>0){
                    tag = true;
                }
            }
        } catch (Exception e) {
            log.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    @PostMapping("/delete")
    public void delete(String objectName) throws Exception {
        String bucketName = "webtest";
        minioUtil.removeObject(bucketName, objectName);
    }

}
