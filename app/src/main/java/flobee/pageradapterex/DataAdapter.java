package flobee.pageradapterex;


import java.util.ArrayList;

public class DataAdapter {

  ArrayList<Character> characters;

  public DataAdapter () {
    characters = new ArrayList<>();
  }

  public void addCharacters(ArrayList<Character> characters) {
    this.characters = characters;
  }

  public Character getCharacterAt(int position) {
    return characters.get(position);
  }

  public int getCount() {
    return characters.size();
  }


}
