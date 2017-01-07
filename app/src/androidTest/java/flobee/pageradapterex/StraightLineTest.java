package flobee.pageradapterex;


import android.app.Activity;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.view.ViewPager;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class StraightLineTest {
  private ViewPagerIdlingResource idlingResource;

  private static final String shmi_s   = "Shmi Skywalker";
  private static final String anakin_s = "Anakin Skywalker";
  private static final String leia_o   = "Leia Organa";
  private static final String jacen_s  = "Jacen Solo";
  private static final String allana_s = "Allana Solo";

  // launch flag should be false so that it is not lazily instantiated. Instead I
  // launch the activity in startActivity().
  @Rule
  public IntentsTestRule<MainActivity> mActivityRule =
    new IntentsTestRule(MainActivity.class, true, false);

  @After
  public void tearDownIdlingResource () {
    unregisterIdlingResources(idlingResource);
  }

  @Test
  public void firstSwipe () {

    Activity activity = startActivity();

    idlingResource = new ViewPagerIdlingResource((ViewPager)activity.
      findViewById(R.id.view_pager), "VPIR_0");
    registerIdlingResources(idlingResource);


    onView(isRoot()).perform(swipeLeft());
    idlingResource.setIdle(false);
    //waitForViewPagerResponse(1000);

    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));
    // onView(allOf(withId(R.id.character_name),withText(shmi_s))).
    //   check(matches(not(isCompletelyDisplayed())));
  }

  @Test
  public void fifthSwipe () {
    Activity activity = startActivity();

    idlingResource = new ViewPagerIdlingResource((ViewPager)activity.
      findViewById(R.id.view_pager), "VPIR_0");
    registerIdlingResources(idlingResource);

    onView(isRoot()).perform(swipeLeft());
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(isCompletelyDisplayed()));


    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(leia_o))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(anakin_s))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(jacen_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(leia_o))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(allana_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(jacen_s))).
      check(matches(not(isDisplayed())));

    onView(isRoot()).perform(swipeLeft());

    onView(allOf(withId(R.id.character_name),withText(allana_s))).
      check(matches(isCompletelyDisplayed()));
    onView(allOf(withId(R.id.character_name),withText(jacen_s))).
      check(matches(not(isDisplayed())));
  }
  private MainActivity startActivity() {
    return mActivityRule.launchActivity(null);
  }

  public static void waitForViewPagerResponse(long millis) {
    final long startTime = System.currentTimeMillis();
    final long endTime = startTime + millis;
    do {}
    while (System.currentTimeMillis() < endTime);
  }
}
