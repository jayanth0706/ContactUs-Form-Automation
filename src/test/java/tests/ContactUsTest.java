package tests;

import base.Base;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends Base {

    @Test(dataProvider = "contactData", dataProviderClass = Base.class)
    public void verifyContactUsForm(String fullName, String phone, String email, String project, String message) throws Exception {

        ContactUsPage cp = new ContactUsPage(driver);

        cp.enterFullName(fullName);
        cp.enterPhone(phone);
        cp.enterEmail(email);
        cp.selectProject(project);
        cp.enterMessage(message);

        cp.clickSend();

        // Wait 5 seconds for popup
        Thread.sleep(5000);

        try {
            Alert alert = driver.switchTo().alert();
            String popupText = alert.getText();

            Assert.assertTrue(
                    popupText.contains("Thank you"),
                    "Popup did NOT appear or missing expected text!"
            );

            alert.accept();

            //      VALIDATION SECTION

            StringBuilder errorLog = new StringBuilder();

            // 1) FULL NAME VALIDATION -> Rule: Only letters + spaces
            if (!fullName.matches("[A-Za-z ]+")) {
                errorLog.append("❌ Full Name Validation Failed\n")
                        .append("Entered Value: ").append(fullName).append("\n")
                        .append("Rule: Only alphabets and spaces allowed.\n\n");
            }

            // 2) PHONE NUMBER VALIDATION -> Rule: Must be EXACT 10 digits only
            if (!phone.matches("\\d{10}")) {
                errorLog.append("❌ Phone Number Validation Failed\n")
                        .append("Entered Value: ").append(phone).append("\n")
                        .append("Rule: Only digits allowed & must be exactly 10 digits.\n\n");
            }

            // 3) EMAIL VALIDATION -> Rule: Standard Email Pattern
            if (!email.matches("^[a-z0-9.]+@[a-z.]+\\.[A-Za-z]{2,3}$")) {
                errorLog.append("❌ Email Validation Failed\n")
                        .append("Entered Value: ").append(email).append("\n")
                        .append("Rule: Must be a valid email format (e.g., name@gmail.com)\n\n");
            }

            // 4) MESSAGE VALIDATION -> Rule: Only letters, numbers, spaces, and @ allowed
            if (!message.matches("[A-Za-z0-9 @]+")) {
                errorLog.append("❌ Message Validation Failed\n")
                        .append("Entered Value: ").append(message).append("\n")
                        .append("Rule: Only alphabets, numbers, spaces, and @ allowed.\n\n");
            }

            // FINAL DECISION
            if (errorLog.length() > 0) {

                // Attach full detailed validation report to Allure
                Allure.addAttachment("Validation Errors", errorLog.toString());

                // Screenshot attached
                listeners.AllureListener listener = new listeners.AllureListener();
                listener.saveScreenshot();

                Assert.fail("One or more validations FAILED.\n\n" + errorLog);
            }

        } catch (Exception e) {
            Assert.fail("Popup did NOT appear within 5 seconds!", e);
        }

    }
}
