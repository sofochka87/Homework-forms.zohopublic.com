package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
	public void testOne() {
		//String a ="asdf";
		//String b = "xsdc";
		System.out.println("asserting first");
		Assert.assertTrue(false);
		System.out.println("done asserting first");
	}
	@Test
	public void testTwo() {
		
		System.out.println("asserting second");
		Assert.assertTrue(true);
		System.out.println("done asserting second");
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("cleaning up");
	}
	
	
}
