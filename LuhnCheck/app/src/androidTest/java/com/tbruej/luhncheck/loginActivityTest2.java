package com.tbruej.luhncheck;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class loginActivityTest2 {

    @Rule
    public ActivityTestRule<loginActivity> mActivityTestRule = new ActivityTestRule<>(loginActivity.class);

    @Test
    public void loginActivityTest2() {
        ViewInteraction appCompatEditText = onView(withId(R.id.email_id));
        appCompatEditText.perform(replaceText("md@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(withId(R.id.pass_id));
        appCompatEditText2.perform(replaceText("123"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(withId(R.id.pass_id));
       // appCompatEditText2.check(matches(withText("123")));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(withId(R.id.submitBtn));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText4 = onView(withId(R.id.cardNoText));
        appCompatEditText4.perform(replaceText("18009054331492"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(withId(R.id.checkBtn));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText5 = onView(withId(R.id.cardNoText));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatButton3 = onView(withId(R.id.logoutButton));
        appCompatButton3.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
