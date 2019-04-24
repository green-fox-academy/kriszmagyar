package reservations;

import java.util.Random;

public class Reservation implements Reservationy {

  private static final int CODE_LENGTH = 8;
  private static Random random = new Random();

  private Day dowBooking;
  private String codeBooking;

  Reservation() {
    this.dowBooking = generateDowBooking();
    this.codeBooking = generateCodeBooking();
  }

  private Day generateDowBooking() {
    Day[] days = Day.values();
    return days[random.nextInt(days.length)];
  }

  private String generateCodeBooking() {
    String generateFrom = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < CODE_LENGTH; i++) {
      sb.append(generateFrom.charAt(random.nextInt(generateFrom.length())));
    }
    return sb.toString();
  }

  @Override
  public String getDowBooking() {
    return this.dowBooking.toString();
  }

  @Override
  public String getCodeBooking() {
    return this.codeBooking;
  }

  @Override
  public String toString() {
    return String.format("Booking# %s for %s", getCodeBooking(), getDowBooking());
  }

  enum Day {
    MON, TUE, WED, THU, FRI, SAT, SAN
  }
}
