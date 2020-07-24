package ru.appline.testproject.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//nav[@id='header-search']//input")
    private WebElement searchInput;

    @FindBy(xpath = "//nav//div[@class='ui-input-search__buttons']//following-sibling::span")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='products-count']")
    private WebElement productCounter;

    @FindBy(xpath = "//button[text()='В корзине']")
    private WebElement toCart;

    public CatalogPage searchByQuery(String query) {
        fillInputField(searchInput, query);
        waitUntilElementToBeClickable(searchButton).click();
        return app.getCatalogPage();
    }

    public CartPage goToCart() {
        waitUntilElementToBeClickable(toCart).click();
        return app.getCartPage();
    }
}
