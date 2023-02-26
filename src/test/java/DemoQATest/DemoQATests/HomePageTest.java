package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class HomePageTest extends Base {

    @BeforeClass
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
    }

    @Test
    public void webElementsAreVisible () {
        Assert.assertTrue(homePage.headerButton.isDisplayed());
        Assert.assertTrue(homePage.baner.isDisplayed());
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        Assert.assertEquals(homePage.getCards().size(), 6);

    }

    @Test
    public void headerButtonIsClickable ()  {
        homePage.clickOnHeaderButton();
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        Assert.assertTrue(homePage.headerButton.isDisplayed());
        Assert.assertTrue(homePage.baner.isDisplayed());
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        Assert.assertEquals(homePage.getCards().size(), 6);
    }

    @Test
    public void banerElementAreClickable ()  {
        homePage.clickOnBaner();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Assert.assertEquals
                (driver.getCurrentUrl(), excelReader.getStringData("URL", 1,1));
    }

    @Test
    public void cardElementsIsClickable ()  {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,2));
    }

    @Test
    public void cardFormsIsClickable () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnForms();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,3));
    }

    @Test
    public void cardAlertsIsClickable () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnAlerts();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,4));
    }

    @Test
    public void cardWidgetsIsClickable () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnWidgets();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,5));
    }

    @Test
    public void cardInteractionsIsClickable () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnInteractions();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,6));
    }

    @Test
    public void cardBookstoreIsClickable () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnBookstore();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1,7));
    }

    @AfterMethod
    public void close () {
        driver.close();
    }
}
