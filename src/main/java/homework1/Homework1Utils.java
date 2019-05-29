package homework1;

public class Homework1Utils {

  /**
   * Output for first subject in homework
   *
   * @param inputBinaryString - input binary string.
   * @param outputDecimal     - output.
   * @return result as inputBinaryString -> outputDecimal.
   */
  public static String buildOutput(String inputBinaryString, int outputDecimal) {
    return inputBinaryString + " -> " + outputDecimal;
  }

  /**
   * Subtraction using binary operators.
   *
   * @param minuend    - minuend as int
   * @param subtrahend - subtrahend as int.
   * @return result - int.
   */
  public static int binarySubtraction(int minuend, int subtrahend) {

    while (subtrahend != 0) {
      int borrow = (~minuend) & subtrahend;
      minuend = minuend ^ subtrahend;
      subtrahend = borrow << 1;
    }

    return minuend;
  }


  /**
   * Addition using bitwise operators.
   *
   * @param firstAddend  - firstAddend as int.
   * @param secondAddend - secondAddend as int.
   * @return addition of two values.
   */
  public static int add(int firstAddend, int secondAddend) {

    int carry;

    while (secondAddend != 0) {
      carry = firstAddend & secondAddend;
      firstAddend = firstAddend ^ secondAddend;
      secondAddend = carry << 1;
    }

    return firstAddend;
  }

}
