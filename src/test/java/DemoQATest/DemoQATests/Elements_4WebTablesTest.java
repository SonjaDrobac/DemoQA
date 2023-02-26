package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import DemoQATest.DemoQAPages.WebtablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_4WebTablesTest extends Base {

    public void goToWebTables() {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size() - 1));
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Web Tables");
    }



    @BeforeMethod
    public void PageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        webtablesPage= new WebtablesPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void webTablesSidebar_IsClickable() {
        goToWebTables();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/webtables");
        Assert.assertEquals(webtablesPage.elementsHeader.getText(), "Web Tables");
        Assert.assertTrue(webtablesPage.addButton.isDisplayed());
    }

    @Test
    public void webTablesSidebar_addNewUserWithFullData() {
        goToWebTables();
        webtablesPage.addNewUser_FullData();
        webtablesPage.submitButton.click();
        webtablesPage.assertThatUserIsAdded();
    }

    @Test
    public void webTablesSidebar_UserCantBeAdded_WithBlankField() {
        goToWebTables();
        webtablesPage.addButton.click();
        webtablesPage.submitButton.click();
        Assert.assertTrue(webtablesPage.registrationFormField.isDisplayed());
        webtablesPage.closeButtonRegistrationForm.click();
    }

    @Test
    public void webTablesSidebar_UserCantBeAdded_IfOneDataIsMissing() {
        goToWebTables();
        for (int i =0; i<6; i++) {
            webtablesPage.addNewUser_FullData();
            webtablesPage.getUserFormFields().get(i).clear();
            webtablesPage.submitButton.click();
            webtablesPage.closeButtonRegistrationForm.click();
            boolean findUser = false;
            try {
                for (int n = 1; n < webtablesPage.getTable().size(); n++) {
                    if (webtablesPage.getTable().get(n).getText().
                            equals(excelReader.getStringData("WebTableData", 1, 1))) {
                        Assert.assertEquals(webtablesPage.getTable().get(n - 1).getText(),
                                excelReader.getStringData("WebTableData", n, 1));
                        findUser = true;
                    }
                    break; }}
            catch (Exception e) {
            }
            Assert.assertFalse(findUser);
        }}


    @Test
    public void webTablesSidebar_UserCanSearchData() {
        goToWebTables();
        webtablesPage.addNewUser_FullData();
        webtablesPage.submitButton.click();
        webtablesPage.assertThatUserIsAdded();
        for (int i =0; i<6; i++) {
            webtablesPage.searchBox.clear();
            if (i==0 || i==1 || i==2 || i==5) {
                webtablesPage.searchUser(excelReader.getStringData
                        ("WebTableData", i+1, 1));
                webtablesPage.assertThatUserIsAdded();
            } else if (i==3 || i==4) {
                webtablesPage.searchUser
                        (String.valueOf(excelReader.getIntegerData
                                ("WebTableData", i+1, 1)));
               webtablesPage.assertThatUserIsAdded();
                } } }

    @Test
    public void webTableSidebar_UserCantSearchNonExistingData () {
        String nonExistingData = "SonjaSonja";
        goToWebTables();
        webtablesPage.searchUser(nonExistingData);
        boolean findUser = false;
            try {
                for (int i = 1; i < webtablesPage.getTable().size(); i++) {
                    if (webtablesPage.getTable().get(i).getText().equals(nonExistingData)) {
                        findUser = true;
                    }
                    break;
                }
            } catch (Exception e) {
            }
            Assert.assertFalse(findUser);
        }

    @Test
    public void webTablesSidebar_UserCanEditData () {
        goToWebTables();
        webtablesPage.addNewUser_FullData();
        webtablesPage.submitButton.click();
        webtablesPage.assertThatUserIsAdded();
        webtablesPage.searchUser(excelReader.getStringData("WebTableData", 1, 1));
        webtablesPage.editButton.click();
        webtablesPage.insertLastName(excelReader.getStringData("WebTableData", 2, 2));
        webtablesPage.insertWebTableEmail(excelReader.getStringData("WebTableData", 3, 2));
        webtablesPage.submitButton.click();
        for (int i = 1; i < webtablesPage.getTable().size(); i++) {
            if (webtablesPage.getTable().get(i).getText().
                    equals(excelReader.getStringData("WebTableData", 1, 2))) {
                Assert.assertEquals(webtablesPage.getTable().get(i - 1).getText(),
                        excelReader.getStringData("WebTableData", i, 2));
            }
            break;
        }}

    @Test
    public void webTablesSidebar_UserCanDeleteData() {
        goToWebTables();
        webtablesPage.addNewUser_FullData();
        webtablesPage.submitButton.click();
        webtablesPage.searchUser(excelReader.getStringData("WebTableData", 1, 1));
        webtablesPage.assertThatUserIsAdded();
        webtablesPage.deleteButton.click();
        boolean findUser = false;
        try {
            for (int i = 1; i < webtablesPage.getTable().size(); i++) {
                if (webtablesPage.getTable().get(i).getText().
                        equals(excelReader.getStringData("WebTableData", 1, 1))) {
                    findUser = true;
                }
                break;
            }
        } catch (Exception e) {
        }
        Assert.assertFalse(findUser);
    }

    @Test
    public void webTables_verifyMinimumRowsPerPage() {
        goToWebTables();
        webtablesPage.selectRowsPerPage(webtablesPage.rowsPerPage, "5");
        Assert.assertEquals(webtablesPage.getTable().size(), 5);
    }

    @Test
    public void webTables_verifyMaximumRowsPerPage() {
        goToWebTables();
        webtablesPage.selectRowsPerPage(webtablesPage.rowsPerPage, "100");
        Assert.assertEquals(webtablesPage.getTable().size(), 100);
    }

    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
