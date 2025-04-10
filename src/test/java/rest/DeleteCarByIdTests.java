package rest;

import api_rest.CarController;
import dto.CarsDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteCarByIdTests extends CarController {
    CarsDto carsDto;

    @BeforeClass
    public void getUserCarsBeforeDelete() {
        Response response = getUserCars();
        if (response.getStatusCode() == 200) {
            carsDto = response.getBody().as(CarsDto.class);
        } else
            System.out.println("get status code isn't 200 -->"
                    + response.getStatusCode());
    }

    @Test
    public void deleteCarPositiveTest(){
        if (carsDto.getCars().length !=0){
            String serialNumber = carsDto.getCars()[0].getSerialNumber();
            Response response = deleteCarById(serialNumber);
            Assert.assertEquals(response.getStatusCode(), 200);
        }else
        Assert.fail("user don't have any cars");
    }
}
