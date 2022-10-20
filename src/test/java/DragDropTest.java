import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest extends TestBase{

    @Test
    public void movingElementTest(){
        //рабочий драгндроп
        open("/drag_and_drop");
        $(".example").shouldHave(text("Drag and Drop"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    public void movingElementWithActionCommandsTest(){
        //такой драгндроп не работает
        open("/drag_and_drop");
        $(".example").shouldHave(text("Drag and Drop"));
        actions().moveToElement($("#column-a")).dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    public void movingElementWithActionCommandsTest1() {
        //такой драгндроп тоже не работает
        open("/drag_and_drop");
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().build().perform();
        $("#column-b").shouldHave(text("A"));
    }


}
