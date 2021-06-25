package com.rmg.api.projecttest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.api.generic.utility.BaseAPIClass;
import com.rmg.api.generic.utility.IEndPoints;
import com.rmg.api.project.pojoObjectLib.Project;

import io.restassured.http.ContentType;

public class CreateProject_With_InValidStatusTest extends BaseAPIClass{
	@Test
	public void createAndVerify() throws Throwable {


		String project_name="Adarsh_sdet16_"+jLib.getRandomData();
		String status = "OAABBCC";

		Project projjectPojoObj = new Project("deepak", project_name, status, 10);

		given()
		.contentType(ContentType.JSON)
		.body(projjectPojoObj)
		.when()
		.post(IEndPoints.addProject_EP)
		.then()  
		.log().all()
		.assertThat().statusCode(500);

		//getting the value from database 

		String querry="select * from project;";
		String actProjectName_DataBaseValue = db.executeQuerryAndGetData(querry, 4, project_name); //verify the data in DB
		Assert.assertEquals(actProjectName_DataBaseValue, null);




	}
}
