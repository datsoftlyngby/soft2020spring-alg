package dk.cphbusiness.alg.utils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Stopwatch implements AutoCloseable {
  private final PrintStream out;
  private final long nanos = System.nanoTime();

  public Stopwatch(PrintStream out) { this.out = out; }
  public Stopwatch() { this(System.out); }

  public double step() {
    return (System.nanoTime() - nanos)/1_000_000.0;
    }

  @Override
  public void close() {
    out.printf("%5.6f\n", step());
    }

  public static void main(String... args) throws Exception {
    try (Stopwatch sw = new Stopwatch()) {
      Thread.sleep(1000);
      System.out.printf("%5.6f\n", sw.step());
      Thread.sleep(500);
      }
    }
  }
