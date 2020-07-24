package ru.appline.testproject.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.testproject.framework.managers.PageManager;
import ru.appline.testproject.framework.model.Product;

import static ru.appline.testproject.framework.managers.DriverManager.getDriver;

public class BasePage {

    protected PageManager app = PageManager.getPageManager();
    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);
    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();
    protected Actions actions = new Actions(getDriver());

    protected Product product = new Product();

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void fillInputField(WebElement field, String value) {
        scrollToElementJs(field);
        waitUntilElementToBeClickable(field).click();
        field.sendKeys(value);
    }

    protected double parseToDouble(String str) {
        return Double.parseDouble(str.replaceAll("\\s+", ""));
    }



}
