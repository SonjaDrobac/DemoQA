package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.AlertsPage;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Alerts_2Alerts extends Base {

    String promptBoxText= "Sonja";

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        alertsPage = new AlertsPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void alertsSidebar_isClickable () {
        driver.get("https://demoqa.com/alerts");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/alerts");
        Assert.assertEquals(alertsPage.elementsHeader.getText(), "Alerts");
        Assert.assertTrue(alertsPage.alertButton.isDisplayed());
        Assert.assertTrue(alertsPage.confirmButton.isDisplayed());
        Assert.assertTrue(alertsPage.promptBoxButton.isDisplayed());
        Assert.assertTrue(alertsPage.timeAlertButton.isDisplayed());
    }

    @Test
    public void browserWindowsSidebar_ClickAlertIsClickable () {
        driver.get("https://demoqa.com/alerts");
        alertsPage.alertButton.click();
        Alert alert = driver.switchTo().alert();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        alert.accept();
    }

    @Test
    public void browserWindowsSidebar_TimeAlertIsClickable () throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        alertsPage.timeAlertButton.click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        alert.accept();
    }

    @Test
    public void browserWindowsSidebar_UserCanConfrimAction ()  {
        driver.get("https://demoqa.com/alerts");
        alertsPage.confirmButton.click();
        Alert alert = driver.switchTo().alert();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        alert.accept();
        Assert.assertEquals(alertsPage.confirmaMessage.getText(), "You selected Ok");
    }

    @Test
    public void browserWindowsSidebar_UserCanCancelAction ()  {
        driver.get("https://demoqa.com/alerts");
        alertsPage.confirmButton.click();
        Alert alert = driver.switchTo().alert();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        alert.dismiss();
        Assert.assertEquals(alertsPage.confirmaMessage.getText(), "You selected Cancel");
    }

    @Test
    public void browserWindowsSidebar_UserCanEnterNameInPromptBox ()  {
        driver.get("https://demoqa.com/alerts");
        alertsPage.promptBoxButton.click();
        Alert alert = driver.switchTo().alert();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        alert.sendKeys(promptBoxText);
        alert.accept();
        Assert.assertEquals(alertsPage.promptMessage.getText(), "You entered " + promptBoxText);
    }

    @Test
    public void browserWindowsSidebar_UserCanCancelActionEnteringNameInPromptBox ()  {
        driver.get("https://demoqa.com/alerts");
        alertsPage.promptBoxButton.click();
        Alert alert = driver.switchTo().alert();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        alert.sendKeys(promptBoxText);
        alert.dismiss();
        alertsPage.AssertThatActionIsCanceled();
    }

    @AfterMethod
    public void close () {
        driver.close();
    }
}
