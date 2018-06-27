package com.cybertek;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;;

public class TestNGDemo {
	
	@BeforeClass
	public void setUpClass() {
		System.out.println("Runs before everything in this class");
	}

	@BeforeMethod
	public void setUpMethod() {
		System.out.println("runs before every method");
	}
	
	@Test
	public void testOne() {
		System.out.println("First one");
	}
	@Test
	public void testSecond() {
		System.out.println("Second one");
	}
	@AfterMethod
	public void tearDownMethod() {
		System.out.println("runs after every method");
		}
	@AfterClass
	public void endClass() {
		System.out.println("Runs after everything in this class");
	}
}
