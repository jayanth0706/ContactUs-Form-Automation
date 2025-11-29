package listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // attach test start info
        Allure.addAttachment("Test Started", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Attach failure reason
        Allure.addAttachment("Failure Reason", result.getThrowable().toString());

        // Attach screenshot
        saveScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        try {
            return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return null;
        }
    }
}
