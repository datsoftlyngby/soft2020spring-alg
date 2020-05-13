package dk.cphbusiness.alg.random;

import java.util.Random;

public class CalculatePi {

  public static void main(String[] args) {
    Random random = new Random();
    int inCircleCount = 0;
    int count = 0;
    while (count < 10_000_000) {
      double x = random.nextDouble();
      double y = random.nextDouble();
      double a = x * x + y * y;
      count++;
      if (a < 1.0) inCircleCount++;
      if (count % 100_000 == 0) System.out.printf("%d; %d; %1.5f;\n", count, inCircleCount, (4.0 * inCircleCount) / count);
      }
    }

  }
