package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegisterTest.class,
        RegisterNoDOBTest.class
})
public class TestSuite {

}
