package rest;

import api_rest.AuthenticationController;
import dto.RegistrationBodyDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTestsRest extends AuthenticationController {
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
    public void registrationPositiveTest_HTTP_NotSecure(){
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
}
