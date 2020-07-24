package ru.appline.testproject.framework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.appline.testproject.framework.managers.InitManager;
import ru.appline.testproject.framework.managers.PageManager;

public class BaseTest {
     protected PageManager app = PageManager.getPageManager();

    @BeforeAll
    public static void setUp() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDown() {
        InitManager.quitFramework();
    }
}
