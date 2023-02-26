package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class BrokenLinksPage extends Base {

    public BrokenLinksPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[1]")
    WebElement validImage;

    @FindBy(css = "a[href = 'http://demoqa.com'] ")
    public WebElement validLink;

    @FindBy(css = "a[href = 'http://the-internet.herokuapp.com/status_codes/500")
    public WebElement invalidLink;

    @FindBy(css = "img[src = '/images/Toolsqa_1.jpg']")
    public WebElement brokenImage;


}
