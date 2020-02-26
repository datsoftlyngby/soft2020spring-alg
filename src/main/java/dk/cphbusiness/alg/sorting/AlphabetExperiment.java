package dk.cphbusiness.alg.sorting;

import java.util.ArrayList;
import java.util.List;

public class AlphabetExperiment {

  public static int indexOfLetter(char letter) {
    return (int)letter - 97;
    }

  public static int indexOfDigit(int digit) {
    return digit;
    }

  public static int indexOfColor(String color) {
    List<String> values = new ArrayList<String>();
    values.add("red");
    values.add("green");
    values.add("yellow");
    return values.indexOf(color);
    // HashMap
    // switch-case
    }

  public static void main(String[] args) {
    System.out.println(indexOfLetter('a'));
    System.out.println(indexOfLetter('e'));
    System.out.println(indexOfColor("red"));
    System.out.println(indexOfColor("yellow"));
    System.out.println(indexOfColor("green"));
    }

  }
