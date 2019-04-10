package kam.yiuman.bigeyes.leecode;

/**
 * leecode两数相加题原型，链表结构，逆序排列
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author yiuman
 * @date 2019-02-16
 */
public class ListNode {

    private int value;

    private ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {

        ListNode realNode;

        ListNode on;

        ListNode next;

        public Builder next(int val) {
            ListNode node = new ListNode(val);
            if (realNode == null) {
                on = node;
                realNode = node;
            } else {
                next = node;
                on.next = node;
                on = node;
            }

            return this;
        }

        public ListNode build() {
            return realNode;
        }

    }

}
