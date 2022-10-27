package xyz.ibudai.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ibudai.entity.model.MinioProp;

@Configuration
public class MinioConfig {

    @Value("${minio.enabled}")
    private String enabled;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 初始化 Minio 对象
     */
    @Bean
    public MinioClient minioClient() {
        if (enabled.equals("false")) {
            return null;
        } else {
            return io.minio.MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();
        }
    }
}