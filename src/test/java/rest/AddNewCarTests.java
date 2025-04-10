package rest;

import api_rest.CarController;
import dto.CarDto;
import enums.Fuel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;


public class AddNewCarTests extends CarController {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addNewCarPositiveTest(){
       int i = new Random().nextInt(1000);
        CarDto car = CarDto.builder()
                .serialNumber("1123"+i)
                .manufacture("Tesla")
                .model("Space")
                .year("2025")
                .fuel(Fuel.ELECTRIC.getFuel())
                .seats(2)
                .carClass("A")
                .pricePerDay(200.4)
                .city("Haifa")
                .build();
        Response response = addNewCar(car);
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertTrue(response.getBody().print().contains("Car added"));
        softAssert.assertAll();
    }
}
