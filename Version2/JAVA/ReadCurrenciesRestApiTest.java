/** 
 * @version JAVA
 * @author MARIO SAM <eu@mariosam.com.br>
 * @see I would love to work with you: hire me!
 * $ mvn clean test -Dtest=your.package.TestClassName
 */ 
package JAVA;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ReadCurrenciesRestApiTest {

	@Test
	public void testReadCurrenciesRestApi() throws Exception {
		//Test 1
        String site = "https://kriptonita.com.br";
		String[] want = {"BRL", "USD"};
		String[] got = ReadCurrenciesRestApi.getCurrenciesWithREST( site );
        assertArrayEquals(want, got);
		//Test 2
        site = "https://www.havan.com.br";
		want = new String[] {"BRL"};
		got = ReadCurrenciesRestApi.getCurrenciesWithREST( site );
        assertArrayEquals(want, got);
        //Test 3
        site = "https://www.purplesunrise.com";
        want = new String[] {"GBP"};
        got = ReadCurrenciesRestApi.getCurrenciesWithREST( site );
        assertArrayEquals(want, got);
        //Test 4
        site = "https://truckpartshq.com";
        want = new String[] {"USD"};
        got = ReadCurrenciesRestApi.getCurrenciesWithREST( site );
        assertArrayEquals(want, got);
	}

}
