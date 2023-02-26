package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertsPage extends Base {

    public AlertsPage () {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(className = "main-header")
    WebElement elementsHeader;
    public @FindBy(id ="alertButton") WebElement alertButton;
    public @FindBy (id = "timerAlertButton") WebElement timeAlertButton;
    public @FindBy (id = "confirmButton") WebElement confirmButton;
    public @FindBy (id ="promtButton") WebElement promptBoxButton;
    public @FindBy (id= "confirmResult") WebElement confirmaMessage;

    public @FindBy (className= "text-success") WebElement promptMessage;

    //-----------------------------------------

    public void AssertThatActionIsCanceled () {
        boolean message = false;
        try {
            message = alertsPage.promptMessage.isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(message);
    }
}
