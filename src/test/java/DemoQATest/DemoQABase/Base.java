package DemoQATest.DemoQABase;

import DemoQATest.DemoQAPages.*;
import UPripremi.Pages.FramesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Base {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homeURL;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public CheckboxPage checkboxPage;
    public RadioButtonPage radioButtonPage;
    public WebtablesPage webtablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksPage brokenLinksPage;
    public UploadAndDownloadPage upAndDownPage;
    public DynamicsPropertiesPage dynamicsPage;
    public BrowserWindowsPage browserWindowsPage;
    public AlertsPage alertsPage;

    public FramesPage framesPage;

    @BeforeClass
    public void SetUpPage () throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("src/test/java/DemoQATest/DemoQAData.xlsx");
        homeURL=excelReader.getStringData("URL", 1, 0);

    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }



}
