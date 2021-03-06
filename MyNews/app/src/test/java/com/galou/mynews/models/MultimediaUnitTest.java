package com.galou.mynews.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Created by galou on 2019-04-08
 */
@RunWith(JUnit4.class)
public class MultimediaUnitTest {

    private Multimedia multimedia;

    @Before
    public void setup(){
        multimedia = new Multimedia();
    }

    @Test
    public void testUrlIsCorrect(){
        String url = "http://url";
        multimedia.setUrl(url);

        assertEquals(multimedia.getUrl(), url);
    }
}
