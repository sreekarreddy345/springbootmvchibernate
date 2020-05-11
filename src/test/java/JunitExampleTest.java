import com.sreekar.JunitExample;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class JunitExampleTest {
    @Test
    @Ignore
    public void addTest() {
        try {
            JunitExample junitExample = new JunitExample();
            int expected = 3;

            // api call or some transformation
            int actual = junitExample.add(1, 2);

            Assert.assertEquals(expected,actual);

        } catch (Exception e) {

        }


    }

}
