package tests.webserviceTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import user.User;

public class RestAssuredTest {
    @BeforeTest
    public void initialTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    public void statusCodeCheck() {
        Response response = RestAssured.when()
                .get("/users")
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void headerResponseCheck() {
        Response response = RestAssured.when()
                .get("/users")
                .andReturn();
        String responseContentTypeHeader = response.getHeader("Content-Type");
        Assert.assertEquals(responseContentTypeHeader, "application/json; charset=utf-8");
    }

    @Test
    public void bodyResponseCheck() {
        Response response = RestAssured.when()
                .get("/users")
                .andReturn();
        ResponseBody<?> responseBody = response.getBody();
        User[] users = responseBody.as(User[].class);
        Assert.assertEquals(users.length, 10);
    }
}