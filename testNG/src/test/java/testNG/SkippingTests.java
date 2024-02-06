package testNG;

import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SkippingTests {

	@Test(enabled=false)
	public void skipped() {
		System.out.println("skipped successful");
	}
	
	@Test
	public void skipped2() {
		System.out.println("skipped2 successful");
		throw new SkipException("Skipping reason");
	}
	
	@Test
	@Ignore
	public void skipped3() {
		System.out.println("skipped successful");
	}
}
