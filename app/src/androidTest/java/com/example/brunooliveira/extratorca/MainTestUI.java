package com.example.brunooliveira.extratorca;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainTestUI  {

    //Adicionar ao build.gradle androidTestImplementation 'com.android.support.test:rules:1.0.2'
    //Para pode usar o TestRule

    //Aqui inicializamos a activity que vamos controlar/analisar
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class, false, true);

    @Test
    public void initialDisplayState() {
        //metodo onde checamos se a view com o id "tal" está sendo exibido na tela
        onView(withId(R.id.fieldLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.fieldPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
        onView(withId(R.id.titleLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.titleLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.subtitleLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar_actionbar)).check(matches(isDisplayed()));
    }


}