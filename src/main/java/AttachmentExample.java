import io.qameta.allure.Attachment;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners(AllureListener.class)
public class AttachmentExample {

    @Test
    public void googleSearch(){
        open("https://google.com");
        $("[name='q']").shouldBe(visible, enabled)
                .setValue("Allure report - Allure Framework")
                .pressEnter();
        $("div.rc h3").shouldHave(text("test"));
    }


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


}
