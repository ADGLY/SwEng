package com.github.adgly.bootcamp;

import android.content.Intent;
import android.widget.EditText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Test
    public void correctMessageDisplayedByGreetingActivity() {
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        String message = "Antoine";
        intent.putExtra(MainActivity.EXTRA_MESSAGE, message);
        ActivityScenario scenario = ActivityScenario.launch(intent);
        Espresso.onView(ViewMatchers.withId(R.id.greetingMessage)).check(ViewAssertions.matches(ViewMatchers.withText("Have a nice day, " + message + " !")));
        scenario.close();
    }
}
