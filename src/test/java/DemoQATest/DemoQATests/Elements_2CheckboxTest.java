package DemoQATest.DemoQATests;

import DemoQATest.DemoQABase.Base;
import DemoQATest.DemoQAPages.CheckboxPage;
import DemoQATest.DemoQAPages.HomePage;
import DemoQATest.DemoQAPages.SidebarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Elements_2CheckboxTest extends Base {

    public void goToCheckBox() {
        scrollIntoView(homePage.getCards().get(homePage.getCards().size()-1));
        homePage.clickOnElements();
        sidebarPage.clickOnButton("Check Box");
    }

    public void assertThatAllItemsAreSelected () {
        for (int i =1; i<checkboxPage.getCheckedMessage().size(); i++) {
            Assert.assertEquals(checkboxPage.getCheckedMessage().get(i-1).getText(),
                    excelReader.getStringData("CheckedBoxMessage", i,0));
        }}

    public void selectEachItem () {
        for (int i=1; i<=excelReader.getLastRow("CheckedBoxData"); i++) {
            checkboxPage.clickOnCheckBoxItems(excelReader.getStringData("CheckedBoxData", i, 0));
        }}

    public void assertThatItemsAreUnselected () {
        boolean message = false;
        try {
            message = checkboxPage.getCheckedMessage().get(0).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(message);
    }


    @BeforeMethod
    public void PageSetUp () {
        driver= new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        checkboxPage=new CheckboxPage();
        sidebarPage = new SidebarPage();
    }

    @Test
    public void checkBoxSidebar_IsClickable ()  {
        goToCheckBox();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");
        Assert.assertEquals(checkboxPage.elementsHeader.getText(), "Check Box");
        Assert.assertTrue(checkboxPage.expandAllButton.isDisplayed());
        Assert.assertTrue(checkboxPage.collapseAllButton.isDisplayed());
    }

    @Test
    public void checkBoxSidebar_expandAllButtonIsClickable ()  {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        Assert.assertEquals(checkboxPage.getCheckBoxItems().size(), 17);
        Assert.assertTrue(checkboxPage.expandAllButton.isDisplayed());
        Assert.assertTrue(checkboxPage.collapseAllButton.isDisplayed());
    }

    @Test
    public void checkBoxSidebar_collapseAllButtonIsClickable ()  {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        Assert.assertEquals(checkboxPage.getCheckBoxItems().size(), 17);
        checkboxPage.collapseAllButton.click();
        Assert.assertEquals(checkboxPage.getCheckBoxItems().size(), 1);
        Assert.assertTrue(checkboxPage.expandAllButton.isDisplayed());
        Assert.assertTrue(checkboxPage.collapseAllButton.isDisplayed());
    }
    @Test
    public void checkBoxSidebar_UserCanSelectOneItem () {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        checkboxPage.clickOnCheckBoxItem("Commands");
        Assert.assertEquals(checkboxPage.getCheckedMessage().get(0).getText(), "commands");
    }

    @Test
    public void checkBoxSidebar_UserCanSelectAllItems_ByHomeButton () {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        checkboxPage.clickOnCheckBoxItem("Home");
        assertThatAllItemsAreSelected();
    }

    @Test
    public void checkBoxSidebar_UserCanSelectAllItems_ByClickingOnEachItem () {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        selectEachItem();
        assertThatAllItemsAreSelected();
    }

    @Test
    public void checkBoxSiderbar_UserCanUnselectOneItem () {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        checkboxPage.clickOnCheckBoxItem("Commands");
        Assert.assertEquals(checkboxPage.getCheckedMessage().get(0).getText(), "commands");
        checkboxPage.clickOnCheckBoxItem("Commands");
        assertThatItemsAreUnselected();
    }

    @Test
    public void checkBoxSidebar_UserCanUnselectAllItems_ByHomeButton () {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        checkboxPage.clickOnCheckBoxItem("Home");
        assertThatAllItemsAreSelected();
        checkboxPage.clickOnCheckBoxItem("Home");
        assertThatItemsAreUnselected();
    }

    @Test
    public void checkBoxSidebar_UserCanUnselectAllItems_ByClickingOnEachItem () {
        goToCheckBox();
        checkboxPage.expandAllButton.click();
        selectEachItem();
        assertThatAllItemsAreSelected();;
        selectEachItem();
        assertThatItemsAreUnselected();
    }


    @AfterMethod
    public void close () {
        driver.manage().deleteAllCookies();
        driver.close();
    }


}
