package ru.appline.testproject.framework.managers;

import ru.appline.testproject.framework.pages.CartPage;
import ru.appline.testproject.framework.pages.ProductPage;
import ru.appline.testproject.framework.pages.SearchPage;
import ru.appline.testproject.framework.pages.CatalogPage;

public class PageManager {

    private static PageManager pageManager;

    private SearchPage searchPage;
    private CatalogPage catalogPage;
    private ProductPage productPage;
    private CartPage cartPage;

    //singleton
    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

    public CatalogPage getCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        return catalogPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }
}
