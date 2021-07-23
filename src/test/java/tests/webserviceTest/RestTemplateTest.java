package tests.webserviceTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.util.Objects;

public class RestTemplateTest {
    @Test
    public void statusCodeCheck() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", User[].class);
        int actualStatusCode = response.getStatusCode().value();
        Assert.assertEquals(actualStatusCode, 200);
    }

    @Test
    public void headerResponseCheck() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", User[].class);
        HttpHeaders headers = response.getHeaders();

        String actualContentTypeValue = Objects.requireNonNull(headers.getContentType()).toString();
        Assert.assertEquals(actualContentTypeValue, "application/json;charset=utf-8");
    }

    @Test()
    public void bodyResponseCheck() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/users", User[].class);
        User[] userId = response.getBody();

        assert userId != null;
        Assert.assertEquals(userId.length, 10);
    }
}