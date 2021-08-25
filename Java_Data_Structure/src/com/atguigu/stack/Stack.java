package com.atguigu.stack;

/**
 * @author Zeta
 * @version 1.0
 * @date 2021/3/24 21:52
 */
public class Stack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
    }
}


class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }
    //判断栈是否满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value)
    {
        if(isFull())
        {
            System.out.println("栈已满，无法入栈");
            return;
        }
        else
        {
            top++;
            stack[top] = value;
        }
    }

    //出栈
    public int pop()
    {
        if(isEmpty())
        {
            throw new RuntimeException("栈已空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void show()
    {
        if(isEmpty())
        {
            System.out.println("栈空，没有数据");
            return;
        }
        for(int i = top; i >= 0 ;i-- )
        {
            System.out.println(stack[i]);
        }
    }




}



