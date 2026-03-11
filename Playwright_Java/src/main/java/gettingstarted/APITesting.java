package gettingstarted;

import static org.testng.AssertJUnit.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class APITesting {
	
	
	  try (Playwright playwright = Playwright.create()) {
          APIRequestContext requestContext = playwright.request().newContext();

          // Send a GET request and get the response
          APIResponse apiResponse = requestContext.get("https://reqres.in");

          // Assert the status code
          Assert.assertEquals(apiResponse.status(), 200, "Status code should be 200");

          // Parse and validate the JSON response body
          JsonObject jsonResponse = apiResponse.json().getAsJsonObject();
          Assert.assertEquals(jsonResponse.getAsJsonObject("data").get("first_name").getAsString(), "Janet");
      }
	  
	  
	    
}
