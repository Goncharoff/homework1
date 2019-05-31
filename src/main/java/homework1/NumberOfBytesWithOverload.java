package homework1;

/**
 * just overload methods for computing number of bytes :) a lot of copy-paste
 * TASK - 3
 */
public class NumberOfBytesWithOverload {
  public static int sizeOf(byte inputChar) {
    int count = 0;
    while (inputChar != 0) {
      inputChar <<= 8;
      count++;
    }

    return count;
  }

  public static int sizeOf(short inputChar) {
    int count = 0;
    while (inputChar != 0) {
      inputChar <<= 8;
      count++;
    }

    return count;
  }

  public static int sizeOf(int inputInt) {
    int count = 0;
    while (inputInt != 0) {
      inputInt <<= 8;
      count++;
    }

    return count;
  }

  public static int sizeOf(long inputChar) {
    int count = 0;

    while (inputChar != 0) {
      inputChar <<= 8;
      count++;
    }

    return count;
  }
}
