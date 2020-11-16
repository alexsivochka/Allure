import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Authorisation")
public class ParametrizedTest {

    @DataProvider(name = "userData")
    public Object[][] getData() {
        Object[][] userCreds = new Object[][]{
                {"Alex", "111"},
                {"Egor", "222"},
                {"Anton", "333"},
        };
        return userCreds;
    }

    @Story("User login")
    @Test(description = "Check user login", dataProvider = "userData")
    public void loginTest(String name, String pass){
        loginByUser(name, pass);
    }

    @Step("Имя пользователя - {name}. Пароль - {pass}")
    public void loginByUser(String name, String pass){
        System.out.printf("User name: %s. User password: %s\n", name, pass);
    }

}
