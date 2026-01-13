package autotest.steps;

import autotest.config.PlaywrightConfig;
import autotest.pages.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static autotest.locators.Locators.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FooterTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;


    public FooterTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

    @Given("I open the Playwright footer page")
    public void iOpenThePlaywrightTestPage() {
        pageObject
                .getPage()
                .navigate(playwrightConfig.getTestPageUrl());
    }

    @When("I check for the footer")
    public void iCheckForTheFooter() {
        boolean footerExists = pageObject
                .getPage().locator(FOOTER_SELECTOR)
                .count() > 0;

        assertTrue(footerExists, "Футер должен присутствовать на странице");

        }
    @Then("I verify the footer is displayed")
    public void iVerifyTheFooterIsDisplayed() {
        boolean isFooterVisible = pageObject
                .getPage()
                .locator(FOOTER_SELECTOR)
                .first()
                .isVisible();

        assertTrue(isFooterVisible, "Футер должен быть видимым");

        boolean hasContactLink = pageObject
                .getPage()
                .locator(CONTACT_LINK_SELECTOR)
                .count() > 0;

        assertTrue(hasContactLink, "Ссылка 'Контактная информация' должна присутствовать в футере");

        // Проверка наличия ссылки "Политика конфиденциальности"
        boolean hasPrivacyLink = pageObject
                .getPage()
                .locator(PRIVACY_POLICY_LINK_SELECTOR)
                .count() > 0;

        assertTrue(hasPrivacyLink, "Ссылка 'Политика конфиденциальности' должна присутствовать в футере");
    }
}
