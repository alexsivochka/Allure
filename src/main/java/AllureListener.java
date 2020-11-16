import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Paths;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public final class AllureListener implements ITestListener {
        @Override
        public void onTestStart(final ITestResult result) {}

        @Override
        public void onTestSuccess(final ITestResult result) {}

        @Override
        public void onTestFailure(final ITestResult result) {
            try {
                screenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onTestSkipped(final ITestResult result) {
            try {
                screenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
            try {
                screenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStart(final ITestContext context) {}

        @Override
        public void onFinish(final ITestContext context) {}

    @Attachment(type = "image/png")
    public static byte[] screenshot() throws IOException {
        if (getWebDriver() != null) {
            return Files.toByteArray(Screenshots.takeScreenShotAsFile());
        } else return null;
    }

    @Attachment(value = "Uploaded file", type = "application/json")
    public static byte[] getFile(String resourceName) {
        try {
            return java.nio.file.Files.readAllBytes(Paths.get("src/main/resources", resourceName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
