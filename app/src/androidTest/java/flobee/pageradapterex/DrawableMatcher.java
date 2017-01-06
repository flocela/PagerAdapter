package flobee.pageradapterex;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class DrawableMatcher extends BoundedMatcher<View, ImageView> {

  String characterName;

  public DrawableMatcher(String characterName) {
    super(ImageView.class);
    this.characterName = characterName;
  }

  public static DrawableMatcher withCharacterName(final String name) {
    return new DrawableMatcher(name);
  }

  @Override
  protected boolean matchesSafely(ImageView target) {
    Drawable drawable = target.getDrawable();
    if (null == characterName || characterName.isEmpty()) {
      return drawable == null;
    }

    BitmapDrawable actualBmd = (BitmapDrawable)drawable;
    Bitmap actualBitmap = actualBmd.getBitmap();

    Drawable expectedDrawable = null;
    String fileName = characterName.toLowerCase().replace(' ', '_').concat(".png");
    try {
      InputStream ims = target.getContext().getAssets().open(fileName);
      expectedDrawable = Drawable.createFromStream(ims, null);
    } catch (IOException e) {
      e.printStackTrace();
    }

    BitmapDrawable expectedBmd = (BitmapDrawable) expectedDrawable;
    Bitmap expectedBitmap = expectedBmd.getBitmap();

    if (!actualBitmap.sameAs(expectedBitmap)) {
      return false;
    }
    else {
      return areBitmapsEqual(expectedBitmap, actualBitmap);
    }
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("with character name: ").
      appendText(characterName + ".");
  }

  private static boolean areBitmapsEqual(Bitmap bitmap1, Bitmap bitmap2) {
    // compare two bitmaps by their bytes
    byte[] array1 = BitmapToByteArray(bitmap1);
    byte[] array2 = BitmapToByteArray(bitmap2);
    if (java.util.Arrays.equals(array1, array2)) {
      return true;
    }
    return false;
  }

  private static byte[] BitmapToByteArray(Bitmap bitmap) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
    byte[] result = bos.toByteArray();
    return result;
  }
}
