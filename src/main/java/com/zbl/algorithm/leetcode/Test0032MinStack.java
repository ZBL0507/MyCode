package com.zbl.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnkq37/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0032MinStack {

    private ArrayList<Integer> eles = null;

    private int minValueIndex = -1;

    /**
     * initialize your data structure here.
     */
    @SuppressWarnings("all")
    public Test0032MinStack() {
        eles = new ArrayList<>();
    }

    @SuppressWarnings("all")
    public void push(int val) {
        eles.add(val);
        modifyMinValueIndex();
    }

    private void modifyMinValueIndex() {
        if (!eles.isEmpty()) {
            minValueIndex = 0;
            for (int i = 1; i < eles.size(); i++) {
                if (eles.get(minValueIndex) > eles.get(i))
                    minValueIndex = i;
            }
        }
    }

    @SuppressWarnings("all")
    public void pop() {
        eles.remove(eles.size() - 1);
        modifyMinValueIndex();
    }

    public int top() {
        return eles.get(eles.size() - 1);
    }

    @SuppressWarnings("all")
    public int getMin() {
        return eles.get(minValueIndex);
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Test0032MinStack stack = new Test0032MinStack();
        stack.push(1);
        System.out.println("此时堆栈中的最小值： " + stack.getMin());
        stack.push(3);
        System.out.println("此时堆栈中的最小值： " + stack.getMin());
        stack.push(4);
        System.out.println("此时堆栈中的最小值： " + stack.getMin());
        stack.push(-1);
        System.out.println("此时堆栈中的最小值： " + stack.getMin());
        stack.push(5);
        System.out.println("此时堆栈中的最小值： " + stack.getMin());

        System.out.println("元素开始出栈");
        System.out.println("出栈元素：" + stack.top());
        stack.pop();
        System.out.println("此时堆栈中的最小值： " + stack.getMin());

        System.out.println("出栈元素：" + stack.top());
        stack.pop();
        System.out.println("此时堆栈中的最小值： " + stack.getMin());

        System.out.println("出栈元素：" + stack.top());
        stack.pop();
        System.out.println("此时堆栈中的最小值： " + stack.getMin());

        System.out.println("出栈元素：" + stack.top());
        stack.pop();
        System.out.println("此时堆栈中的最小值： " + stack.getMin());
    }
}
