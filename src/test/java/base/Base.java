package base;

import listeners.AllureListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExcelReader;

public class Base {

    public WebDriver driver;
    public String excelPath = "Resources/TestData.xlsx";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        AllureListener.setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://ns-constructions.vercel.app/contact");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "contactData")
    public Object[][] getContactData() {
        return ExcelReader.getExcelData(excelPath, "Sheet1");
    }
}
