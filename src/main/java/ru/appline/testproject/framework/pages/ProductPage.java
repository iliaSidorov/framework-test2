package ru.appline.testproject.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.appline.testproject.framework.model.Product;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='current-price-value']")
    private WebElement productPrice;

    @FindBy(xpath = "//select[@class='form-control select']")
    private WebElement guarantee;

    @FindBy(xpath = "//button[text()='Купить']")
    private WebElement buyButton;

    public ProductPage savePrice(Product product) {
        double price = parseToDouble(productPrice.getText());
        product.setPrice(price);
        return this;
    }

    public ProductPage saveGuarantee(String value, Product product) {
        new Select(guarantee).selectByValue(value);
        product.setGuarantee(Integer.parseInt(value));
        return this;
    }

    public SearchPage clickBuyButton() {
        waitUntilElementToBeClickable(buyButton).click();
        return app.getSearchPage();
    }

    public ProductPage saveProductToList(Product product, List<Product> list) {
        list.add(product);
        return this;
    }

    public ProductPage savePriceWithGuarantee(Product product) {
        double price = parseToDouble(productPrice.getText());
        product.setPriceWithGuarantee(price);
        return this;
    }
}
