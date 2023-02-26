package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class TextBoxPage extends Base {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public @FindBy (id= "submit") WebElement subminButton;

    public @FindBy(id = "userName")
    WebElement fullNameField;

    public @FindBy(id = "userEmail")
    WebElement emailField;

    public @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    public @FindBy(id = "permanentAddress")
    WebElement peremanentAddressField;


    public List<WebElement> getTextBoxMessage() {
        return driver.findElements(By.className("mb-1"));
    }

    //---------------------------------------------------------------------------------------------------------

    public void insertFullName(String fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(fullName);
    }

    public void insertNumberFullName(int fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(String.valueOf(fullName));
    }

    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void insertPeremanentAddress(String peremanentAddress) {
        peremanentAddressField.clear();
        peremanentAddressField.sendKeys(peremanentAddress);
    }

    public void assertThatDataIsNotAdded (){
        boolean message = false;
        try {
            message = textBoxPage.getTextBoxMessage().get(0).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(message);
    }

}