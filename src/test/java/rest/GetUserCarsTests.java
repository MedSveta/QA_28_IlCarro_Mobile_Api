package rest;

import api_rest.CarController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserCarsTests extends CarController {
    @Test
    public void getUserCarPositiveTest() {
        Assert.assertEquals(getUserCars().getStatusCode(), 200);
    }
}
