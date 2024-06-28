import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ViewportSize;

import java.awt.*;

public class MaximizeTheBrowser {
    public static void main(String[] args) {

        /* NOTE: Instead of maximizing the screen or window directly,
           the dimension class can be used to represent sizes (width and height) */
        // Here, we get the screen size and use it to set the viewport size.
        // Note2: It gives the dimensions of the primary screen (the main screen) in a multiple-screen setup.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int  screenWidth = (int) dimension.getWidth();
        int  screenHeight = (int) dimension.getWidth();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.trendyol.com/");

      /* page.setViewportSize(1220, 686);
        Sets the viewport size to 1220x686, to effectively maximizing the browser window. */

      /*  page.setViewportSize(dimension.width, dimension.height);
        Gets the screen size of the primary screen by dimension class and
        maximizes the browser window by setting the viewport size */

        page.close();
        browser.close();
        playwright.close();

    }
}
