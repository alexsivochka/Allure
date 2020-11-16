import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeverityExample {

    @Epic("Геометрия")
    public class DescriptionExample {

        @Feature("Площадь фигур")
        @Story("Площадь прямоугольника")
        @Severity(SeverityLevel.CRITICAL)
        @Test
        public void checkAreaOfRectangle() {
            checkAreaOfRectangle(2, 4, 8);
        }

        @Feature("Площадь фигур")
        @Severity(SeverityLevel.MINOR)
        @Story("Площадь трапеции")
        @Test
        public void checkAreaOfTrapeze(){
            checkAreaOfTrapeze(2, 4, 2,6);
        }

//        @Feature("Площадь фигур")
//        @Story("Площадь трапеции")
//        @Test
//        public void checkAreaOfTrapeze1(){
//            checkAreaOfTrapeze(2, 4, 2,6);
//        }

        private void checkAreaOfRectangle(int sideA, int sideB, int expArea) {
            int actualArea = sideA * sideB;
            Assert.assertEquals(actualArea, expArea);
        }

        private void checkAreaOfTrapeze(int sideA, int sideB, int h, int expArea) {
            int actualArea = (sideA + sideB)/2*h;
            Assert.assertEquals(actualArea, expArea);
        }
    }
}
