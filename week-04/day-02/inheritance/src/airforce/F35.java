package airforce;

public class F35 extends Aircraft {

  F35() {
    super();
    setMaxAmmo(12);
    setBaseDamage(50);
  }

  @Override
  boolean isPriority() {
    return true;
  }
}
