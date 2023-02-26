package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.BrokenLinksPage;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_7BrokenLinksTest extends Base {

    public void goToBrokenLinksSidebar () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        scrollIntoView(sidebarPage.getButtons().get(7));
        sidebarPage.clickOnButton("Broken Links - Images");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        brokenLinksPage = new BrokenLinksPage();
        sidebarPage = new SidebarPage();

    }

    @Test
    public void brokenLinksSidebar_IsClickable ()  {
        goToBrokenLinksSidebar();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/broken");
        Assert.assertEquals(brokenLinksPage.elementsHeader.getText(), "Broken Links - Images");
        brokenLinksPage.validImage.isDisplayed();
        brokenLinksPage.validLink.isDisplayed();
        brokenLinksPage.invalidLink.isDisplayed();
    }

    @Test
    public void brokenLinksSidebar_BrokenImageIsNotDisplayed () {
        goToBrokenLinksSidebar();
        Assert.assertTrue(brokenLinksPage.brokenImage.isEnabled());
    }

    @Test
    public void brokenLinksSidebar_ValidImageIsDisplayed () {
        goToBrokenLinksSidebar();
        Assert.assertTrue(brokenLinksPage.validImage.isDisplayed());
    }

    @Test
    public void brokenLinksSidebar_ValidLinkOpeningNewPage ()  {
        goToBrokenLinksSidebar();
        scrollIntoView(brokenLinksPage.validLink);
        brokenLinksPage.validLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                excelReader.getStringData("URL", 1,0));
    }

    @Test
    public void brokenLinksSidebar_InvalidLinkOpeningErrorPage () {
        goToBrokenLinksSidebar();
        scrollIntoView(brokenLinksPage.invalidLink);
        brokenLinksPage.invalidLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                excelReader.getStringData("URL", 1,9));

    }
    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
