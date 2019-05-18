package com.example.brunooliveira.extratorca;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SecondActivityTestUI {

    @Rule
    public ActivityTestRule<SecondActivity> activityActivityTestRule =
            new ActivityTestRule<>(SecondActivity.class, true, true);

    @Test
    public void initialDisplaySecondActivity(){
        onView(withId(R.id.userName)).check(matches(isDisplayed()));
        onView(withId(R.id.logoutId)).check(matches(isDisplayed()));
        onView(withId(R.id.extractListId)).check(matches(isDisplayed()));
        onView(withId(R.id.limitValueField)).check(matches(isDisplayed()));
        onView(withId(R.id.fieldUsedBox)).check(matches(isDisplayed()));
        onView(withId(R.id.availableValueField)).check(matches(isDisplayed()));
        //Esse id include é referente ao toolbar
        onView(withId(R.id.include)).check(matches(isDisplayed()));
    }

    @Test
    public void initialDisplayListTest(){
        onView(withId(R.id.main_line_text_value)).check(matches(isDisplayed()));
        onView(withId(R.id.main_line_text_num)).check(matches(isDisplayed()));
        onView(withId(R.id.main_line_text_code)).check(matches(isDisplayed()));
        onView(withId(R.id.main_line_text_date)).check(matches(isDisplayed()));
    }
}
