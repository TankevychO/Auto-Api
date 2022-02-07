package com.autoapi.service.downloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HttpClient {
    private final ObjectMapper objectMapper;

    public <T> T get(String url, Class<? extends T> clazz) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity).toLowerCase();
                    return objectMapper.readValue(result, clazz);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to perform request!", e);
        }
        throw new RuntimeException("Can't read data");
    }
}
