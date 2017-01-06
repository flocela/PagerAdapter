package flobee.pageradapterex;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerAdapter extends PagerAdapter{

  DataAdapter dataAdapter;

  public ViewPagerAdapter (DataAdapter dataAdapter) {
    this.dataAdapter = dataAdapter;

  }

  @Override
  public int getCount() {
    //return 0;
    return dataAdapter.getCount();
  }

  // See https://github.com/vogellacompany/codeexamples-android/blob/master/de.vogella.
  // android.viewpager/src/de/vogella/android/viewpager/ViewPagerActivity.java
  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    Character character = dataAdapter.getCharacterAt(position);
    String characterName = character.getCharacterName();
    Context context = container.getContext();
    CharacterView characterView = new CharacterView(context, null);
    characterView.setDrawable(NamedDrawable.
      getDrawableFromName(context, characterName));
    characterView.setName(characterName);
    container.addView(characterView);
    return characterView;
  }

  @Override
  public void destroyItem (ViewGroup collection, int position, Object view) {
    collection.removeView((CharacterView)view);
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }


}
