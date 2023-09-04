import java.util.HashSet;
import java.util.List;
import java.util.Set;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION 二叉树前序遍历（数组输入）
 * @AUTHOR jianglu
 * @DATE 2022/11/29
 *******************************************************************************************************/
public class TreePreOrder {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(List.of(4, 5), List.of(1, 2), List.of(2, 3), List.of(1, 4));
        treePreOrder(lists);
    }

    public static void treePreOrder(List<List<Integer>> a) {
        Integer head = findHead(a);
        backtrack(a, head);
    }

    public static void backtrack(List<List<Integer>> a, Integer head) {
        System.out.println(head);
        for (List<Integer> list : a) {
            if (head.equals(list.get(0))) {
                backtrack(a, list.get(1));
            }
        }
    }

    public static Integer findHead(List<List<Integer>> a) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        a.forEach(it -> {
            first.add(it.get(0));
            second.add(it.get(1));
        });
        for (Integer firstItem : first) {
            if (!second.contains(firstItem)) {
                return firstItem;
            }
        }
        return null;
    }
}
