package com.example.recyclerteste

import androidx.test.espresso.contrib.RecyclerViewActions
import com.example.desafiomuxi.MainActivity
import org.junit.Rule
import org.junit.Test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.desafiomuxi.LineHolder
import com.example.desafiomuxi.R

 class IntentTest{

    @get:Rule
    var intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun validateIntent(){
        Thread.sleep(1000)
        onView(withId(R.id.recycler)).perform(RecyclerViewActions
                .actionOnItemAtPosition<LineHolder>(1, click()))

        // Using a canned RecordedIntentMatcher to validate that an intent resolving
        // to the "phone" activity has been sent.
        intended(hasExtra("nome", "Banana"))
    }
}