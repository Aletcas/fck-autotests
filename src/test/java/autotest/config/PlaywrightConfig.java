package autotest.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Конфигурация для работы с Playwright. Создает экземпляры браузера и страницы.
 */
@Configuration //Указывает, что это конфигурационный класс Spring.
public class PlaywrightConfig {
    private final String testPageUrl = "https://algosstile.github.io/vue-app/index.html";

    @Bean //Создает бины для Playwright, браузера и страницы.
    public Playwright playwright() {
        return Playwright.create();
    }

    @Bean
    @Scope("singleton") //Браузер создается один раз на все тесты
    public Browser browser(Playwright playwright) {
        return playwright.chromium().launch();
    }

    @Bean
    @Scope("prototype") //Каждая страница создается заново для каждого теста
    public Page page(Browser browser) {
        return browser.newPage();
    }

    public String getTestPageUrl() {
        return testPageUrl;
    }
}
