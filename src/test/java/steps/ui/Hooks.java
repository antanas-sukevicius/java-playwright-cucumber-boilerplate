package steps.ui;

import Faktories.PlaywrightBrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.PageObject;

public class Hooks extends PageObject {

    private static boolean initialized = false;

    @Before
    public void before_all() {
        System.out.println("Before Class");

        if (!initialized) {
            browser = PlaywrightBrowserInstance.create("Chromium", "");
        }

        browserContext = browser.newContext();
        page = browser.newPage();

        if (!initialized) {
            page.onConsoleMessage(msg -> {
                if ("error".equals(msg.type())) System.out.println("Error text: " + msg.text());
                if ("warning".equals(msg.type())) System.out.println("Warning text: " + msg.text());
            });
            initialized = true;
        }
    }

    @After
    public void after_all() {

    }
}
