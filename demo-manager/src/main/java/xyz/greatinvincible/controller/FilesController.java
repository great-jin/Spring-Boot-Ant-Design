package xyz.greatinvincible.controller;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
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

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public boolean upload(@RequestParam(name = "file", required = false) MultipartFile file) {
        String bucketName = "webtest";
        boolean tag = false;

        if(file.isEmpty()){
            tag = false;
        }

        try {
            minioUtil.uploadFile(file, bucketName);
            tag = true;
        } catch (Exception e) {
            log.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }

    /**
     * 删除文件
     */
    @PostMapping("/delete")
    public void delete(String objectName) throws Exception {
        String bucketName = "webtest";
        minioUtil.removeObject(bucketName, objectName);
    }

}
