package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class ButtonsPage extends Base {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;

    public @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;

    public @FindBy(id = "etlNn")
    WebElement clickMeButton;

    public List<WebElement> getButtons() {
        return driver.findElements(By.cssSelector(".btn.btn-primary"));
    }

    public @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public @FindBy(id = "dynamicClickMessage")
    WebElement clickMeMessage;

    public @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMeMesage;


    //--------------Buttons---------------------------------------

    public void clickDoubleClickMeBtn() {

        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals("Double Click Me")) {
                getButtons().get(i).click();
                break;
            }
        }
    }

    public void clickRightClickMeBtn() {
        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals("Right Click Me")) {
                getButtons().get(i).click();
                break;
            }
        }
    }

    public void clickClickMeBtn() {
        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals("Click Me")) {
                getButtons().get(i).click();
                break;
            }
        }
    }


}
