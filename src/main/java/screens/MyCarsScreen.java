package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;
import static config.AppiumConfig.*;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com" +
            ".telran.ilcarro:id/addCarBtn']")
    AndroidElement addCarBtn;
    @FindBy(xpath = "/hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    AndroidElement btnYes;

    public boolean textInElementPresent_popUpMessageSuccess(String text){
        return textInElementPresent(popUpMessageSuccess, text, 3);
    }

    public void clickBtnAddNewCar(){
        clickWait(addCarBtn, 3);
    }
    public void deleteFirstCar(){
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(width/10
                , height/4)).moveTo(PointOption
                .point(width/10*9,height/4 )).release().perform();
        clickWait(btnYes, 3);
    }
}
