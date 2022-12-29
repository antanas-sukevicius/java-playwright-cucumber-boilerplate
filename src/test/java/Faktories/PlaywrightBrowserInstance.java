package Faktories;

import com.microsoft.playwright.*;

import java.util.Arrays;
import java.util.List;

public class PlaywrightBrowserInstance {

    protected static Browser browser;
    protected BrowserContext context;

    public static Browser create(String browserTypeAsString, String driverExec) {

        boolean headlessStatus = false;
        BrowserType browserType = null;
        int runSpeed = 50;

        switch (browserTypeAsString) {
            case "Firefox":
                browserType = Playwright.create().firefox();
                break;
            case "Chromium":
            case "Edge":
                browserType = Playwright.create().chromium();
                break;
            case "Webkit":
                browserType = Playwright.create().webkit();
                break;

        }
        if (browserType == null) {
            throw new IllegalArgumentException("Could not launch a browser for type " + browserTypeAsString);
        }

        List<String> argsList = Arrays.asList(
                "--enable-automation",
                "--remote-debugging-pipe",
                "--incognito",
                "--use-mock-keychain",
                "--disable-sync",
                "--allow-cross-origin-auth-prompt",
                "--no-first-run",
                "--homepage=\"about:blank\"",
                //"--clear-token-service"
                "--disable-auto-wpt-origin-isolation",
                "--auth-server-whitelist=\"_\""
        );

        browser = browserType.launch(new BrowserType.LaunchOptions()
                .setHeadless(headlessStatus).setSlowMo(runSpeed));//.setExecutablePath(Paths.get(driverExec)));

        return browser;
    }
}
