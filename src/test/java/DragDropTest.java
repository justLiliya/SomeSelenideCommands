import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragDropTest extends TestBase{

    @Test
    public void MovingElementTest(){
        //рабочий драгндроп
        open("/drag_and_drop");
        $(".example").shouldHave(text("Drag and Drop"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    public void MovingElementWithActionCommandsTest(){
        //такой драгндроп не работает
        open("/drag_and_drop");
        $(".example").shouldHave(text("Drag and Drop"));
        actions().moveToElement($("#column-a")).dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-b").shouldHave(text("A"));
    }
}
