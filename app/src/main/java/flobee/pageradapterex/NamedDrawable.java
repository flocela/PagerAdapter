package flobee.pageradapterex;


import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

public class NamedDrawable {

  private NamedDrawable(){}

  public static Drawable getDrawableFromName(Context context, String name) {
    String fileName = name.toLowerCase().replace(' ', '_').concat(".png");
    Drawable drawable = null;
    try {
      InputStream ims = context.getAssets().open(fileName);
      drawable = Drawable.createFromStream(ims, null);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return drawable;
  }
}
