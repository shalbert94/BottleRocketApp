package com.example.shalom.bottlerocketapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.example.shalom.bottlerocketapp.UI.MainActivity;
import com.example.shalom.bottlerocketapp.viewmodel.StoresViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class StoreDetailsFragmentInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void isCompanyLogoViewsDisplayed() {
        //Check if RecyclerView item is clickable
        if (getRVcount() > 0) {
            //Open {@link StoreDetailsFragment} by clicking the first list item in RecyclerView
            onView(withId(R.id.stores_recyclerview)).perform(RecyclerViewActions.scrollToPosition(0)).perform(click());

            onView(withId(R.id.company_logo)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void isStreetTextViewDisplayed() {
        //Check if RecyclerView item is clickable
        if (getRVcount() > 0) {
            //Open {@link StoreDetailsFragment} by clicking the first list item in RecyclerView
            onView(withId(R.id.stores_recyclerview)).perform(RecyclerViewActions.scrollToPosition(0)).perform(click());

            onView(withId(R.id.street_textview)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void isCityStateZipTextViewDisplayed() {
        //Check if RecyclerView item is clickable
        if (getRVcount() > 0) {
            //Open {@link StoreDetailsFragment} by clicking the first list item in RecyclerView
            onView(withId(R.id.stores_recyclerview)).perform(RecyclerViewActions.scrollToPosition(0)).perform(click());

            onView(withId(R.id.city_state_zip_textview)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void isCoordinatesTextViewDisplayed() {
        //Check if RecyclerView item is clickable
        if (getRVcount() > 0) {
            //Open {@link StoreDetailsFragment} by clicking the first list item in RecyclerView
            onView(withId(R.id.stores_recyclerview)).perform(RecyclerViewActions.scrollToPosition(0)).perform(click());

            onView(withId(R.id.coordinates_textview)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void isPhoneNumberDisplayed() {
        //Check if RecyclerView item is clickable
        if (getRVcount() > 0){
            //Open {@link StoreDetailsFragment} by clicking the first list item in RecyclerView
            onView(withId(R.id.stores_recyclerview)).perform(RecyclerViewActions.scrollToPosition(0)).perform(click());

            onView(withId(R.id.phone_number_textview)).check(matches(isDisplayed()));
        }
    }

    @Test
    public void isStoreIdDisplayed() {
        //Check if RecyclerView item is clickable
        if (getRVcount() > 0){
            //Open {@link StoreDetailsFragment} by clicking the first list item in RecyclerView
            onView(withId(R.id.stores_recyclerview)).perform(RecyclerViewActions.scrollToPosition(0)).perform(click());

            onView(withId(R.id.store_id_textview)).check(matches(isDisplayed()));
        }
    }

    private int getRVcount() {
        RecyclerView recyclerView = (RecyclerView) mainActivityActivityTestRule.getActivity()
                .getSupportFragmentManager()
                .findFragmentByTag(StoresViewModel.FRAGMENT_TAG)
                .getView()
                .findViewById(R.id.stores_recyclerview);
        return recyclerView.getAdapter().getItemCount();
    }

}
