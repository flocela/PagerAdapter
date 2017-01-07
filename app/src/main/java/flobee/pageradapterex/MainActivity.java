package flobee.pageradapterex;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    //TextView nameTextView = (TextView)findViewById(R.id.character_name);
    //nameTextView.setText("Shmi Skywalker");
    //ImageView charImage = (ImageView)findViewById(R.id.character_pict);
    //charImage.setImageDrawable(NamedDrawable.getDrawableFromName(this, "Shmi Skywalker"));

    //CharacterView characterView = new CharacterView(this, null);
    //characterView.setName("Shmi Skywalker");
    //characterView.setDrawable(NamedDrawable.getDrawableFromName(this, "Shmi Skywalker"));
    //ViewGroup root = (ViewGroup)findViewById(R.id.main_layout);
    //root.addView(characterView);

    //ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
    //DataAdapter dataAdapter = new DataAdapter();
    //dataAdapter.addCharacters(SkywalkerLineages.getLineageFor("Allana Solo"));
    //ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(dataAdapter);
    //viewPager.setAdapter(viewPagerAdapter);

    ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
    DataAdapter dataAdapter = new DataAdapter();
    dataAdapter.addCharacters(SkywalkerLineages.getLineageFor("Allana Solo"));
    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(dataAdapter);
    viewPager.setAdapter(viewPagerAdapter);
  }
}
