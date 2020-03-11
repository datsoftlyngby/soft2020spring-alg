package dk.cphbusiness.alg.utils;

public class HashProgram {
  private static Histogram histogram = new Histogram(1_000);

  private static void test(String[] words, HashFunction<String> hash) {
    int[] hashes = new int[32];
    for (String word : words) {
      int h = hash.function(word);
      hashes[h]++;
      }
    histogram.print(hashes);
    }

  public static void main(String[] args) throws Exception {
    //String[] words = new String[] { "Kurt", "Sonja", "Ib", "Preben", "Iben", "Solejma" };
    String[] words = FileUtility.toStringArray("/Users/AKA/DatSoftLyngby/soft2020spring-alg/data/shakespeare-complete-works.txt", "[^A-Za-z']+");
    System.out.println("First Character:");
    test(words, word -> word.charAt(0)%32);
    System.out.println("-------------------------");

    System.out.println("Last Character:");
    test(words, word -> word.charAt(word.length() - 1)%32);
    System.out.println("-------------------------");

    System.out.println("Last Character:");
    test(words, word -> word.chars().sum()%32);
    System.out.println("-------------------------");
    }
  }
