import java.util.*;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 合并多个集合
 * @AUTHOR jianglu
 * @DATE 2022/10/21
 *******************************************************************************************************/
public class MergeTwo {

    public int[] mergeTwo(int[] a, int[] b) {
        List<Integer> merge = new ArrayList<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            result.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (result.contains(b[i])) {
                merge.add(b[i]);
            }
        }
        return merge.stream().mapToInt(Integer::valueOf).toArray();
    }

    int[]  andMerge(int[][] input) {
        int[] result = input[0];
        for (int i = 1; i < 4; i++) {
            result = mergeTwo(result, input[i]);
        }
        return null;
    }
}
