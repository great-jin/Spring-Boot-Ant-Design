package xyz.ibudai.entity.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProp {

    private String endpoint;

    private String accessKey;

    private String secretKey;
}
