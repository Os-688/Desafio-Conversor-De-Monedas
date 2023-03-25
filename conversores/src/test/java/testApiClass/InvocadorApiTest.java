package testApiClass;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import apiClass.InvocadorApi;

public class InvocadorApiTest {
	public static void main(String[] args) {

		InvocadorApi test = new InvocadorApi();

		test.getJson().getJSONObject("rates").getDouble("USD");

	}

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
