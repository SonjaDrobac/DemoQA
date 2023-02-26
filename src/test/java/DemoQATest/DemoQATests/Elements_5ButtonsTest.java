package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.ButtonsPage;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_5ButtonsTest extends Base {

    public void goToButtonsSidebar () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Buttons");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        buttonsPage = new ButtonsPage();
        sidebarPage = new SidebarPage();

    }

    @Test
    public void buttonsSidebar_IsClickable ()  {
        goToButtonsSidebar();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/buttons");
        Assert.assertEquals(buttonsPage.elementsHeader.getText(), "Buttons");
    }

    @Test
    public void buttonsSidebar_doubleClickButtonIsClickable () {
        Actions act = new Actions(driver);
        goToButtonsSidebar();
        act.doubleClick(buttonsPage.doubleClickButton).perform();
        Assert.assertEquals(buttonsPage.doubleClickMeMesage.getText(), "You have done a double click");
    }

    @Test
    public void buttonsSidebar_rightClickButtonIsClickable () {
        Actions act = new Actions(driver);
        goToButtonsSidebar();
        act.contextClick(buttonsPage.rightClickButton).perform();
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), "You have done a right click");
    }

    @Test
    public void buttonsSidebar_clickMeButtonIsClickable () {
        goToButtonsSidebar();
        buttonsPage.clickClickMeBtn();
        Assert.assertEquals(buttonsPage.clickMeMessage.getText(), "You have done a dynamic click");
    }

    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
