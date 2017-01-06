package flobee.pageradapterex;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class StraitLineTest {

  private static final String shmi_s   = "Shmi Skywalker";
  private static final String anakin_s = "Anakin Skywalker";
  private static final String leia_o   = "Leia Organa";
  private static final String jacen_s  = "Jacen Solo";
  private static final String allana_s = "Allana Solo";

  @Rule
  public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

  @Test
  public void firstSwipe () {
    onView(isRoot()).perform(swipeLeft());
    waitForViewPagerResponse(1000);
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));

    onView(allOf(withId(R.id.character_name),withText(shmi_s))).
      check(matches(not(isDisplayed())));
   // onView(withId(R.id.character_pict)).
    //  check(matches(DrawableMatcher.withCharacterName("Anakin Skywalker")));

   // onView(isRoot()).perform(swipeLeft()).
   //   check(matches(allOf(withText(leia_o),isDisplayed())));
   // onView(withId(R.id.character_pict)).
   //   check(matches(DrawableMatcher.withCharacterName("Leia Organa")));
  }

  public static void waitForViewPagerResponse(long millis) {
    final long startTime = System.currentTimeMillis();
    final long endTime = startTime + millis;
    do {
    }
    while (System.currentTimeMillis() < endTime);
  }

}
