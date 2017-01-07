package flobee.pageradapterex;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class FirstPageTest {

  private static final String firstCharacterName = "Shmi Skywalker";

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

  @Test
  public void firstPageStartsWithShmi () {
    onView(allOf(isDisplayed(), withId(R.id.character_name))).check(matches(withText(firstCharacterName)));
    onView(allOf(isDisplayed(), withId(R.id.character_pict))).
      check(matches(DrawableMatcher.withCharacterName(firstCharacterName)));
  }

}
