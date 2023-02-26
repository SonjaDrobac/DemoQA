package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class UploadAndDownloadPage extends Base {

    public UploadAndDownloadPage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(className = "main-header")
    WebElement elementsHeader;

    public @FindBy(id = "uploadFile")
    WebElement chooseFileButton;

    public @FindBy(id = "downloadButton")
    WebElement downloadButton;

    public @FindBy (id = "uploadedFilePath")
    WebElement uploadedFileaMessage;

    //--------------UploadAndDownload------------------------------------

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean result = false;
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                dirContents[i].exists();
                result = true;
                break;} }
        return result; }


}
