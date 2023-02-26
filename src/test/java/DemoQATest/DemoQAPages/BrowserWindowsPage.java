package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends Base {

    public BrowserWindowsPage () {
        PageFactory.initElements(driver, this);
    }
    public @FindBy(className = "main-header")
    WebElement elementsHeader;
    public @FindBy(id = "tabButton") WebElement newTabButton;
    public @FindBy (id = "windowButton") WebElement newWindowButton;
    public @FindBy (id = "messageWindowButton") WebElement newPopUpMessageButton;
    public @FindBy (tagName = "body") WebElement popUpMessageWindow;

    public @FindBy (css = ".col-12.mt-4.col-md-6") WebElement blankPartOfWindow;
    public @FindBy (id ="sampleHeading") WebElement sampleHeading;

}
