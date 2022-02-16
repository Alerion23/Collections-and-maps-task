package com.wenger.collectionsandmaps.collectionTest;


import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static org.hamcrest.CoreMatchers.not;

import android.content.res.Resources;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.wenger.collectionsandmaps.MainActivity;
import com.wenger.collectionsandmaps.R;
import com.wenger.collectionsandmaps.RecyclerViewMatcher;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationCollectionsFragmentTest {

    private int POSITION = 1;
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
                .check(ViewAssertions.matches(isDisplayed()));
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

    @Test
    public void ifResultDisplayed() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.type_collection_size))
                .perform(ViewActions.typeText(COLLECTION_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_collection))
                .perform(ViewActions.click());
        Thread.sleep(1000);
        Espresso.onView((Matcher<View>) new RecyclerViewMatcher(R.id.collections_recycler)
                .atPositionOnView(1, R.id.result))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void ifProgressBarDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.type_collection_size))
                .perform(ViewActions.typeText(COLLECTION_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_collection))
                .perform(ViewActions.click());
        Espresso.onView((Matcher<View>) new RecyclerViewMatcher(R.id.collections_recycler)
                .atPositionOnView(POSITION, R.id.progress_bar_collection))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
    }

}
