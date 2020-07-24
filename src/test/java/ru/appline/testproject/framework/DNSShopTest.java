package ru.appline.testproject.framework;

import org.junit.jupiter.api.Test;
import ru.appline.testproject.framework.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DNSShopTest extends BaseTest{

    private List<Product> productList = new ArrayList<>();
    private Product playStation = new Product();
    private Product gameDetroit = new Product();

    @Test
    void test() {
        app.getSearchPage()
                .searchByQuery("playstation")
                .selectSearchResult("playstation 4 slim black")
                .savePrice(playStation)
                .saveGuarantee("2", playStation)
                .savePriceWithGuarantee(playStation)
                .saveProductToList(playStation, productList)
                .clickBuyButton()
                .searchByQuery("Detroit")
                .selectSearchResult()
                .savePrice(gameDetroit)
                .saveProductToList(gameDetroit, productList)
                .clickBuyButton()
                .goToCart()
                .isCartPriceEqualsProductAmount(productList)
                .checkProductPrices(productList)
                .removeItem(productList.indexOf(gameDetroit))
                .plusItemCount(productList.indexOf(playStation))
                .checkSum(playStation)
                .restoreLastItemRemoved();
    }

}
