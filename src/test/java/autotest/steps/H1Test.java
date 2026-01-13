package autotest.steps;

import autotest.config.PlaywrightConfig;
import autotest.pages.PageObject;


public class H1Test {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;


    public H1Test(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;

    }
}
