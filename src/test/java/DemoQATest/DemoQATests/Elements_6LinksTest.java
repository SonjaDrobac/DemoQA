package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.LinksPage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Elements_6LinksTest extends Base {

    public void goToLinksSidebar () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Links");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        linksPage = new LinksPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void linksSidebar_IsClickable ()  {
        goToLinksSidebar();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/links");
        Assert.assertEquals(linksPage.elementsHeader.getText(), "Links");
        Assert.assertTrue(linksPage.getLinks().get(0).isDisplayed());
    }

    @Test
    public void linksSidebar_homeLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.homeLink.click();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Assert.assertEquals
                (driver.getCurrentUrl(), excelReader.getStringData("URL", 1,0));
    }

    @Test
    public void linksSidebar_secondHomeLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.seconHomeLink.click();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Assert.assertEquals
                (driver.getCurrentUrl(), excelReader.getStringData("URL", 1,0));
    }

    @Test
    public void linksSidebar_createLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.createLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 201 and status text Created");
    }

    @Test
    public void linksSidebar_noContentLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.noContetnLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 204 and status text No Content");
    }

    @Test
    public void linksSidebar_movedLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.movedLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test
    public void linksSidebar_badRequestLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.badRequestLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 400 and status text Bad Request");
    }

    @Test
    public void linksSidebar_unauthorizedLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.unauthorizedLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 401 and status text Unauthorized");
    }

    @Test
    public void linksSidebar_forbiddenLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.fobidenLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 403 and status text Forbidden");
    }

    @Test
    public void linksSidebar_notFoundLinkIsClickable ()  {
        goToLinksSidebar();
        linksPage.notFoundLink.click();
        wdwait.until(ExpectedConditions.visibilityOf(linksPage.linkResponse));
        Assert.assertEquals(linksPage.getLinkResponse(), "Link has responded with staus 404 and status text Not Found");
    }
    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
