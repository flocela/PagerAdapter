package flobee.pageradapterex;


import java.util.ArrayList;

public class SkywalkerLineages {
  private static ArrayList<ArrayList<Character>> lineages = new ArrayList<>();

  private static Character shmiS   = new Character("Shmi Skywalker");
  private static Character anakinS = new Character("Anakin Skywalker");
  private static Character leiaO   = new Character("Leia Organa");
  private static Character jacenS  = new Character("Jacen Solo");
  private static Character allanaS = new Character("Allana Solo");

  private static ArrayList<Character> endsWithAlana = new ArrayList<>();

  private SkywalkerLineages () {}

  private static void init () {
    endsWithAlana.add(shmiS);
    endsWithAlana.add(anakinS);
    endsWithAlana.add(leiaO);
    endsWithAlana.add(jacenS);
    endsWithAlana.add(allanaS);
    lineages.add(endsWithAlana);
  }

  public static ArrayList<ArrayList<Character>> getLineages () {
    if (lineages.isEmpty())
      init();
    return lineages;
  }

  public static ArrayList<Character> getLineageFor(String name) {
    if (lineages.isEmpty())
      init();
    for (ArrayList<Character> line : lineages) {
      if (line.get(line.size()-1).getCharacterName().equals(name)) {
        return line;
      }
    }
    return null;
  }

}
