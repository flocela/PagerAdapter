package flobee.pageradapterex;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.constructorsDeclaredIn;
import static org.powermock.api.support.membermodification.MemberMatcher.methodsDeclaredIn;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

// import static org.mockit.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CharacterViewUTest {

  @Mock Activity       mockActivity;
  @Mock TextView       mockNameView;
  @Mock ImageView      mockImageView;
  @Mock LayoutInflater mockInflater;
  @Mock Drawable       mockDrawable;
  @Mock Drawable       mockBadDrawable;
  private String shmiS = "Shmi Skywalker";


  @Before
  public void init () {
    suppress(constructorsDeclaredIn(LinearLayout.class));
    when(mockActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(mockInflater);
    suppress(methodsDeclaredIn(LayoutInflater.class));
  }

  @Test
  public void setsNameFromCharacter () {
    CharacterView characterView = new CharacterView(mockActivity, null);
    CharacterView spyCharView   = spy(characterView);
    //view.findViewById() is an Android method, the Android testing library will throw an
    // exception when called. So add testingOptions {unitTests.returnDefaultValues=true}
    // inside android{} in app's gradle file.
    when(spyCharView.findViewById(R.id.character_name)).thenReturn(mockNameView);

    spyCharView.setName(shmiS);

    verify(mockNameView).setText(shmiS);
  }

  @Test
  public void setsDrawableFromCharacter () {
    CharacterView characterView = new CharacterView(mockActivity, null);
    CharacterView spyCharView   = spy(characterView);
    //view.findViewById() is an Android method, the Android testing library will throw an
    // exception when called. So add testingOptions {unitTests.returnDefaultValues=true}
    // inside android{} in app's gradle file.
    when(spyCharView.findViewById(R.id.character_pict)).thenReturn(mockImageView);

    spyCharView.setDrawable(mockDrawable);

    verify(mockImageView).setImageDrawable(mockDrawable);
  }
}
