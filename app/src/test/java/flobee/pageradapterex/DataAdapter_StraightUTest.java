package flobee.pageradapterex;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class DataAdapter_StraightUTest {

  private static ArrayList<Character> shmiToAlana;
  private static Character shmiS;
  private static Character anakinS;
  private static Character leiaO;
  private static Character jacenS;
  private static Character allanaS;
  private static DataAdapter dataAdapter;

  @BeforeClass
  public static void initCharacters () {
    shmiS   = new Character("Shmi Skywalker");
    anakinS = new Character("Anakin Skywalker");
    leiaO   = new Character("Leia Organa");
    jacenS  = new Character("Jacen Solo");
    allanaS = new Character("Allana Solo");
    shmiToAlana = new ArrayList<Character>();
    shmiToAlana.add(shmiS);
    shmiToAlana.add(anakinS);
    shmiToAlana.add(leiaO);
    shmiToAlana.add(jacenS);
    shmiToAlana.add(allanaS);
    dataAdapter = new DataAdapter();
    dataAdapter.addCharacters(shmiToAlana);
  }

  @Test
  public void returnsCharacterAtPosition0 () {
    assertEquals(shmiS, dataAdapter.getCharacterAt(0));
  }

  @Test
  public void getCount () {
    assertEquals(shmiToAlana.size(), dataAdapter.getCount());
  }

}
