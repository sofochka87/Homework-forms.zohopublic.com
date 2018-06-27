package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

	// public static void main(String[] args) {
	// TODO Auto-generated method stub

	// int expected = 2;
	//
	// Unit unit = new Unit();
	// int actual = unit.add(1, 1);
	// if (actual == expected) {
	// System.out.println("pass");
	// } else {
	// System.out.println("Fail");
	// }

	@Test
	public void addTest() {
		int expected = 2;
		Unit unit = new Unit();
		int actual = unit.add(1, 1);
		Assert.assertEquals(actual, expected);
	}

}
