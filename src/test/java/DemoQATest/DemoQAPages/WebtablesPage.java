package DemoQATest.DemoQAPages;

import DemoQATest.DemoQABase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class WebtablesPage extends Base {

    public WebtablesPage() {
        PageFactory.initElements(driver, this);
    }


    public @FindBy(className = "main-header")
    WebElement elementsHeader;
    public @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    public @FindBy(id = "firstName")
    WebElement webTableFirstName;

    public @FindBy(id = "lastName")
    WebElement webTableLastName;

    public @FindBy(id = "userEmail")
    WebElement webTableUserEmail;

    public @FindBy(id = "age")
    WebElement webTableAgeFiled;

    public @FindBy(id = "salary")
    WebElement webTableSalaryField;

    public @FindBy(id = "department")
    WebElement webTableDepartmentFiled;

    public @FindBy(id = "submit")
    WebElement submitButton;

    public List<WebElement> getTable() {
        return driver.findElements(By.cssSelector(".col-md-6.col-sm-6"));
    }

    public @FindBy(id = "searchBox")
    WebElement searchBox;

    public @FindBy(id = "userForm")
    WebElement registrationFormField;

    public List<WebElement> getUserFormFields() {
        return driver.findElements(By.cssSelector(".mr-sm-2.form-control"));
    }

    public @FindBy(className = "close")
    WebElement closeButtonRegistrationForm;

    public @FindBy(id = "edit-record-4")
    WebElement editButton;

    public @FindBy(id = "delete-record-4")
    WebElement deleteButton;

    public List<WebElement> getDeleteButtons() {
        return driver.findElements(By.className("action-buttons"));
    }

    public @FindBy(css = "select[aria-label = 'rows per page']")
    WebElement rowsPerPage;

    //--------------WebTables------------------------------------------------------

    public void insertFirstName(String firstname) {
        webTableFirstName.clear();
        webTableFirstName.sendKeys(firstname);
    }

    public void insertLastName(String lastname) {
        webTableLastName.clear();
        webTableLastName.sendKeys(lastname);
    }

    public void insertWebTableEmail(String email) {
        webTableUserEmail.clear();
        webTableUserEmail.sendKeys(email);
    }

    public void insertAge(int age) {
        webTableAgeFiled.clear();
        webTableAgeFiled.sendKeys(String.valueOf(age));
    }

    public void insertSalary(int salary) {
        webTableSalaryField.clear();
        webTableSalaryField.sendKeys(String.valueOf(salary));

    }

    public void insertDepartment(String departmet) {
        webTableDepartmentFiled.clear();
        webTableDepartmentFiled.sendKeys(departmet);
    }

    public void searchUser(String searcElement) {
        searchBox.sendKeys(searcElement);
    }

    public void selectRowsPerPage(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    public void addNewUser_FullData() {
        addButton.click();
        insertFirstName(excelReader.getStringData("WebTableData", 1, 1));
        insertLastName(excelReader.getStringData("WebTableData", 2, 1));
        insertWebTableEmail(excelReader.getStringData("WebTableData", 3, 1));
        insertAge(excelReader.getIntegerData("WebTableData", 4, 1));
        insertSalary(excelReader.getIntegerData("WebTableData", 5, 1));
        insertDepartment(excelReader.getStringData("WebTableData", 6, 1));
    }

    public void assertThatUserIsAdded() {
        for (int n = 1; n < getTable().size(); n++) {
            if (getTable().get(n).getText().
                    equals(excelReader.getStringData("WebTableData", 1, 1))) {
                Assert.assertEquals(getTable().get(n - 1).getText(),
                        excelReader.getStringData("WebTableData", n, 1));
            } break;
        }}

}
