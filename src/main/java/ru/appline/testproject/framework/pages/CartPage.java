package ru.appline.testproject.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.testproject.framework.model.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.appline.testproject.framework.managers.DriverManager.getDriver;

public class CartPage extends BasePage {

    //total price of all products in the cart
    @FindBy(xpath = "//span[@class='cart-link__price']")
    private WebElement cartLinkPrice;

    //each product's price list
    @FindBy(xpath = "//div[@class='cart-items__product']//span[@class='price__current']")
    private List<WebElement> cartItemsPrices;

    //each product's remove button list
    @FindBy(xpath = "//button[text()='Удалить']")
    private List<WebElement> cartItemRemoveButtons;

    @FindBy(xpath = "//a[@class='cart-items__product-name-link']")
    private List<WebElement> cartItemNames;

    @FindBy(xpath = "//button[contains(@class, 'button_plus')]")
    private List<WebElement> countPlusButtons;

    @FindBy(xpath = "//span[@class='restore-last-removed']")
    private WebElement restoreItem;

    public CartPage isCartPriceEqualsProductAmount(List<Product> products) {
        double cartPrice = parseToDouble(cartLinkPrice.getText());
        double productAmount = products.stream()
                .mapToDouble(Product::getTotalPrice)
                .sum();

        assertEquals(productAmount, cartPrice, "Cart price and products amount are different");
        return this;
    }

    public CartPage checkProductPrices(List<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            assertEquals(productList.get(i).getPrice(), parseToDouble(cartItemsPrices.get(i).getText()),
                    "Product price and cart item are different");
        }
        return this;
    }

    public CartPage removeItem(int index) {
        waitUntilElementToBeClickable(cartItemRemoveButtons.get(index)).click();
        return this;
    }

    public CartPage plusItemCount(int index) {
        waitUntilElementToBeClickable(countPlusButtons.get(index)).click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public CartPage checkSum(Product product) {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals(product.getTotalPrice() * 2, parseToDouble(cartLinkPrice.getText()),
                "Cart sum and product sum are different");
        return this;
    }

    public CartPage restoreLastItemRemoved() {
        waitUntilElementToBeClickable(restoreItem).click();
        return this;
    }


}
