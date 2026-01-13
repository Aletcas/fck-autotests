package autotest.steps;


import autotest.config.PlaywrightConfig;
import autotest.locators.Locators;
import autotest.pages.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogItemsTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;


    public CatalogItemsTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

    @Given("I open the Playwright catalog items page")
    public void iOpenThePlaywrightTestPage() {
        pageObject
                .getPage()
                .navigate(playwrightConfig.getTestPageUrl());

    }

    @When("I check the catalog items")
    public void iCheckTheCatalogItems() {
        pageObject.getPage().waitForSelector(Locators.CATALOG_ITEMS_LIST);
        boolean isItemCount = pageObject
                .getPage()
                .locator(Locators.CATALOG_ITEMS_LIST).count() > 0;

        assertTrue(isItemCount, "Должен быть хотя бы 1 товар в каталоге");
    }

    @Then("I verify catalog items are displayed")
    public void iVerifyCatalogItemsAreDisplayed() {
        pageObject
                .getPage()
                .waitForSelector(Locators.CATALOG_ITEMS_LIST);
        int itemCount = pageObject
                .getPage()
                .locator(Locators.CATALOG_ITEMS_LIST)
                .count();

        assertTrue(itemCount > 2, "Должно быть больше 2 товаров в каталоге, найдено: " + itemCount);
        System.out.println("✅ Проверка каталога пройдена успешно");
    }
}
//