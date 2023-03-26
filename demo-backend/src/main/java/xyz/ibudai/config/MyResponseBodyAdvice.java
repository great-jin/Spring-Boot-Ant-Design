package xyz.ibudai.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import xyz.ibudai.common.ResultData;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        ResultData<Object> resultData;
        if (body != null) {
            if (body instanceof String) {
                return new ResultData<>(0, "Success", body);
            }
            Map<String, Object> bodyMap = objectMapper.convertValue(body, new TypeReference<Map<String, Object>>() {
            });
            int status = (int) bodyMap.get("status");
            if (status == 0) {
                resultData = new ResultData<>(0, "Success", bodyMap.get("data"));
            } else {
                String msg = (String) bodyMap.get("error");
                resultData = new ResultData<>(status, msg, "");
            }
        } else {
            resultData = new ResultData<>(0, "Success", null);
        }
        return resultData;
    }
}

