package com.dmsApi.test;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import com.dmsApi.utils.ExtendTestManager;
import com.dmsApi.utils.Logs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest extends ExtendTestManager {
	
	

	@Test
	public void run(Method method) {
		Logs.info("Tests is starting!");
		startTest(method.getName(), "MY FIRST TEST");
		RestAssured.baseURI="https://staging-auth.dresma.com/users/user/all/1/10";
		Response response = RestAssured.given().contentType(ContentType.JSON).get();		
		response.prettyPrint();
		

	}
}
