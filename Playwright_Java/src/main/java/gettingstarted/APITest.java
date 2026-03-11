package gettingstarted;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;


public class APITest {
	
	//DELETE
	try (Playwright playwright = Playwright.create()) {
        // 1. Initialize Request Context
        APIRequestContext request = playwright.request().newContext();

        // 2. Specify the ID in the URL path
        String targetId = "1"; 
        String url = "https://jsonplaceholder.typicode.com" + targetId;

        // 3. Execute the DELETE request
        APIResponse response = request.delete(url);

        // 4. Validate the response
        System.out.println("Status Code: " + response.status()); 
        
        // Common success codes: 200 (OK), 204 (No Content), or 202 (Accepted)
        if (response.status() == 200 || response.status() == 204) {
            System.out.println("Resource " + targetId + " deleted successfully.");
        } else {
            System.out.println("Failed to delete resource. Status: " + response.status());
        }

        request.dispose();
		}
	//GET
	/*
	 * @Test public void testGetRequest() { try (Playwright playwright =
	 * Playwright.create()) { APIRequestContext requestContext =
	 * playwright.request().newContext();
	 * 
	 * // Send a GET request and get the response APIResponse apiResponse =
	 * requestContext.get("https://reqres.in");
	 * 
	 * // Assert the status code Assert.assertEquals(apiResponse.status(), 200,
	 * "Status code should be 200");
	 * 
	 * System.out.println(apiResponse.status()); } }
	 */
	
	//POST
	
	//@Test
	/*public void testPostRequest() {
		
		try (Playwright playwright = Playwright.create()) {APIRequestContext request1 = playwright.request().newContext();
            
         // 1. Prepare your JSON data using a Map
            Map<String, Object> data = new HashMap<>();
          //  data.put("id", 1);
          //  data.put("firstName", "Baby Jane");
          //  data.put("lastName", "Doe");
         //   data.put("Age", 1);
            
            // 2. Execute the POST request
            APIResponse response = request1.post("https://jsonplaceholder.typicode.com/posts", RequestOptions.create().setData(data));
            
            // 3. Handle the response
            System.out.println("Status Code: " + response.status());
            System.out.println("Response JSON: " + response.text());

            // Simple validation
            if (response.status() == 201) {
                System.out.println("Resource created successfully!");
            }
            else {
            	System.out.println("Resource is not created");
            }

         //   request1.dispose();
		}*/
	//}
	
	//PUT
	/*
	 * @Test public void testPUTRequest() {
	 * 
	 * try (Playwright playwright = Playwright.create()) { APIRequestContext request
	 * = playwright.request().newContext();
	 * 
	 * 
	 * // 2. Prepare the updated data Map<String, Object> updatedData = new
	 * HashMap<>(); updatedData.put("id", 1); updatedData.put("firstName", "OLi");
	 * updatedData.put("lastName", "Doe"); updatedData.put("Age", 5);
	 * 
	 * // 3. Execute the PUT request for resource with ID 1 APIResponse response =
	 * request.put("https://jsonplaceholder.typicode.com/posts/1",
	 * RequestOptions.create().setData(updatedData));
	 * 
	 * 
	 * // 4. Validate the results System.out.println("Status: " +
	 * response.status()); // Should be 200 OK
	 * System.out.println("Updated Response: " + response.text());
	 * 
	 * request.dispose(); // Cleanup }
	 * 
	 * }
	 */

	
	
}
