package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIUtils {
    public static Response sendPostRequest(RequestSpecification request, String endpoint) {
        return RestAssured.given()
                .spec(request)
                .when()
                .post(endpoint);
    }

    public static Response sendPostRequest(RequestSpecification request, String endpoint, Object body) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .post(endpoint);
    }

    public static Response sendPostRequestWithAccessToken(RequestSpecification request, String endpoint, Object body,String accessToken) {
        return RestAssured.given().spec(request)
                .header("Authorization" , "Bearer " + accessToken)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .post(endpoint);
    }

    public static Response sendPostRequest(RequestSpecification request, String endpoint, Object body, String pathParam) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .post(endpoint + "/" + pathParam + "/items");
    }

    public static Response sendGetRequestWithAccessToken(RequestSpecification request, String endpoint,String accessToken) {
        return RestAssured.given().spec(request)
                .header("Authorization" , "Bearer " + accessToken)
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, Map<String, String> queryParam) {
        return RestAssured.given().spec(request)
                .log().all()
                .queryParams(queryParam)
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, Integer pathParam) {
        return RestAssured.given().spec(request)
                .when().log().all()
                .get(endpoint + "/" + pathParam);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, String pathParam) {
        return RestAssured.given().spec(request)
                .when().log().all()
                .get(endpoint + "/" + pathParam);
    }

    public static Response sendGetRequestForGetCartItems(RequestSpecification request, String endpoint, String pathParam) {
        return RestAssured.given().spec(request)
                .when().log().all()
                .get(endpoint + "/" + pathParam + "/items");
    }

    public static Response sendPatchRequest(RequestSpecification request, String endpoint, Object body) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .patch(endpoint);
    }

    public static Response sendPatchRequestWithAccessToken(RequestSpecification request, String endpoint, Object body,String accessToken) {
        return RestAssured.given().spec(request)
                .header("Authorization" , "Bearer " + accessToken)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .patch(endpoint);
    }
    public static Response sendPutRequest(RequestSpecification request, String endpoint, Object body) {
        return RestAssured.given().spec(request)
                .contentType("application/json")
                .body(body).log().all()
                .when()
                .put(endpoint);
    }

    public static Response sendDeleteRequest(RequestSpecification request, String endpoint) {
        return RestAssured.given().spec(request)
                .when().log().all()
                .delete(endpoint);
    }

    public static Response sendDeleteRequestWithAccessToken(RequestSpecification request, String endpoint,String accessToken) {
        return RestAssured.given().spec(request)
                .header("Authorization" , "Bearer " + accessToken)
                .when().log().all()
                .delete(endpoint);
    }
}
