package homework1;


import static homework1.Homework1Utils.*;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Homework1 {
  private static final char ONE_AS_CHAR = '1';
  private static final char MINUS_SYMBOL = '-';

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputBinaryNumber = scanner.next();
    String firstTest = buildOutput(inputBinaryNumber, binaryToIntFirstFirstVersion(inputBinaryNumber));
    String secondTest = buildOutput(inputBinaryNumber, binaryToIntSecondVersion(inputBinaryNumber));
    System.out.println(firstTest);
    System.out.println(secondTest);
  }


  /**
   * Proxy method for turning binary number to decimal.  TASK - 1
   *
   * @param inputBinaryString - binary number in String format.
   * @return Decimal number as int.
   * @see java.lang.Integer#parseInt(String, int).
   */
  public static int binaryToIntFirstFirstVersion(String inputBinaryString) {
    return Integer.parseInt(inputBinaryString, 2);
  }

  /**
   * Method for turning binary number to decimal.  TASK - 1
   * If first character of input string is '-' - returns negative decimal number.
   *
   * @param inputBinaryString binary number as String.
   * @return Decimal number as int.
   */
  public static int binaryToIntSecondVersion(String inputBinaryString) {
    int result = 0;
    boolean isNegative = inputBinaryString.charAt(0) == MINUS_SYMBOL;

    for (char character : inputBinaryString.toCharArray()) {
      result <<= 1;
      if (character == ONE_AS_CHAR) result |= 1;
    }

    return isNegative ? changeNumberSign(result) : result;
  }

  /** TASK - 4
   * Euclidean algorithm  for finding greatest common divisor using bitwise
   * operators instead of division. Returns 0 if {@code firstNumber == 0 && secondNumber == 0}
   * If one of params equals 0 returns second one.
   *
   * @param firstNumber  first int number.
   * @param secondNumber second int number.
   * @return greatest common divisor of two number as int.
   */

  public static int gcd(int firstNumber, int secondNumber) {
    //termination conditions
    if (secondNumber == 0 || firstNumber == secondNumber) return firstNumber;
    if (firstNumber == 0) return secondNumber;

    if (firstNumber < 0) firstNumber = changeNumberSign(firstNumber);
    if (secondNumber < 0) secondNumber = changeNumberSign(secondNumber);

    if (firstNumber > secondNumber) return gcd(binarySubtraction(firstNumber, secondNumber), secondNumber);

    return gcd(firstNumber, binarySubtraction(secondNumber, firstNumber));
  }

  /** TASK - 4
   * Stein algorithm for finding greatest common divisor.
   * Returns 0 if {@code firstNumber == 0 && secondNumber == 0}
   * If one of params equals 0 returns second one.
   *
   * @param firstNumber  first int number.
   * @param secondNumber second int number.
   * @return greatest common divisor of two number as int.
   */

  public static int binaryGcd(int firstNumber, int secondNumber) {
    //termination conditions
    if (firstNumber == secondNumber || secondNumber == 0) return firstNumber;
    if (firstNumber == 0) return secondNumber;

    if (firstNumber < 0) firstNumber = changeNumberSign(firstNumber);
    if (secondNumber < 0) secondNumber = changeNumberSign(secondNumber);


    //look for factors of 2
    // firstNumber and secondNumber are even
    // If u and v are both even, then binaryGcd(firstNumber, secondNumber) = 2·binaryGcd(firstNumber/2, secondNumber/2), because 2 is a common divisor
    if ((firstNumber & 1) == 0 && (secondNumber & 1) == 0) return binaryGcd(firstNumber >> 1, secondNumber >> 1) << 1;
      // firstNumber is even, secondNumber is odd
    else if ((firstNumber & 1) == 0) return binaryGcd(firstNumber >> 1, secondNumber);
      // firstNumber is odd, secondNumber is even
    else if ((secondNumber & 1) == 0) return binaryGcd(firstNumber, secondNumber >> 1);
      // secondNumber and firstNumber are odd
    else if (firstNumber >= secondNumber) return binaryGcd((firstNumber - secondNumber) >> 1, secondNumber);
      // firstNumber and secondNumber are odd
    else return binaryGcd(firstNumber, (secondNumber - firstNumber) >> 1);


  }

  /** TASK - 2
   * Change sign of decimal int number using bitwise operator.
   *
   * @param inputNumber - decimal int number.
   * @return Decimal number with other sign.
   */
  public static int changeNumberSign(int inputNumber) {
    return add(~inputNumber, 1);
  }

  /** TASK - 5
   * Change bit at certain position in decimal number and
   * returns new values. Position counting starts from 0.
   *
   * @param position - position of bit.
   * @param number   - input decimal number.
   * @param bitValue - new value of bit.
   * @return new decimal value of input number as long.
   */
  public static long changeBitAtPosition(int position, long number, byte bitValue) {
    if (bitValue < 0 || bitValue > 1) throw new IllegalArgumentException("bit value should be 0 or 1");

    int tmp = 1 << position;
    return (number & ~tmp) | ((bitValue << position) & tmp);
  }

  /** wrong task :<
   *
   * Method counts number of bits in binary representation of number
   * using bitwise operators. There is more efficient algorithm  "Hamming weight"
   *
   * @param inputDecimalNumber - input number as long.
   * @return decimal number which represents number of bits in input one.
   * @see java.lang.Integer#bitCount(int).
   */
  public static long countBits(long inputDecimalNumber) {
    return IntStream.range(0, 32)
            .filter(item -> ((inputDecimalNumber >>> item) & 1) == 1)
            .count();
  }


}
