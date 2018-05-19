package com.example.shalom.bottlerocketapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.example.shalom.bottlerocketapp.UI.MainActivity;
import com.example.shalom.bottlerocketapp.viewmodel.StoresViewModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class StoresFragmentInstrumentedTest {

    @Rule
    public final ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkRecyclerViewItemIsClickable(){
        if (getRVcount() > 0){
            onView(withId(R.id.stores_recyclerview))
                    .perform(RecyclerViewActions.scrollToPosition(0))
                    .check(matches(isClickable()));
        }
    }

    private int getRVcount(){
        RecyclerView recyclerView = (RecyclerView) activityActivityTestRule.getActivity()
                .getSupportFragmentManager()
                .findFragmentByTag(StoresViewModel.FRAGMENT_TAG)
                .getView()
                .findViewById(R.id.stores_recyclerview);
        return recyclerView.getAdapter().getItemCount();
    }
}
