package com.qascript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrowsertests {
@Test
	@Parameters("browser")
	public void crossbrowsertest(String browser) {
	System.out.println("Parameterized value is : " + browser);
	}
}
