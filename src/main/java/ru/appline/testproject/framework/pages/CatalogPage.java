package ru.appline.testproject.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.appline.testproject.framework.model.Product;

import java.util.List;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'product-info__title-link']//a")
    private List<WebElement> searchResults;

    public ProductPage selectSearchResult(String select) {
        for (WebElement result : searchResults) {
            if (result.getText().toLowerCase().contains(select)) {
                actions.moveToElement(result).build().perform();
                wait.until(ExpectedConditions.visibilityOf(result)).click();
            }
            break;
        }
        return app.getProductPage();
    }

    public ProductPage selectSearchResult() {
        return app.getProductPage();
    }
}
