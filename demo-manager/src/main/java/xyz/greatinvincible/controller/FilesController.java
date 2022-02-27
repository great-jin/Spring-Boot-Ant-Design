package xyz.greatinvincible.controller;

import java.util.Arrays;
import java.util.Date;

import io.minio.ObjectWriteResponse;
import lombok.extern.slf4j.Slf4j;
import xyz.greatinvincible.entity.Files;
import xyz.greatinvincible.services.FilesService;
import xyz.greatinvincible.services.UserServices;
import xyz.greatinvincible.utils.MinioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

        ObjectWriteResponse objectWriteResponse = null;
        boolean tag = false;
        String bucketName = "webtest";
        try {
            objectWriteResponse = minioUtil.uploadFile(file, bucketName);
            if(objectWriteResponse != null){
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

    @PostMapping("/delete")
    public void delete(String objectName) throws Exception {
        String bucketName = "webtest";
        minioUtil.removeObject(bucketName, objectName);
    }

}
