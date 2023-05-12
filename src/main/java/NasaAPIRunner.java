import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public class NasaAPIRunner {
    public static final String REMOTE_SERVICE_URL = "https://api.nasa.gov/planetary/apod?api_key=cHcitmGz59C9ZhR9tZtTdqb8qqIwbabXh2i1HtEI";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("to NASA")
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
        HttpGet request = new HttpGet(REMOTE_SERVICE_URL);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = httpClient.execute(request);
        NASAResponse nasaResponse = mapper.readValue(
                response.getEntity().getContent(), NASAResponse.class);
        System.out.println(nasaResponse);

        HttpGet requestToImageUrl = new HttpGet(nasaResponse.getUrl());
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        CloseableHttpResponse responseOfImageUrl = httpClient.execute(requestToImageUrl);
        String pathString = RegexUtil.getSubstringByPattern(nasaResponse.getUrl(), Pattern.compile(".*/(.*)"));
        try {
            Path path = Path.of(pathString);
            Files.write(path, EntityUtils.toByteArray(responseOfImageUrl.getEntity()), StandardOpenOption.CREATE);
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
