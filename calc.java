package SWENG_ASS1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class calc {
  public static void main(String[] args) {
    try {
      // 12435+34569-12345*10+50
      System.out.println("Software-Engineering-Calculator @CianMurphy @CianO'Grady\nType \"quit\" to quit");
      boolean quit = false;
      getInput(quit);
    } catch (Exception e) {
      System.out.println("Ooopsy woopsy");
    }
  }

  private static void getInput(Boolean quit) throws Exception {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); // read sys.in
    String input = "";
    String result = "";
    while (!quit) {
      System.out.print("> Type \"quit\" to quit.\n> Enter expression: ");
      input = stdin.readLine();
      if (input.equals("quit")) {
        quit = true;
        System.out.println("Buh bye.");
        System.exit(0);
      }
      result = calculate(input);
      System.out.println("| Result: " + result);
    }
  }

  private static String calculate(String input) throws Exception {
    // Need to split on + and -, then split on * and evaluate those numbers first *then* evaluate left to right on first split.
    // Right now just evaluates left to right with no respect to order of operation.
    String[] numbers = input.replaceAll("[+()-]+", " ").split(" ");
    String[] operators = input.replaceAll("[0-9()*]+", "").split("");
    String[] mult = new String[2];
    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i].contains("*")) {
        mult = numbers[i].replaceAll("[*]", " ").split(" ");
        int multEval = Integer.parseInt(mult[0]) * Integer.parseInt(mult[1]);
        numbers[i] = String.valueOf(multEval);
      }
    }
    int total = Integer.parseInt(numbers[0]);
    for (int i = 0; i < operators.length; i++) {
      switch (operators[i]) {
        case "+":
          total += Integer.parseInt(numbers[i + 1]);
          break;
        case "-":
          total -= Integer.parseInt(numbers[i + 1]);
          break;
      }
      if (i + 2 >= operators.length)
        continue; // skip if reached last operator
      numbers[i + 1] = String.valueOf(total); // update next number in line as the new running total
    }
    return String.valueOf(total);
  }
}