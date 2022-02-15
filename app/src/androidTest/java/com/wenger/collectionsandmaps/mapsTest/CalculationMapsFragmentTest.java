package com.wenger.collectionsandmaps.mapsTest;

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
import com.wenger.collectionsandmaps.collectionTest.CalculationCollectionsFragmentTest;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationMapsFragmentTest {

    private int POSITION = 5;
    private final String MAPS_SIZE = "1";

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onClearClick() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.view_pager2))
                .perform(ViewActions.swipeLeft());
        Thread.sleep(1000);
        Espresso.onView(ViewMatchers.withId(R.id.type_map_size))
                .perform(ViewActions.typeText(MAPS_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_maps))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.clear_map))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.map_container))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void scrollFragment() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.view_pager2))
                .perform(ViewActions.swipeLeft());
        Thread.sleep(1000);
        Espresso.onView(ViewMatchers.withId(R.id.type_map_size))
                .perform(ViewActions.typeText(MAPS_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_maps))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.map_recycler))
                .perform(ViewActions.swipeUp())
                .perform(ViewActions.swipeDown());
    }

    @Test
    public void ifResultDisplayed() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.view_pager2))
                .perform(ViewActions.swipeLeft());
        Thread.sleep(1000);
        Espresso.onView(ViewMatchers.withId(R.id.type_map_size))
                .perform(ViewActions.typeText(MAPS_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_maps))
                .perform(ViewActions.click());
        Thread.sleep(1000);
        Espresso.onView((Matcher<View>) new RecyclerViewMatcher(R.id.map_recycler)
                .atPositionOnView(POSITION, R.id.result))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void ifProgressBarDisplayed() throws InterruptedException {
        Espresso.onView(ViewMatchers.withId(R.id.view_pager2))
                .perform(ViewActions.swipeLeft());
        Thread.sleep(1000);
        Espresso.onView(ViewMatchers.withId(R.id.type_map_size))
                .perform(ViewActions.typeText(MAPS_SIZE))
                .perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.calculate_maps))
                .perform(ViewActions.click());
        Espresso.onView((Matcher<View>) new RecyclerViewMatcher(R.id.map_recycler)
                .atPositionOnView(POSITION, R.id.progress_bar_collection))
                .check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));
    }

}
