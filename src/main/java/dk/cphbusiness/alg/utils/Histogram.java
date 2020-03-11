package dk.cphbusiness.alg.utils;

import java.io.PrintStream;

public class Histogram {
  private static final String template =
      "##################################################"+
      "##################################################";
  private final int scale;

  public Histogram(int scale) {
    this.scale = scale;
    }

  private String histoline(int value) {
    if (value > 100*scale) return "*** "+value+" ***";
    return template.substring(0, value/scale);
    }

  public void print(PrintStream out, int[] list) {
    for (int i = 0; i < list.length; i++)
        out.println(histoline(list[i]));
    }

  public void print(int[] list) { print(System.out, list); }


  }