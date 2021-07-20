package pages;

public class LoginPage {
    protected static final By loginButtonLocator = By.className("LoginButton");
    protected static final By userNameInputLocator = By.name("UserId");
    protected static final By passwordInputlocator = By.name("Password");
    protected static final By passwordErrorlocator = By.className("loginError");
    protected static final By forceLoginCheckboxLocator = By.xpath("//input[contains(@id,'forceLogin')]");
    protected static final By acceptLicenseAgreementButtonLocator = By.xpath("//input[@id='accept']");

    public void verify() {
        Assert.assertTrue(actions.isElementVisible(loginButtonLocator, false));
        Assert.assertTrue(actions.isElementVisible(userNameInputLocator));
        Assert.assertTrue(actions.isElementVisible(passwordInputlocator));
    }
    public LoginPage verifyLoginErrorMessage(String errorMessage) {
        Assert.assertEquals(actions.getText(passwordErrorlocator), errorMessage);
        return this;
    }

    public LoginPage setUserName(String userName) {
        actions.setText(userNameInputLocator, userName);
        return this;
    }
    public LoginPage clickLoginExpectFailure() {
        actions.click(loginButtonLocator);
        return this;
    }
    public NMHomePage loginExpectPass(String userName, String password) {
        actions.sleep(2000);
        verify();
        setUserName(userName);
        setPassword(password);
        clickLoginExpectSuccess();
        actions.sleep(2000);
        return new NMHomePage();
    }
    public void loginAsUser(String userName, String password) {
        actions.sleep(2000);
        verify();
        setUserName(userName);
        setPassword(password);
        driver.findElement(loginButtonLocator).click();
        actions.sleep(2000);
        if (actions.isElementVisible(forceLoginCheckboxLocator, true)) {
            setUserName(userName);
            setPassword(password);
            checkForceLogin();
            driver.findElement(loginButtonLocator).click();
            actions.sleep(2000);
        }
    }
}
