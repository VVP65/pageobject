package tests.webserviceTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import users.Users;

import java.util.Objects;

public class RestTemplateTest {
    @Test
    public void checkStatusCode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", Users[].class);
        int actualStatusCode = response.getStatusCode().value();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void checkResponseHeader() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", Users[].class);
        HttpHeaders headers = response.getHeaders();

        String actualContentTypeValue = Objects.requireNonNull(headers.getContentType()).toString();
        Assert.assertEquals(actualContentTypeValue, "application/json;charset=utf-8");
    }

    @Test()
    public void checkResponseBody() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", Users[].class);
        Users[] userId = response.getBody();

        assert userId != null;
        Assert.assertEquals(userId.length, 10);
    }
}