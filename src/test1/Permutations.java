import java.util.ArrayList;
import java.util.List;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 全排列
 * @AUTHOR jianglu
 * @DATE 2022/11/27
 *******************************************************************************************************/
public class Permutations {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permutatison(nums));
    }

    public List<List<Integer>> permutatison(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(nums, used);
        return res;
    }

    public void dfs(int[] nums, boolean[] used) {
        if (output.size() == nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                output.add(nums[i]);
                used[i] = true;
                dfs(nums, used);
                used[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }
}
