package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    By fullName = By.xpath("//label[contains(text(),'Full Name')]/following-sibling::input");
    By phone = By.xpath("//label[contains(text(),'Phone Number')]/following-sibling::input");
    By email = By.xpath("//label[contains(text(),'Email Address')]/following-sibling::input");
    By projectInterest = By.xpath("//label[contains(text(),'Project Interest')]/following-sibling::select");
    By message = By.xpath("//label[contains(text(),'Message')]/following-sibling::textarea");
    By sendBtn = By.xpath("//button[.//span[text()='Send Message']]");

    public void enterFullName(String val) { driver.findElement(fullName).sendKeys(val); }
    public void enterPhone(String val) { driver.findElement(phone).sendKeys(val); }
    public void enterEmail(String val) { driver.findElement(email).sendKeys(val); }

    public void selectProject(String option) {
        WebElement dropdown = driver.findElement(projectInterest);

        // small smooth scroll
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        try { Thread.sleep(300); } catch (Exception e) {}

        new Select(dropdown).selectByVisibleText(option);
    }


    public void enterMessage(String val) { driver.findElement(message).sendKeys(val); }
    public void clickSend() {
        WebElement btn = driver.findElement(sendBtn);

        // small scroll so button becomes visible
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        try { Thread.sleep(300); } catch (Exception e) {}

        try {
            btn.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        }
    }


}
