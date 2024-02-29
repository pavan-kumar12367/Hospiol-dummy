package hospiolpkg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {

	@Test
	@Parameters("name")
	public void parameterTest(String name) {
	System.out.println("Parameterized value is : " + name);
	}
	

}
