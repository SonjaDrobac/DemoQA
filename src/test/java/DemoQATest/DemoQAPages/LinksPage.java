package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class LinksPage extends Base {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    List<WebElement> links;

    public List<WebElement> getLinks() {
        return driver.findElements(By.id("linkWrapper"));
    }

    public @FindBy(id = "simpleLink")
    WebElement homeLink;

    public @FindBy(id = "dynamicLink")
    WebElement seconHomeLink;

    public @FindBy(id = "created")
    WebElement createLink;

    public @FindBy(id = "no-content")
    WebElement noContetnLink;

    public @FindBy(id = "moved")
    WebElement movedLink;

    public @FindBy(id = "bad-request")
    WebElement badRequestLink;

    public @FindBy(id = "unauthorized")
    WebElement unauthorizedLink;

    public @FindBy(id = "forbidden")
    WebElement fobidenLink;

    public @FindBy(id = "invalid-url")
    WebElement notFoundLink;

    public @FindBy(id = "linkResponse")
    WebElement linkResponse;
    //----------------------------------------------------------------
    public String getLinkResponse() {
        return linkResponse.getText();
    }

}
