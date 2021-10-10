package helpers.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtils {

    String searchUrl;

    public APIUtils() {
        searchUrl = "https://skillacademy.com/skillacademy/discovery/search";
    }

    public Response getSearchResults(String query, int page, int pageSize) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("searchQuery", query)
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .when()
                .get(searchUrl);
    }
}
