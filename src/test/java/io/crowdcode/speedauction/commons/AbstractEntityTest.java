package io.crowdcode.speedauction.commons;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AbstractEntityTest {


    @Test
    public void testAbstractEntity() throws Exception {
        DummyEntity entity = new DummyEntity().withId(2L);
        assertThat(entity.getId(), is(equalTo(2L)));
    }

    private static class DummyEntity extends AbstractEntity<DummyEntity, Long> {

    }
}