import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{

    @Test(description = "Add item to shopping cart")
    public void addItemToCart() throws Exception
    {
        homePage.clickSingInButton();
        homePage.doLogin(properties.getProperty("username"),properties.getProperty("passwd"));
        homePage.doShop(properties.getProperty("dress-type"));
        softAssert.assertTrue(homePage.verifyOrder(properties.getProperty("dress-type")));
        softAssert.assertAll();
    }

    @Test(description = "Delete item from shopping cart")
    public void deleteItemFromCart() throws InterruptedException {
        softAssert.assertTrue(homePage.deleteItem(properties.getProperty("dress-type")));
        softAssert.assertAll();
    }

    @Test(description = "Search a specific item")
    public void searchSpecificItem() throws Exception
    {
        homePage.doSearch(properties.getProperty("itemToSearch"));
        softAssert.assertAll();
    }
}
