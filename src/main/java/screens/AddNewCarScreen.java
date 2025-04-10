package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.AppiumConfig.*;

public class AddNewCarScreen extends BaseScreen {
    public AddNewCarScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editSerial']")
    AndroidElement inputSerialNumber;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editMan']")
    AndroidElement inputManufacture;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editModel']")
    AndroidElement inputModel;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editCity']")
    AndroidElement inputCity;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editPrice']")
    AndroidElement inputPrice;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editCarClass']")
    AndroidElement inputCarClass;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/text1']")
    AndroidElement inputFuel;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editYear']")
    AndroidElement inputYear;
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/editSeats']")
    AndroidElement inputSeats;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editAbout']")
    AndroidElement inputAbout;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    AndroidElement btnAddCar;
    @FindBy(xpath = "//*[@text='Gas']")
    AndroidElement fuelGas;


    public void typeAddNewCarForm(CarDto car) {
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputCity.sendKeys(car.getCity());
        inputPrice.sendKeys(car.getPricePerDay() + "");
        inputCarClass.sendKeys(car.getCarClass());
        System.out.println(height + "X" + width);
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(width / 100,
                height / 4 * 3)).moveTo(PointOption.point(width / 100
                , height / 4)).release().perform();
        typeFuel(car.getFuel());
        inputYear.sendKeys(car.getYear());
        inputSeats.sendKeys(Integer.toString(car.getSeats()));
        inputAbout.sendKeys(car.getAbout());


    }

    private void typeFuel(String fuel) {
        clickWait(inputFuel, 3);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@text='" + fuel + "']")))
                .click();
    }
    public void clickBtnAddCar(){
        clickWait(btnAddCar, 3);
    }
}


