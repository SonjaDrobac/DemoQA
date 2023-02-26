package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Base {

    public HomePage () {
        PageFactory.initElements(driver, this);}

    List <WebElement> cards;

    public List<WebElement> getCards() {
        return driver.findElements(By.className("card-body"));
    }

    public @FindBy (xpath = "//*[@id=\"app\"]/header/a/img")
    WebElement headerButton;

    public @FindBy (className = "banner-image")
    WebElement baner;

    //----------------------------------

    public void clickOnElements() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Elements")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnForms() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Forms")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnAlerts() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Alerts, Frame & Windows")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnWidgets() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Widgets")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnInteractions() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Interactions")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnBookstore() {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals("Book Store Application")) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnCard(String cardName) {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals(cardName)) {
                getCards().get(i).click();
                break;
            }
        }
    }

    public void clickOnHeaderButton () {
        headerButton.click();
    }

    public void clickOnBaner () {
        baner.click();
    }



}
