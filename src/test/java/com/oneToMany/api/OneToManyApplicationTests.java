package com.oneToMany.api;


/*
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.ActiveProfiles;



import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles("test")
class OneToManyApplicationTests {
	String RoleAPIURL = "http://localhost:4200/api/role/";
	Response response;


	@Test()
	@DisplayName("Get List of ROles")
	public void testRoleList() {
		response = given().auth().preemptive().basic("admin", "admin123")
				.param("Content-Type", "application/jason")
				.when().get(RoleAPIURL + "list");
		response.then().assertThat().body("roleName[0]",is("Maneger"));
		response.then().assertThat().body("roleName[1]",is("Admin"));
		response.then().assertThat().body("roleName[2]",is("IT"));
	}

	@Test
	@DisplayName("Get Role List without Auth")
	public void testRoleWithoutAuth() {
		int statusCode = given().auth().preemptive().basic("admin", "admin123")
				.param("Content-Rype", "application/jason")
				.when().get(RoleAPIURL + "list").thenReturn().getStatusCode();

		Assertions.assertEquals(statusCode,401);

	}

	@Test
	@DisplayName("Create new Role")
	public void testCreateNewRole(){
		response = given().auth().preemptive().basic("admin", "admin123")
				.and()
				.body("")
				.when().post(RoleAPIURL + "/create");
		response.prettyPrint();


	}
/*
	@Test
	@DisplayName("Create new Role with valit request")
	public void testValidRequest() throws JSONException {
		JSONArray user = new JSONArray();
		JSONObject role = new JSONObject();
		role.put("roleName","TestADMIN");
		role.put("description","test user description role");
		role.put("users", user);
		System.out.println(role);

		response = given().auth().preemptive().basic("admin", "admin123")
				.and()
				.body("")
				.when().post(RoleAPIURL + "/create");
		response.prettyPrint();


	}

}*/