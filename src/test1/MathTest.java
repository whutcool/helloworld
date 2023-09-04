/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 开根号
 * @AUTHOR jianglu
 * @DATE 2022/10/21
 *******************************************************************************************************/
public class MathTest {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(8));
        System.out.println(mySqrt(8));
    }

    public static float mySqrt(float x) {
        float min = 0;
        float max = x;
        float mid = (min + max) / 2;
        while(true) {
            if (Math.abs(x - mid * mid) < 0.001) {
                return mid;
            }
            if (mid * mid > x) {
                max = mid;
            } else if (mid * mid < x) {
                min = mid;
            }
            mid = (min + max) / 2;
        }
    }
}
