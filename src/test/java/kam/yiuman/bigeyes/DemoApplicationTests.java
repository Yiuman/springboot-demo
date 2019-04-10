package kam.yiuman.bigeyes;

import kam.yiuman.bigeyes.leecode.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Test
    public void contextLoads() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - 1; j++)
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[]{i, j};
                    System.out.println(result.toString());
                }
        }

    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    @Test
    public void addListNode() {
        ListNode node1 = ListNode.builder()
                .next(2)
                .next(4)
                .next(3)
                .build();

        ListNode node2 = ListNode.builder()
                .next(5)
                .next(6)
                .next(4)
                .build();

        ListNode.Builder builder = ListNode.builder();

        ListNode n1 = node1, n2 = node2;

        int carry = 0;
        while (n1 != null || n2 != null) {
            int reuslt = (n1 == null ? 0 : n1.getValue()) + (n2 == null ? 0 : n2.getValue()) + carry;

            builder.next(reuslt % 10);
            carry = reuslt / 10;

            n1 = n1.getNext();

            n2 = n2.getNext();

        }

        if (carry == 1) {
            builder.next(1);
        }


        System.out.println(builder.build());


    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例1：
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例2：
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例3：
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    @Test
    public void lengthOfLongestSubstring() {
        String str = "dvdf";
        List<String> elements = new ArrayList<>();
        int lengthOfLongestSubstring = 0;
        for (String element : str.split("")) {
            if(element.isEmpty()){
                continue;
            }

            int elementsSize = elements.size();
            if (elements.contains(element)) {
                if(element.equals(elements.get(elementsSize-1))){
                    elements = new ArrayList<>();
                }else{
                    elements = elements.subList(elements.indexOf(element)+1,elementsSize);
                }
            }

            elements.add(element);
            elementsSize = elements.size();
            if (lengthOfLongestSubstring < elementsSize) {
                lengthOfLongestSubstring = elementsSize;
            }

        }
        System.out.println(lengthOfLongestSubstring);
    }


}
