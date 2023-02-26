package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.BrowserWindowsPage;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Alerts_1BrowserWindowsTest extends Base {

    public void goToBrowserWindowsSidebar () {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnAlerts();
        sidebarPage.clickOnButton("Browser Windows");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        browserWindowsPage = new BrowserWindowsPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void browserWindowsSidebar_isClickable () {
        goToBrowserWindowsSidebar();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/browser-windows");
        Assert.assertEquals(browserWindowsPage.elementsHeader.getText(), "Browser Windows");
        Assert.assertTrue(browserWindowsPage.newTabButton.isDisplayed());
        Assert.assertTrue(browserWindowsPage.newWindowButton.isDisplayed());
        Assert.assertTrue(browserWindowsPage.newPopUpMessageButton.isDisplayed());
    }

    @Test
    public void browserWindowsSidebar_newTabButtonIsClickable () {
        goToBrowserWindowsSidebar();
        browserWindowsPage.newTabButton.click();
        ArrayList<String> listaTabova= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Assert.assertEquals
                (driver.getCurrentUrl(), excelReader.getStringData("URL", 1,8));
    }

    @Test
    public void browserWindowsSidebar_newWindowButtonIsClickable () {
        goToBrowserWindowsSidebar();
        browserWindowsPage.newWindowButton.click();
        ArrayList<String> windowList= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        Assert.assertEquals
                (driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 8));
        Assert.assertEquals(browserWindowsPage.sampleHeading.getText(), "This is a sample page");
    }

    @Test
    public void browserWindowSidebar_newWindowMessageButtonIsClickable  ()  {
        goToBrowserWindowsSidebar();
        browserWindowsPage.newPopUpMessageButton.click();
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                System.out.println("Child window closed");
            }}
    }
    

    @AfterMethod
    public void close () {
        driver.close();
    }


}
