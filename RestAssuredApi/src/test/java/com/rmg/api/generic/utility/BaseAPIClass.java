package com.rmg.api.generic.utility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author Vibhor
 *
 */
public class BaseAPIClass {
	public  JavaUtility jLib = new JavaUtility();
	public DataBaseUtilities db = new DataBaseUtilities();
	@BeforeSuite
	public void configBeforesuite() {

		System.out.println("============START================");
		System.out.println("============CONNECT TO DB=========");
		baseURI = "http://localhost:8084";
		db.connectDB();
	}

	@AfterSuite
	public void configAftersuite() throws SQLException {

		System.out.println("============CLOSE DB=========");
		System.out.println("============END================");
		db.closeDB();
	}

}
