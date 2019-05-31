import static homework1.Homework1.*;
import static homework1.Homework1.countBits;
import static homework1.Homework1Utils.*;
import static homework1.NumberOfBytes.sizeOfClass;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Homework1Tests {
  private final static String givenFirstBinaryAsString = "10";
  private final static String givenSecondBinaryAsString = "01010100101001";
  private final static String givenThirdBinaryAsString = "11000101";


  @Test
  void binaryToIntFirstVersionTest() {
    assertEquals(2, binaryToIntFirstFirstVersion(givenFirstBinaryAsString));
    assertEquals(5417, binaryToIntFirstFirstVersion(givenSecondBinaryAsString));
    assertEquals(197, binaryToIntFirstFirstVersion(givenThirdBinaryAsString));
  }

  @Test
  void binaryToIndSecondVersionTest() {
    assertEquals(2, binaryToIntSecondVersion(givenFirstBinaryAsString));
    assertEquals(5417, binaryToIntSecondVersion(givenSecondBinaryAsString));
    assertEquals(197, binaryToIntSecondVersion(givenThirdBinaryAsString));
  }

  @Test
  void checkBinaryChangingSign() {
    assertEquals(1, changeNumberSign(-1));
    assertEquals(-1, changeNumberSign(1));
    assertEquals(-112, changeNumberSign(112));
    assertEquals(122, changeNumberSign(-122));
    assertEquals(0, changeNumberSign(0));
  }

  @Test
  void usingBinaryOperatorGCDTest() {
    assertEquals(4, gcd(20, 12));
    assertEquals(10, gcd(-100, 10));
    assertEquals(1, gcd(0, 1));
    assertEquals(21, gcd(21, 0));
    assertEquals(0, gcd(0, 0));
  }

  @Test
  void binaryGCDTest() {
    assertEquals(4, binaryGcd(20, 12));
    assertEquals(10, binaryGcd(-100, 10));
    assertEquals(1, binaryGcd(0, 1));
    assertEquals(21, binaryGcd(21, 0));
    assertEquals(0, binaryGcd(0, 0));
  }


  @Test
  void changeBitAtPositionTest() {
    byte one = 1;
    byte zero = 0;

    assertEquals(0, changeBitAtPosition(1, 2, zero));
    assertEquals(5409, changeBitAtPosition(3, 5417, zero));
    assertEquals(199, changeBitAtPosition(1, 197, one));
  }

  @Test
  void countBitsTest() {
    assertEquals(1, countBits(2));
    assertEquals(6, countBits(5417));
    assertEquals(4, countBits(197));
  }


  //Test for utils methods which not are in subject of homework but used for it.
  @Test
  void printingTest() {
    assertEquals("10 -> 2", buildOutput(givenFirstBinaryAsString, 2));
    assertEquals("01010100101001 -> 5417", buildOutput(givenSecondBinaryAsString, 5417));
  }

  @Test
  void binaryAdditionTest() {
    assertEquals(3, add(1, 2));
    assertEquals(0, add(-2, 2));
    assertEquals(0, add(0, 0));
  }

  @Test
  void binarySubtractionTest() {
    assertEquals(2, binarySubtraction(0, -2));
    assertEquals(50, binarySubtraction(100, 50));
    assertEquals(-8, binarySubtraction(-4, 4));
  }

  @Test
  void errorInputParameters() {
    byte testByteNumber = -12;
    byte secondTestByteNumber = 100;

    Assertions.assertThrows(IllegalArgumentException.class, () -> changeBitAtPosition(12, 13, testByteNumber));
    Assertions.assertThrows(IllegalArgumentException.class, () -> changeBitAtPosition(12, 13, secondTestByteNumber));
  }

  @Test
  void testComputingNumberOfBItsForClasses() {
    assertEquals(sizeOfClass(byte.class), 1);
    assertEquals(sizeOfClass(short.class), 2);
    assertEquals(sizeOfClass(int.class), 4);
    assertEquals(sizeOfClass(long.class), 8);
  }

  @Test
  void sizeOfClassShouldTThrowNPE() {
    Assertions.assertThrows(NullPointerException.class, () -> sizeOfClass(null));
  }
}
