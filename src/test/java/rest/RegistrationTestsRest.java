package rest;

import api_rest.AuthenticationController;
import dto.ErrorMessageDtoString;
import dto.RegistrationBodyDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;


public class RegistrationTestsRest extends AuthenticationController {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("frodo_baggins"+i+"@gmail.com")
                .password("Qwerty123!")
                .firstName("Frodo")
                .lastName("Baggins")
                .build();
        Assert.assertEquals(registrationLogin(user, REGISTRATION_URL)
                .getStatusCode(), 200);
    }
    @Test
    public void registrationNegativeTest_HTTP_NotSecure(){
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("frodo_baggins"+i+"@gmail.com")
                .password("Qwerty123!")
                .firstName("Frodo")
                .lastName("Baggins")
                .build();
        Response response = registrationLoginHTTP_NotSecure
                (user, REGISTRATION_URL);
        System.out.println(response.print());

        Assert.assertEquals(registrationLoginHTTP_NotSecure
                (user, REGISTRATION_URL)
                .getStatusCode(), 400);
    }
    @Test
    public void registrationNegativeTest_WrongEmail() {
        int i = new Random().nextInt(1000);
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("frodo_baggins" + i + "gmail.com")
                .password("Qwerty123!")
                .firstName("Frodo")
                .lastName("Baggins")
                .build();
        Response response = registrationLoginHTTP_NotSecure
                (user, REGISTRATION_URL);
        softAssert.assertEquals(response.getStatusCode(), 400, "validate status code");
        ErrorMessageDtoString errorMessage = response.getBody().as(ErrorMessageDtoString.class);
        System.out.println(errorMessage.toString());
        softAssert.assertEquals(errorMessage.getError(), "Bad Request");
        softAssert.assertTrue(errorMessage.getMessage().toString()
                .contains("well-formed email address"));
        softAssert.assertAll();

    }
}
