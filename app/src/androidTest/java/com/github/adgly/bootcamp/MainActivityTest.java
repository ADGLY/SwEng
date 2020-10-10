package com.github.adgly.bootcamp;

import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void correctMessageSentToGreetingActivity() {
        Intents.init();
        Espresso.onView(ViewMatchers.withId(R.id.mainName)).perform(ViewActions.typeText("Antoine"));
        Espresso.onView(ViewMatchers.withId(R.id.mainEnterButton)).perform(ViewActions.click());
        Intent intent = Intents.getIntents().get(0);
        String test = intent.getExtras().getString(MainActivity.EXTRA_MESSAGE);
        assertThat(test, is("Antoine"));
        Intents.release();
    }
}
