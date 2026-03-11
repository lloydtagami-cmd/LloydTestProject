package gettingstarted;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

public class LoginLogout {

	public static void main(String[] args) {
		Browser browser = null;
		Page page = null;
		Playwright pw = null;
		BrowserType browserType = null;
		try {
			pw = Playwright.create();
			
			browserType = pw.chromium();
			
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
			
			page = browser.newPage();
			
			page.navigate("https://freelance-learn-automation.vercel.app/login");
			
			PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
			//by id
			//page.locator("#email1").fill("admin@email.com");
			//by xpath
			//page.locator("xpath=//input[@name='email1']").fill("sss@email.com");
			//by placeholder
			page.getByPlaceholder("Enter Email").fill("admin@email.com");
		
			page.getByPlaceholder("Enter Password").fill("admin@123");
			
			//page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
			
			page.getByText("Sign in").last().click();
			
			PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
			
			page.getByAltText("menu").click();
			
		//	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign out")).click();
			
			page.getByText("Sign out").last().click();
			
			PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
			
			//page.waitForTimeout(3000);
			
		}
		finally {
			page.close();
			
			browser.close();
			
			pw.close();
			
		}
		
		
		
	}

}
