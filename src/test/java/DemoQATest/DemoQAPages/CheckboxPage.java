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

public class CheckboxPage extends Base {

    public CheckboxPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public @FindBy(css = ".rct-option.rct-option-expand-all")
    WebElement expandAllButton;

    public @FindBy(css = ".rct-option.rct-option-collapse-all")
    WebElement collapseAllButton;

    public List<WebElement> getCheckBoxItems() {
        return driver.findElements(By.className("rct-title"));
    }

    public List<WebElement> getCheckedMessage() {
        return driver.findElements(By.className("text-success"));
    }

    public @FindBy(id = "submit")
    WebElement submitButton;

    //---------------------------------------------------------------------------------------------------------

    public void clickOnCheckBoxItem(String name) {
        for (int i = 0; i < getCheckBoxItems().size(); i++) {
            if (getCheckBoxItems().get(i).getText().equals(name)) {
                getCheckBoxItems().get(i).click();
                break;
            } } }

    public void clickOnCheckBoxItems(String name) {
        for (int i = 0; i < getCheckBoxItems().size(); i++) {
            if (getCheckBoxItems().get(i).getText().equals(name)) {
                getCheckBoxItems().get(i).click();
            }
            continue;
        }  }





}
