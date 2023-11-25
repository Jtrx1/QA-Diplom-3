package org.example.model;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    @Step("Создаем нового пользователя")
    public static Response createUser(User user){
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("api/auth/register");

    }
    @Step("Удаляем пользователя")
    public static void deleteUser(String accessToken){
        given()
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
    }
    @Step("Вход пользователя")
    public static Response userLogin(User user){
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("api/auth/login");

    }
}
