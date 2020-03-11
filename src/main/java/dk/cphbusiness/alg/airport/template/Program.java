package dk.cphbusiness.alg.airport.template;

import dk.cphbusiness.alg.airport.misc.NonPrioritizingArrayQueue;
import dk.cphbusiness.alg.basics.ArrayQueue;
import dk.cphbusiness.alg.basics.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Program {
  private static List<Plane> planes = new ArrayList<>();
  private static PassengerProducer producer;
  private static PassengerConsumer consumer;
  private static PriorityQueue<Passenger> queue;
  private static Clock clock;
  
  private static void setup() {
    for (int hour = 7; hour <= 22; hour++) {
      planes.add(new Plane(new Time(hour, 00, 00)));
      }
    queue = new NonPrioritizingArrayQueue<Passenger>(10000);
    producer = new PassengerProducer(planes, queue);
    consumer = new PassengerConsumer(planes, queue);
    clock = new Clock(producer, consumer, new Time(05, 00, 00));
    }
  
  public static void main(String[] args) {
    setup();
    System.out.println("Hello Airport");
    //new Thread(clock).start();
    
    }
  
  }
