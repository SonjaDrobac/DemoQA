package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import DemoQATest.DemoQAPages.UploadAndDownloadPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_8UploadTest extends Base {

    public void goToUploadAndDownloadSidebar ()  {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        scrollIntoView(sidebarPage.getButtons().get(7));
        sidebarPage.clickOnButton("Upload and Download");
    }

    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        upAndDownPage = new UploadAndDownloadPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void uploadSidebar_IsClickable () {
        goToUploadAndDownloadSidebar();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/upload-download");
        Assert.assertEquals(upAndDownPage.elementsHeader.getText(), "Upload and Download");
        Assert.assertTrue(upAndDownPage.chooseFileButton.isDisplayed());
        Assert.assertTrue(upAndDownPage.downloadButton.isDisplayed());
    }

    @Test
    public void uploadSidebar_fileCanBeDownloaded ()  {
        goToUploadAndDownloadSidebar();
        upAndDownPage.downloadButton.click();
        Assert.assertTrue(upAndDownPage.isFileDownloaded
                ("C:\\Users\\djuro\\Downloads","sampleFile.jpeg" ));
    }

    @Test
    public void uploadSidebar_fileCanBeUploaded () throws InterruptedException {
        goToUploadAndDownloadSidebar();
        String pictureLocation= "C:\\Users\\djuro\\Downloads\\";
        String fileName = "Zw9tP7.jpg";
        Thread.sleep(5000);
        upAndDownPage.chooseFileButton.sendKeys(pictureLocation+fileName);
        Assert.assertEquals(upAndDownPage.uploadedFileaMessage.getText(), "C:\\fakepath\\"+fileName);

    }
    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
