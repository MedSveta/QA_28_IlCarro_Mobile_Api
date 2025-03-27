package ui_mobile;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class AddNewCarTests extends AppiumConfig {
    @BeforeMethod
    public void login(){
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .email("sveta123656@gmail.com")
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
    public void addNewCarPositiveTest(){
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();
        MyCarsScreen myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.clickBtnAddNewCar();
        AddNewCarScreen addNewCarScreen = new AddNewCarScreen(driver);
    }
}
