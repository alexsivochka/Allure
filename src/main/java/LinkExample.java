import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Геометрия")
public class LinkExample {

    @Story("Площадь прямоугольника")
    @Link(name = "Formula", url = "https://ru.onlinemschool.com/math/formula/area/#h3")
    @Test
    public void checkAreaOfRectangle(){
        checkAreaOfRectangle(2,4,8);
    }

    private void checkAreaOfRectangle(int sideA, int sideB, int expArea) {
        int actualArea = sideA * sideB;
        Assert.assertEquals(actualArea, expArea);
    }
}
