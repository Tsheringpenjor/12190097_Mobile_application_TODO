package com.example.todo_4;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityinputOutputTest {



    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void activitylaunch(){
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.textView4)).check(matches(isDisplayed()));
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput(){
        onView(withId(R.id.send)).perform(typeText("This is a Text"));
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.textView4)).check(matches(withText("This is a Text")));
        onView(withId(R.id.reply)).perform(typeText("This is from Reply"));
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.textView2)).check(matches(withText("This is from Reply")));
    }





    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.todo_4", appContext.getPackageName());
    }

}