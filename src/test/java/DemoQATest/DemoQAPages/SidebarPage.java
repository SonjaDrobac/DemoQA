package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SidebarPage extends Base {
    public SidebarPage () {
        PageFactory.initElements(driver, this);
    }
    List<WebElement> buttons;
    public List<WebElement> getButtons() {
        return driver.findElements(By.className("text"));
    }

    //-------------------------------

    public void clickOnButton(String name) {
        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals(name)) {
                getButtons().get(i).click();
                break;
            }
        }
    }

}
