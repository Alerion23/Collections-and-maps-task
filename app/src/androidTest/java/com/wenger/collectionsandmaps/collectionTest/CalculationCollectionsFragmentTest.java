package com.wenger.collectionsandmaps.collectionTest;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.wenger.collectionsandmaps.MainActivity;
import com.wenger.collectionsandmaps.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationCollectionsFragmentTest {

    private final String COLLECTION_SIZE = "1";

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onClearClick() {
        Espresso.onView(ViewMatchers.withId(R.id.type_collection_size))
                .perform(ViewActions.typeText(COLLECTION_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_collection))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.clear_collection))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.collection_container))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void scrollFragment() {
        Espresso.onView(ViewMatchers.withId(R.id.type_collection_size))
                .perform(ViewActions.typeText(COLLECTION_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_collection))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.collections_recycler))
                .perform(ViewActions.swipeUp())
                .perform(ViewActions.swipeDown());
    }
}
