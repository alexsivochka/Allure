import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Геометрия")
public class DescriptionExample {

    @Story("Площадь прямоугольника")
    @Description("Тест для проверки расчета площади прямоугольника")
    @Test
    public void checkAreaOfRectangle(){
        checkAreaOfRectangle(2,4,8);
    }

    private void checkAreaOfRectangle(int sideA, int sideB, int expArea) {
        int actualArea = sideA * sideB;
        Assert.assertEquals(actualArea, expArea);
    }

}
