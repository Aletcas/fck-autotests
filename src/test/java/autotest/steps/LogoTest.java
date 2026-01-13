package autotest.steps;

import autotest.config.PlaywrightConfig;
import autotest.pages.PageObject;


public class LogoTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;


    public LogoTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;

    }
}
