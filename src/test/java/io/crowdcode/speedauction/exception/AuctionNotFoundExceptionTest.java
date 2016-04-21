package io.crowdcode.speedauction.exception;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionNotFoundExceptionTest {

    @Test
    public void testAuctionNotFoundConstructor() throws Exception {
        AuctionNotFoundException exception = new AuctionNotFoundException(1L);
        assertThat(exception.getMessage(), is(containsString("1")));
    }
}