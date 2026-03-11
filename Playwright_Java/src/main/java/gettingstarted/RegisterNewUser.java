package gettingstarted;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class RegisterNewUser {

	public static void main(String[] args) {
		
		Faker faker = new Faker();
		
		Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		
		Page page = browser.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		page.getByText("New user? Signup").click();
		
		PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isDisabled();
		
		page.locator("#name").fill(faker.name().fullName());
		
		page.getByPlaceholder("Email").fill("automation_" + System.currentTimeMillis() + "@gmail.com");
		
		page.getByPlaceholder("Password").fill("anypassword123");
		
		page.locator("xpath=//label[text()='Java']//preceding::input[1]").click();
		
		PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='Java']//preceding::input[1]")).isChecked();

		page.locator("xpath=//input[@value='Female']").click();
		
		PlaywrightAssertions.assertThat(page.locator("xpath=//input[@value='Female']")).isChecked();
		
		page.locator("#state").selectOption("Goa");
		
		String[] hobbies = {"Playing","Swimming"};
		
		page.locator("#hobbies").selectOption(hobbies);
		
		PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();
		
		page.locator(".submit-btn").click();
		
		page.close();
		
		browser.close();
	}

}
