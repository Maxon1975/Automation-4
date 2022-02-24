package ru.netology.rest;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {
    @Test
    void shouldReturnDemoAccounts() {
        //Given - When - Then
        //Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Здравствуйте вы позвонили," + //отправка данных (заголовки и query можно выставлять аналогично)
                        "в Интернет магазин." +
                        "Чем я могу вам помочь.")
                //Выполняемые действия
                .when()
                .post("/post")
                //Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Здравствуйте вы позвонили," +
                        "в Интернет магазин." +
                        "Чем я могу вам помочь."));
    }


}
