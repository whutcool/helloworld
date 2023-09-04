import java.util.LinkedList;
import java.util.List;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/12/2
 *******************************************************************************************************/
public class RangeList {
    List<Range> res = new LinkedList<>();

    public void add(Range range) {
        if (!valid(range)) {
            return;
        }
        if (res.isEmpty()) {
            res.add(range);
        }
        int left = range.getLeft();
        int right = range.getRight();
        // 是否在某个区间
        boolean leftBelong = false, rightBelong = false;
        // 对应区间位置，如果不在某个区间，返回所在右边位置
        int leftAt = res.size(), rightAt = res.size();
        for (int i = 0; i < res.size(); i++) {
            Range ran = res.get(i);
            if (left >= ran.getLeft() && left <= ran.getRight()) {
                leftBelong = true;
                leftAt = i;
                break;
            } else if (left < ran.getLeft()) {
                leftAt = i;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            Range ran = res.get(i);
            if (right >= ran.getLeft() && right <= ran.getRight()) {
                rightBelong = true;
                rightAt = i;
            } else if (right < ran.getLeft()) {
                rightAt = i;
            }
        }
        if (leftBelong && rightBelong) {
            return;
        } else if (!leftBelong && !rightBelong) {
            if (leftAt == rightAt) {
                res.add(leftAt, range);
            } else {
                int idx = rightAt - 1;
                for (int i = 0; i < rightAt - leftAt; i++) {
                    res.remove(idx--);
                }
                res.add(leftAt, range);
            }
        } else if (leftBelong && !rightBelong) {
            // TODO
        }
    }

    public void remove() {

    }

    public void print() {

    }

    private boolean valid(Range range) {
        return range != null && range.getLeft() <= range.getLeft();
    }

}

class Range {
    private int left;
    private int right;

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
