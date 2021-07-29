package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import objects.Group;
import objects.Group1;
import objects.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class RestGet {
    private final String api = "api/2";
    private String url = "https://localhost:510";
    private String token = "/oauth/token";
    @Test
    public void checkStatusCode() {
        Response response = RestAssured.get("http://jsonplaceholder.typicode.com/posts");
        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void checkStatusCode1() {
        Response response = RestAssured
                .given()
                .baseUri("http://jsonplaceholder.typicode.com")
                .basePath("/comments")
                .param("postId", "1")
                .get();
        System.out.println(response.asString());
    }

    @Test
    public void getToken() {
        Response response = RestAssured
                .given()
                .baseUri(url)
                .basePath(token)
                .params("grant_type", "password", "client_id", "anchor"
                        , "username", "admin@admin.com", "password", "1q2w3e4r5t!")
                .post();
        System.out.println(response.asString());
    }

    @Test
    public void getGroup() {
            Group response = RestAssured
                .given()
                .baseUri(url)
                .basePath("/api/2/group/1")
//                .auth().basic("admin@admin.com", "1q2w3e4r5t!")
                .header("Authorization", "Bearer UbCd8GLoZxUWOrjq5sxVWjhWNc7N2v")
//                .auth().oauth2("hSgP8cHX4AdrI3AEg53wcz4v5D9Gpv")
                .get().as(Group.class);
        System.out.println(response);
    }

    @Test
    public void getGroup1() {
        Group response = RestAssured
                .given()
                .log().all()
//                .baseUri(url)
//                .basePath("/api/2/group/1")
                .header("Authorization", "Bearer pwZJcFevMN1OtTtAt6vNirrsPdhujG")
                .get(url+"/api/2/group/1").as(Group.class);
        System.out.println(response);
    }

    @Test
    public void createGroup() {
        Group group = new Group(3);
        System.out.println("Initial" + group.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("company_id", group.getCompany_id());
        map.put("name", group.getName());
        Group response = RestAssured
                .given()
                .baseUri(url)
                .basePath("/api/2/group/create")
//                .header("Authorization", "Bearer hSgP8cHX4AdrI3AEg53wcz4v5D9Gpv")
                .auth().oauth2("t90xTEhY2kdHxWCKJPiI7baRFF45Jf")
//                .params("company_id", 3, "name", "groupS5")
                .params(map)
                .log().all()
//                .body(map.toString())
                .post().as(Group.class);
//        System.out.println(response.asString());
//        System.out.println(response.statusCode());
//        System.out.println(response.getCookies());
//        System.out.println(response.contentType());
//        System.out.println(response.getBody().asString());
//        System.out.println(response.getBody().jsonPath().getInt("id"));
//        Assertions.assertEquals(response.getName(), group.getName());
//        System.out.println(response);
        Assertions.assertEquals(group.getCompany_id(), response.getCompany_id());
        Assertions.assertEquals(group.getName(), response.getName());
        Assertions.assertTrue(response.getActive());
        Assertions.assertEquals("group", response.getType());
    }
    @Test
    public void deleteGroup() {
        Group group = new Group(3);
        System.out.println("Initial" + group.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("company_id", group.getCompany_id());
        map.put("name", group.getName());
        Group response = RestAssured
                .given()
                .baseUri(url)
                .basePath("/api/2/group/create")
                .auth().oauth2("UbCd8GLoZxUWOrjq5sxVWjhWNc7N2v")
                .params(map)
//                .log().all()
                .post().as(Group.class);
        System.out.println(response);
        String deletePath = String.format("/api/2/group/%s/delete", response.getId());
        Response responseDelete = RestAssured
                .given()
                .baseUri(url)
                .basePath(deletePath)
                .auth().oauth2("UbCd8GLoZxUWOrjq5sxVWjhWNc7N2v")
                .log().all()
                .post();
        System.out.println(responseDelete.asString());
        String getPath = String.format("/api/2/group/%s", response.getId());
        Response getDeleted = RestAssured
                .given()
                .baseUri(url)
                .basePath(getPath)
                .auth().oauth2("UbCd8GLoZxUWOrjq5sxVWjhWNc7N2v")
                .log().all()
                .get();
        Assertions.assertEquals(200, getDeleted.getStatusCode());
        Assertions.assertFalse(getDeleted.getBody().jsonPath().getBoolean("active"));
    }

}
