package autotest.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import autotest.locators.Locators;

@Component //Указывает, что это Spring-компонент.
public class PageObject {
    private final Page page;

    @Autowired //Внедряет зависимость Page из конфигурации Playwright
    public PageObject(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public String getTitle() {
        return page.title();
    }

    public String getHeaderText() {
        return page.locator("h1").textContent();
    }

    public Locator getCatalogItems() {
        return page.locator(Locators.CATALOG_ITEMS_LIST);
    }

    public void takeScreenshot(String testName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(java.nio.file.Paths.get("screenshots/" + testName + ".png"))
                .setFullPage(true));
    }
}
