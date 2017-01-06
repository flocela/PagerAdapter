package flobee.pageradapterex;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CharacterView extends LinearLayout {

  public CharacterView (Context context, AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater inflater = (LayoutInflater)context.
      getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.character, this, true);
  }

  public Drawable getDrawable () {
    ImageView imageView = (ImageView)this.findViewById(R.id.character_pict);
    return imageView.getDrawable();
  }

  public void setDrawable (Drawable drawable) {
    ImageView imageView = (ImageView)this.findViewById(R.id.character_pict);
    imageView.setImageDrawable(drawable);
  }

  public void setName (String characterName) {
    TextView nameView = (TextView)this.findViewById(R.id.character_name);
    nameView.setText(characterName);
  }

}
