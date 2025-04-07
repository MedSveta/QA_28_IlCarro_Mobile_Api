package api_rest;

import dto.RegistrationBodyDto;
import dto.TokenDto;
import interfaces.BaseApi;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.given;

public class CarController implements BaseApi {
    public TokenDto tokenDto;


    @BeforeSuite
    public void login(){
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("frodo_baggins@gmail.com")
                .password("Qwerty123!")
                .firstName("Frodo")
                .lastName("Baggins")
                .build();
        tokenDto = given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL+LOGIN_URL)
                .thenReturn()
                .getBody()
                .as(TokenDto.class);
        System.out.println(tokenDto.getAccessToken());
    }

}
