import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OpenTheBrowser {
    public static void main(String[] args) {

        // in order to use playwright framework, we need to create a playwright object
        Playwright playwright = Playwright.create();
        // to use the browser and set up the start, a browser object created.
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // and then a page object created
        Page page = browser.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());


        page.close();       // closes the specific page you are on
        browser.close();    // closes all existing pages on the browser session
        playwright.close(); // completes your tests
    }
}
