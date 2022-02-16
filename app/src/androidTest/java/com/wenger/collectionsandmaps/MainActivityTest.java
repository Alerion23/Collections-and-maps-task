package com.wenger.collectionsandmaps;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void switchingViewPager() {
        Espresso.onView(ViewMatchers.withId(R.id.view_pager2))
                .perform(ViewActions.swipeLeft());
        Espresso.onView(ViewMatchers.withId(R.id.map_container))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}
