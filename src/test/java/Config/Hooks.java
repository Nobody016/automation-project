package Config;

import io.cucumber.java.Before;

public class Hooks {

    @Before(order=1)
    public void printTest() {
        System.out.println(System.getProperty("user.dir"));
    }
}
