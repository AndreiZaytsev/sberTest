package ru.sberhealth;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;
import static ru.sberhealth.TestData.*;

public class VacancyTest {

    @BeforeAll
    static void configure() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open(startUrl);
    }


    @ValueSource(ints = {0, 1, 2, 3, 4})
    @ParameterizedTest(name = "tab {0} is selected")
    void headTextTest(int testData) {
        $$(headTextAddress).shouldHave(texts(expectedTextInHeader));
        $$(headCollection).get(testData).click();
        $$(headCollection).get(testData).shouldHave(cssClass(tabIsActive));

    }
}


//    @Test
//    public void mainPageTest() {
//        $$(headTextAddress).shouldHave(texts(expectedTextInHeader));
//        $$(headCollection).get(0).click();
//        $$(headCollection).get(0).shouldHave(cssClass(tabIsActive));
//
//        $$(headCollection).get(1).click();
//        $$(headCollection).get(1).shouldHave(cssClass(tabIsActive));
//
//        $$(headCollection).get(2).click();
//        $$(headCollection).get(2).shouldHave(cssClass(tabIsActive));
//
//        $$(headCollection).get(3).click();
//        $$(headCollection).get(3).shouldHave(cssClass(tabIsActive));
//
//        $$(headCollection).get(4).click();
//        $$(headCollection).get(4).shouldHave(cssClass(tabIsActive));
//    }
//}
