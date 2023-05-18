package testngannotations;

import org.testng.annotations.Test;

public class TestNgAnnotations {
	@Test(priority=1, description="testcase 1", groups ={"smoke"})
	  public void firstMethod1() {
		  System.out.println("Method One");
	  }
	  @Test(priority=2, enabled=false)
	  public void firstMethod2() {
		  System.out.println("Method Two");
	  }
	  @Test(priority=3,description="testcase 2", groups = {"smoke"})
	  public void thirdMethod() {
		  System.out.println("Method Three");
	  }
	  @Test(priority=0, groups = {"regression","smoke"})
	  public void fourthMethod() {
		  System.out.println("Method Four");
	  }
}
