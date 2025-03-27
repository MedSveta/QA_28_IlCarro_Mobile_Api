package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

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

}


