package dk.cphbusiness.alg.airport.template;

import java.util.ArrayList;
import java.util.List;

public class Plane {
  private final Time departureTime;
  private int seatCount = 200;
  private final List<Passenger> passengers = new ArrayList<>();

  @Override
  public String toString() {
    return "Plane that leaves at "+departureTime;
    }

  public Plane(Time departureTime) {
    this.departureTime = departureTime;
    }

  public Time getDepartureTime() {
    return departureTime;
    }

  public int getSeatCount() {
    return seatCount;
    }

  public List<Passenger> getPassengers() {
    return passengers;
    }

  public void setSeatCount(int seatCount) {
    this.seatCount = seatCount;
    }

  }
