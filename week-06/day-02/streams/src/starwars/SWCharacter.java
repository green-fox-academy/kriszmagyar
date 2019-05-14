package starwars;

class SWCharacter {

  private String name;
  private int height;
  private int mass;
  private String hairColor;
  private String skinColor;
  private String eyeColor;
  private int birthYear;
  private Gender gender;

  SWCharacter() {
  }

  SWCharacter(String[] props) {
    name = props[0];
    height = convert(props[1]);
    mass = convert(props[2]);
    hairColor = props[3];
    skinColor = props[4];
    eyeColor = props[5];
    birthYear = convert(props[6]);
    gender = convertGender(props[7]);
  }

  private int convert(String str) {
    try {
      return Integer.parseInt(str.replace(",", "").replace("BBY", ""));
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private Gender convertGender(String str) {
    switch (str) {
      case "male":
        return Gender.MALE;
      case "female":
        return Gender.FEMALE;
      case "hermaphrodite":
        return Gender.HERMAPHRODITE;
      default:
        return Gender.NA;
    }
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

  public Gender getGender() {
    return gender;
  }

  enum Gender {
    MALE, FEMALE, HERMAPHRODITE, NA
  }

  @Override
  public String toString() {
    return "SWCharacter{" +
        "name='" + name + '\'' +
        ", height=" + height +
        ", mass=" + mass +
        ", hairColor='" + hairColor + '\'' +
        ", skinColor='" + skinColor + '\'' +
        ", eyeColor='" + eyeColor + '\'' +
        ", birthYear=" + birthYear +
        ", gender='" + gender + '\'' +
        '}';
  }
}
