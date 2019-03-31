package com.galou.mynews.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

import static com.galou.mynews.utils.DateUtil.isEndDateBeforeBeginDate;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by galou on 2019-03-30
 */
@RunWith(JUnit4.class)
public class TextUtilUnitTest {
    @Test
    public void detectSpecialCharacters(){
        String string =  "3333$$$$";

        assertTrue(TextUtil.isTextContainsSpecialCharacter(string));
    }

    @Test
    public void doNotDetectSpecialCharacters(){
        String string =  "3333fffff";

        assertFalse(TextUtil.isTextContainsSpecialCharacter(string));
    }

    @Test
    public void splitTextCorrectly(){
        String string = "test test2";
        String[] listString = {"test", "test2"};

        assertArrayEquals(listString, TextUtil.separateTextBySpace(string));
    }

}
