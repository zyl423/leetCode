package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 *
 * @Author: Zyl
 * @Date: 2024-07-09 21:28
 */
public class QueueUsingStacks {
    static class MyQueue{
        ArrayDeque<Integer> inStack;
        ArrayDeque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                this.in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                this.in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        int param_5 = obj.pop();
        boolean param_6 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
    }
}
