package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class RadioButtonPage extends Base {

    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public List<WebElement> getRadioButtons() {
        return driver.findElements(By.className("custom-control-label"));
    }

    public @FindBy(className = "text-success")
    WebElement message;

    //------------------------------------------------------------

    public void clickYesRadioButton() {
        for (int i = 0; i < getRadioButtons().size(); i++) {
            getRadioButtons().get(0).click();
            break;
        }
    }

    public void clickImpressiveRadioButton() {
        for (int i = 0; i < getRadioButtons().size(); i++) {
            getRadioButtons().get(1).click();
            break;
        }
    }

    public void clickNoRadioButton() {
        for (int i = 0; i < getRadioButtons().size(); i++) {
            getRadioButtons().get(2).click();
            break;
        }
    }
}
