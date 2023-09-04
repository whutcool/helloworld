import java.util.Arrays;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 快速排序
 * @AUTHOR jianglu
 * @DATE 2022/11/6
 *******************************************************************************************************/
public class FastSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 9, 9, 6, -1, 8};
        fastSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * 快速排序
     * 1. 取一个基准值privot，两个指针left和right
     * 2. right向左移动找到比privot小的值停止
     * 3. left向右移动找到比privot大的值停止
     * 4. left和right的值交换，继续移动
     * 5. left和right相遇，交换相遇点和privot的值，递归继续排序
     * @param nums
     * @param low
     * @param high
     */
    public static void fastSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int privot = nums[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && nums[right] >= privot) {
                right--;
            }
            while (left < right && nums[left] <= privot) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, low, left);
        fastSort(nums, low, left - 1);
        fastSort(nums, right + 1, high);
    }
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
