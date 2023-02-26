package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class DynamicsPropertiesPage extends Base {

    public DynamicsPropertiesPage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public @FindBy(id = "colorChange")
    WebElement colorchangeButton;

    public @FindBy(id = "enableAfter")
    WebElement willEnableButton;

    public @FindBy(id = "visibleAfter")
    WebElement visibleAfterButton;


}
