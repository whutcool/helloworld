import java.util.Scanner;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 字节面试题（最长连续字母子串）
 * @AUTHOR jianglu
 * @DATE 2022/11/9
 *******************************************************************************************************/
public class LongestSubLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = str.length();
        int[] array = new int[n];
        int start = 0, max = 0;
        array[0] = 0;
        for (int i = 1; i < n; i++) {
            array[i] = str.charAt(i) - str.charAt(i - 1);
        }
        for (int i = 0; i < n; i++) {
            if ((array[i] == 1 || array[i] == -1)) {
                int idStart = i;
                int idMax = 1;
                while ((i < n - 1) && array[i] == array[i + 1]) {
                    i++;
                    idMax++;
                }
                if (idMax > max) {
                    max = idMax;
                    start = idStart;
                }
            }
        }
        System.out.println(str.substring(start - 1, start + max));

    }
}
