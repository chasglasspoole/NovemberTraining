package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertTrue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Authenticator.Result;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

class restTests {
	
	@BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/";
    }

	/*@Test
	void verifyEmailAddress() {
		var expectedEmail = "janet.weaver@reqres.in"; 
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("api/users/2");
		
		ResponseBody body = response.getBody();
		
		JSONResult responseBody = body.as(JSONResult.class);
		
		
		var actualEmail = responseBody.getData().getEmail();
		//var actualEmail = response.jsonPath().getString("email");
		
		assertEquals(expectedEmail, actualEmail, "Returns email of id 2"); 
	}
	
	
	
	@Test public void successfulLoginVerifyToken() {
		var expectedToken = "QpwL5tke4Pnpja7X4";
		
		RestAssured.baseURI = "https://reqres.in/"; 
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("email", "eve.holt@reqres.in"); 
		requestParams.put("password", "cityslicka");
		
		request.header("Content-Type", "application/json");  
		request.body(requestParams.toString());
		
		Response response = request.post("api/login");
		
		var actualToken = response.jsonPath().getString("token"); 
		
		assertEquals(expectedToken, actualToken, "Should return token from successful login");
	}
	
	@Test public void deleteRequest(){
		
		var expectedStatusCode = 204;
		
		Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("api/users/2")
                .then()
                .extract().response();
		
		var actualStatusCode = response.statusCode();
		
		assertEquals(expectedStatusCode, actualStatusCode, "Should return status code"); 
		//Status code 204 means "no content" indicating that the request was successful but the client does not need to navigate from the page
	}
	
	@Test public void patchRequestVerification() {
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Morpheus2");
		var requestBody = requestParams.toString();
		
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("api/users/2")
                .then()
                .extract().response();
		
		assertEquals("Morpheus2", response.jsonPath().getString("name")); 
		assertNotNull(response.jsonPath().getString("updatedAt"));	
	}
	
@Test public void putRequestVerification() {
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Morpheus2");
		var requestBody = requestParams.toString();
		
		Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("api/users/2")
                .then()
                .extract().response();
		
		assertEquals("Morpheus2", response.jsonPath().getString("name")); 
		assertNotNull(response.jsonPath().getString("updatedAt"));	
	}
	
@Test public void canDeserializeUserIntoObject() {
	
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("api/users/2");
	
	ResponseBody body = response.getBody();
	
	JSONResult user = body.as(JSONResult.class);
	
	assertEquals(2, user.getData().getId(),"Returns id of user object");
	assertEquals("janet.weaver@reqres.in", user.getData().getEmail(),"Returns email of user object");
	assertEquals("Janet", user.getData().getFirst_name(),"Returns first name of user object");
	assertEquals("Weaver", user.getData().getLast_name(), "Returns last name of user object");
}*/

@Test public void canDeserializeIntoCollectionOfObjects() {
	
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("api/users?page=2");
	
	ResponseBody body = response.getBody();
	
	JSONObject jsonRoot = new JSONObject(body);
	JSONArray jsonList = jsonRoot.getJSONArray("data");
	
	ObjectMapper mapper = new ObjectMapper(); 
	ArrayList<Data> users = new ArrayList<Data>();
	users = mapper.readValue(jsonRoot, Data[].class);
	 
	List<String> list = new ArrayList<String>();    
	
	Data[] users = new Data[jsonList.length()];
	for (int i = 0; i < jsonList.length(); i++) {
	  //list.add(jsonList.getString(i));
	}

	
	
	//Data users[] = body.as(Data[].class);
	
	for(Data user : users) {
		System.out.println(user.getId());
	}
}
	/*@Test public void verifyEmailAddressForId2() {
		var expectedEmail = "janet.weaver@reqres.in";
		
		Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("api/user/2")
                .then()
                .extract().response();
		
		assertEquals(expectedEmail, response.jsonPath().getString("email"));
	}*/
}
