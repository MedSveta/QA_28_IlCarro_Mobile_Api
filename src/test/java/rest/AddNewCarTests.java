package rest;

import api_rest.CarController;
import dto.CarDto;
import enums.Fuel;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends CarController {
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
    }
}
