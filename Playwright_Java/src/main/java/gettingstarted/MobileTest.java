package gettingstarted;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class MobileTest {

	public static void main(String[] args) {
		 try (Playwright playwright = Playwright.create()) {
	            // Emulate the device
	            BrowserType chromium = playwright.chromium();
	            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

	            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
	                .setViewportSize(398, 852) // iPhone 13 viewport
	                .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 13_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.1 Mobile/15E148 Safari/604.1")
	                .setHasTouch(true) // Enable touch events
	                
	            );

	            Page page = context.newPage();
	            page.navigate("https://www.youtube.com/"); // Example URL
	         
	            // Your test actions here
	            
	            page.locator("//span[@class='yt-icon-shape ytSpecIconShapeHost']").click();
	            page.waitForTimeout(60000);
	            page.locator("//div[contains(@class, 'ytSearchboxComponentInputBox')]").fill("Sam Sulek");
	            page.locator("//button[contains(@class, 'ytSearchboxComponentSearchButton')]").click();

	      
	         //   page.locator(".new-todo").fill("Add mobile emulation with Playwright");
	         //   page.locator(".new-todo").press("Enter");
	            System.out.println(page.title());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}

}
