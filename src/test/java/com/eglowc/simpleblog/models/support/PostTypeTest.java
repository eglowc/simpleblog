package com.eglowc.simpleblog.models.support;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by HCLEE on 2016. 10. 4..
 *
 * @author HCLEE
 */
public class PostTypeTest {

    @Test
    public void shouldGetName() {
        assertThat("getName() 하면 name이 온다", PostType.MARKDOWN.getName(), is(equalTo("markdown")));
    }

}