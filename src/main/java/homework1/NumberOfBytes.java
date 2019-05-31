package homework1;

import static homework1.Homework1Utils.divideByEight;

public class NumberOfBytes {

  public static void main(String[] args) {
    System.out.println(sizeOfClass(byte.class));
    System.out.println(sizeOfClass(short.class));
    System.out.println(sizeOfClass(int.class));
    System.out.println(sizeOfClass(long.class));
  }

  /** TASK - 3
   * Method for computing number of bytes for
   * primitive params and wrap box classes for them.
   * Just divides given memory constants from classes
   * on 8, using bitwise operators.
   * <p>
   * {@see homework1.Homework1Utils#divideByEight(int)}
   * {@throws java.lang.NullPointerException} in input values == null
   *
   * @param dataType - class to calculate number of bytes.
   * @return - number of bytes for class, or 0 if class is incorrect;
   */
  public static int sizeOfClass(Class dataType) {
    int result = 0; // default for 32-bit memory pointer

    if (dataType == null) throw new NullPointerException();

    if (dataType == byte.class || dataType == Byte.class) result = divideByEight(Byte.SIZE);

    if (dataType == short.class || dataType == Short.class) result = divideByEight(Short.SIZE);

    if (dataType == int.class || dataType == Integer.class) result = divideByEight(Integer.SIZE);

    if (dataType == long.class || dataType == Long.class) result = divideByEight(Long.SIZE);


    return result;
  }


}
