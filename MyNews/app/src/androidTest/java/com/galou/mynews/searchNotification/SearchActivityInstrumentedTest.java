package com.galou.mynews.searchNotification;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.ActivityResultMatchers.hasResultCode;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.junit.Assert.assertThat;

/**
 * Created by galou on 2019-03-19
 */
@RunWith(AndroidJUnit4.class)
public class SearchActivityInstrumentedTest {

    private Context context;

    @Rule
    public final ActivityTestRule<SearchActivity> searchActivityTestRule = new ActivityTestRule<>(SearchActivity.class);

    @Before
    public void setup(){
        this.context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void pressBackButton_finishActivity(){
        onView(withContentDescription("Navigate up")).perform(click());
        assertThat(searchActivityTestRule.getActivityResult(), hasResultCode(Activity.RESULT_CANCELED));
    }

}


