package autotest.steps;

import autotest.config.PlaywrightConfig;
import autotest.pages.PageObject;


public class FooterTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;


    public FooterTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

}
