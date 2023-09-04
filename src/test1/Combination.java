import java.util.ArrayList;
import java.util.List;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 组合（1到n中所有可能k个数的组合）
 * @AUTHOR jianglu
 * @DATE 2022/11/28
 *******************************************************************************************************/
public class Combination {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(combination.combination(4, 2));
    }

    public List<List<Integer>> combination(int n , int k) {
        dfs(n, k, 1);
        return res;
    }

    public void dfs(int n, int k, int start) {
        if (output.size() == k) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i <= n; i++) {
            output.add(i);
            dfs(n, k, i + 1);
            output.remove(output.size() - 1);
        }
    }
}
