package dk.cphbusiness.alg.airport.template;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clock implements Runnable {
  private final long sleepingTime = 10;
  private boolean running = true;
  private final PassengerProducer producer;
  private final PassengerConsumer consumer;
  private long millis;
  
  public Clock(PassengerProducer producer, PassengerConsumer consumer, Time startTime) {
    this.producer = producer;
    this.consumer = consumer;
    this.millis = startTime.getMillis();
    }
  
  public void stop() {
    running = false;
    }
  
  public Time getTime() {
    return new Time(millis);
    }
  
  @Override
  public void run() {
    try {
      while (running) {
        Thread.sleep(sleepingTime);
        producer.tick(this);
        consumer.tick(this);
        millis += 1000;
        }
      } 
    catch (InterruptedException ex) {
      Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  }
