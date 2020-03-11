package dk.cphbusiness.alg.airport.template;

public class Time implements Comparable<Time> {
  private final long millis;
  
  public Time(long millis) {
    this.millis = millis;
    }
  
  public Time(int hour, int minute, int second) {
    millis = ((((long)hour)*60 + minute)*60 + second)*1000;
    }

  public long getMillis() {
    return millis;
    }

  private static String two(long number) {
    if (number >= 10) return ""+number;
    return "0"+number;
    }  
  
  @Override
  public String toString() {
    long s = millis/1000;
    long m = s/60;
    long h = m/60;
    s = s%60;
    m = m%60;
    return two(h)+":"+two(m)+":"+two(s);
    }
  
  @Override
  public int compareTo(Time other) {
    if (this.millis < other.millis) return -1;
    if (this.millis > other.millis) return 1;
    return 0;
    }

  }
