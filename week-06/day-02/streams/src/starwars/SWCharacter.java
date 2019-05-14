package starwars;

class SWCharacter {

  private String name;
  private int height;
  private int mass;
  private String hairColor;
  private String skinColor;
  private String eyeColor;
  private int birthYear;
  private String gender;

  SWCharacter(String[] props) {
    name = props[0];
    height = Integer.parseInt(props[1]);
    mass = Integer.parseInt(props[2]);
    hairColor = props[3];
    skinColor = props[4];
    eyeColor = props[5];
    birthYear = Integer.parseInt(props[6].replace("BBY", ""));
    gender = props[7];
  }

  public String getName() {
    return name;
  }

  public int getHeight() {
    return height;
  }

  public int getMass() {
    return mass;
  }

  public String getHairColor() {
    return hairColor;
  }

  public String getSkinColor() {
    return skinColor;
  }

  public String getEyeColor() {
    return eyeColor;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public String getGender() {
    return gender;
  }
}
