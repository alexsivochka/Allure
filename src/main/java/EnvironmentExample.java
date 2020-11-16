import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.System.getProperty;
import static java.util.Optional.ofNullable;

public class EnvironmentExample {

    @Test
    public void uploadFileTest(){
        File file = new File("src/main/resources/upload.json");
        open("http://the-internet.herokuapp.com/upload");
        $("#file-upload").should(exist).uploadFile(file);
        $("#file-submit").shouldBe(visible, enabled).click();
        $x("//h3").should(appear).shouldHave(text("File Uploaded!"));
        $("div#uploaded-files").shouldBe(visible).shouldHave(text(file.getName()));
        AllureListener.getFile("upload.json");
    }

    @AfterSuite(alwaysRun = true)
    public void createEnvironmentProps() {
        FileOutputStream fos = null;
        try {
            Properties props = new Properties();
            fos = new FileOutputStream("target/allure-results/environment.properties");

            ofNullable(getProperty("os.name")).ifPresent(s -> props.setProperty("os.name", s));
            ofNullable(getProperty("os.version")).ifPresent(s -> props.setProperty("os.version", s));
            ofNullable(getProperty("os.arch")).ifPresent(s -> props.setProperty("os.arch", s));
            ofNullable(getProperty("java.version")).ifPresent(s -> props.setProperty("java.version", s));

            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fos);
        }
    }

}
