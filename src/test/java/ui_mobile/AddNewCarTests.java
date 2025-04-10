package ui_mobile;

import config.AppiumConfig;
import dto.CarDto;
import dto.RegistrationBodyDto;
import enums.Fuel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {
    @BeforeMethod
    public void login() {
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("sveta123656@gmail.com")
                .password("AAaa1234!")
                .build();
        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();

        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnLogin();
    }

    @Test
    public void addNewCarPositiveTest() {
        int i = new Random().nextInt(1000) + 100;
        CarDto car = CarDto.builder().
                serialNumber("555-" + i)
                .manufacture("Tesla")
                .model("XXX")
                .city("Netanya")
                .pricePerDay(1.23)
                .carClass("A")
                .fuel(Fuel.ELECTRIC.getFuel())
                .year("2025")
                .seats(4)
                .about("My favorite car")
                .build();
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        MyCarsScreen myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
        addNewCarScreen.typeAddNewCarForm(car);
        addNewCarScreen.clickBtnAddCar();
        Assert.assertTrue(new MyCarsScreen(driver)
                .textInElementPresent_popUpMessageSuccess("Car was added!"));
    }
}
