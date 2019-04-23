package airforce;

public class F16 extends Aircraft {

  F16() {
    super();
    setMaxAmmo(8);
    setBaseDamage(30);
  }

  @Override
  boolean isPriority() {
    return false;
  }
}
