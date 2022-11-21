package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {

    String baseUrl = "http://44.202.218.171:8000";


    @Test
    public void test1 (){

        Response response = RestAssured.given().accept(ContentType.JSON)

        .when().get(baseUrl+"/api/spartans");

        System.out.println("response.contentType() = " + response.contentType());

        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

    }

    @Test
    public void test2(){

        Response response = RestAssured.given().accept(ContentType.JSON).when().get(baseUrl + "/api/spartans/3");

        System.out.println("response.contentType() = " + response.contentType());

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.body().asString() = " + response.body().asString());

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }

    @Test
    public void test3(){

        Response response = RestAssured.when().get(baseUrl + "/api/hello");

        Assertions.assertEquals(200,response.statusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));

        System.out.println(response.header("Date"));

        Assertions.assertEquals("17",response.header("Content-Length"));

        Assertions.assertEquals("Hello from Sparta",response.body().asString());

    }

}
