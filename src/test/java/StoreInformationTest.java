import org.testng.annotations.Test;

public class StoreInformationTest extends BaseTest {

    @Test(description = "Validate Store Information")
    public void ValidateStoreInformation() throws InterruptedException {

        String[] values = {properties.getProperty("address"), properties.getProperty("phone"), properties.getProperty("email")};
        softAssert.assertTrue(homePage.checkFooterInformation(values));
        softAssert.assertAll();
    }
}
