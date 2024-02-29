package hospiolpkg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGClass {
	@DataProvider(name = "testdata")
    public Object[][] testData() {
    	
        Object[][] data ={
                {"username1", "password1"},
                {"username2", "password2"},
                {"username3", "password3"}
                // Add more data as needed
        };
       return data;
    }

    @Test(dataProvider = "testdata")
    public void testMethod(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
        // Add your test logic here using the provided data
    }
}

