package com.example.recyclerteste

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.ActivityTestRule
import com.example.desafiomuxi.LineHolder
import com.example.desafiomuxi.MainActivity
import com.example.desafiomuxi.R
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun isShowFruitName(){
        Thread.sleep(1000)
        onView((withText("Banana"))).check(matches(isDisplayed()))
    }

    @Test
    fun shouldClick() {
        Thread.sleep(1000)
        onView(withId(R.id.recycler)).perform(RecyclerViewActions
                .actionOnItemAtPosition<LineHolder>(1, click()))
    }





}
