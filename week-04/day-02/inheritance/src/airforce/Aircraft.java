package airforce;

abstract class Aircraft {

  private int currentAmmo = 0;
  private int maxAmmo;
  private int baseDamage;

  int fight() {
    int damage = getDamage();
    this.currentAmmo = 0;
    return damage;
  }

  int refill(int amount) {
    int currentAmmo = this.currentAmmo;
    this.currentAmmo = Math.min(this.currentAmmo + amount, this.maxAmmo);
    return amount - this.currentAmmo + currentAmmo;
  }

  private String getType() {
    return this.getClass().getSimpleName();
  }

  String getStatus() {
    return "Type " + getType() + ", Ammo: " + this.currentAmmo + ", Base Damage: "
        + this.baseDamage + ", All damage: " + getDamage() + "\n";
  }

  int getDamage() {
    return this.currentAmmo * this.baseDamage;
  }

  void setMaxAmmo(int maxAmmo) {
    this.maxAmmo = maxAmmo;
  }

  void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  abstract boolean isPriority();
}
