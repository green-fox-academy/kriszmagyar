package reservations;

public class Reservation implements Reservationy {

  private static final int CODE_LENGTH = 8;

  private String dowBooking;
  private String codeBooking;

  Reservation() {
    this.dowBooking = generateDowBooking();
    this.codeBooking = generateCodeBooking();
  }

  private String generateDowBooking() {
    return "MON";
  }

  private String generateCodeBooking() {
    return "ASDASDAS";
  }

  @Override
  public String getDowBooking() {
    return this.dowBooking;
  }

  @Override
  public String getCodeBooking() {
    return this.codeBooking;
  }

  @Override
  public String toString() {
    return String.format("Booking# %s for %s", getCodeBooking(), getDowBooking());
  }

  enum Days {
    MON, TUE, WED, THU, FRI, SAT, SAN
  }
}
