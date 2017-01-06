package flobee.pageradapterex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class) // need PowerMockRunner so add testCompile('org.powermock:powermock-module-junit4:1.6.2)
@PrepareForTest({ViewPagerAdapter.class, NamedDrawable.class}) // whenNew is called from inside these classes. PrepareForTest requires @RunWith(PowerMockRunner.class).
public class ViewPagerAdapterUTest {

  private static ArrayList<Character> shmiToAlana;

  @Mock Context        mockContext;
  @Mock CharacterView  mockCharacterView;
  @Mock CharacterView  mockBadCharacterView;
  @Mock DataAdapter    mockDataAdapter;
  @Mock ViewGroup      mockContainerView;
  @Mock Drawable       mockDrawable;

  @Mock Character      mockShmiS;
  @Mock Character      mockAnankinS;
  @Mock Character      mockLeiaO;
  @Mock Character      mockJacenS;
  @Mock Character      mockAllanaS;

  int    count                  = 5;
  String leiaOName              = "Leia Organa";
  AttributeSet mockAttributeSet = null;

  @Before
  public void initCharacters () {
    when(mockLeiaO.getCharacterName()).thenReturn(leiaOName);
    //for mockStatic to work also need to add NamedDrawable.class to @PrepareForTest
    mockStatic(NamedDrawable.class);

  }

  // tests getCount()
  @Test
  public void returnsCountFromDataAdapter () {
    when(mockDataAdapter.getCount()).thenReturn(count);
    PagerAdapter pagerAdapter = new ViewPagerAdapter(mockDataAdapter);
    assertEquals(count, pagerAdapter.getCount());
  }

  // tests instantiateView(View collection, int position)
  // tests that character view is added to collection from arguments in
  // instantiateView(View collection, int position) method.
  @Test
  public void addsViewToCollection () throws Exception {
    int position = 2;

    when(mockContainerView.getContext()).thenReturn(mockContext);
    whenNew(CharacterView.class).withArguments(mockContext, mockAttributeSet).
      thenReturn(mockCharacterView);

    PagerAdapter pagerAdapter = new ViewPagerAdapter(mockDataAdapter);
    pagerAdapter.instantiateItem(mockContainerView, position);

    verify(mockContainerView).addView(mockCharacterView);
  }

  // tests instantiateView(View collection, int position)
  // tests that character view attributes added to CharacterView
  @Test
  public void characterViewAttributesAddedToCharacterView () throws Exception {
    int position = 2;

    when(mockDataAdapter.getCharacterAt(position)).thenReturn(mockLeiaO);
    when(mockContainerView.getContext()).thenReturn(mockContext);

    when(NamedDrawable.getDrawableFromName(mockContext, leiaOName)).
      thenReturn(mockDrawable);

    whenNew(CharacterView.class).withAnyArguments().thenReturn(mockCharacterView);

    PagerAdapter pagerAdapter = new ViewPagerAdapter(mockDataAdapter);
    pagerAdapter.instantiateItem(mockContainerView, position);

    verify(mockCharacterView).setName(leiaOName);
    verify(mockCharacterView).setDrawable(mockDrawable);
    verify(mockContainerView).addView(mockCharacterView);
  }

  // tests destroyItem(View collection, int position, Object view)
  // tests that view is removed from its container
  @Test
  public void testRemovesViewFromContainer () {
    int position = 2;

    PagerAdapter pagerAdapter = new ViewPagerAdapter(mockDataAdapter);
    pagerAdapter.destroyItem(mockContainerView, position, mockCharacterView);

    verify(mockContainerView).removeView(mockCharacterView);
  }

  // tests isViewFromObject(View view, Object object)
  // returns true if object is view (refers to same object)
  @Test
  public void testViewIsFromObject() {

    PagerAdapter pagerAdapter = new ViewPagerAdapter(mockDataAdapter);

    assertTrue(pagerAdapter.isViewFromObject(mockCharacterView, mockCharacterView));
  }

  // tests isViewFromObject(View view, Object object)
  // returns true if object is view (refers to same object)
  @Test
  public void testViewIsNotFromObject() {

    PagerAdapter pagerAdapter = new ViewPagerAdapter(mockDataAdapter);

    assertFalse(pagerAdapter.isViewFromObject(mockBadCharacterView, mockCharacterView));
  }

}
