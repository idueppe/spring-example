package io.crowdcode.speedauction.commons;

import org.junit.Test;

import static io.crowdcode.speedauction.commons.AnsiColor.blue;
import static io.crowdcode.speedauction.commons.AnsiColor.green;
import static io.crowdcode.speedauction.commons.AnsiColor.purple;
import static io.crowdcode.speedauction.commons.AnsiColor.red;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AnsiColorTest {

    @Test
    public void testColor() throws Exception {
        System.out.println(green("GREEN"));
        System.out.println(purple("PURPLE"));
        System.out.println(red("RED"));
        System.out.println(blue("BLUE"));
    }
}