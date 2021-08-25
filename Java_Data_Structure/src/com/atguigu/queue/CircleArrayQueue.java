package com.atguigu.queue;

import java.util.Scanner;

/**
 * 环形队列
 * @author Zeta
 * @version 1.0
 * @date 2021/3/15 14:13
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //1.创建队列
        myCircleArrayQueue queue = new myCircleArrayQueue(10);
        char key ;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop)
        {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个添加的data");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g':
                    System.out.println("取出的数据为：" + queue.delete());
                    break;
                case 'h':
                    System.out.println("队列的头数据为：" + queue.head());
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}

class myCircleArrayQueue{
    private int front;
    private int rear;
    private int MaxSize;
    private int[] arr;

    public myCircleArrayQueue(int maxSize) {
        MaxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull()
    {
        return (rear + 1)%MaxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty()
    {
        return rear == front;
    }
    //添加数据：进队列
    public void add(int data)
    {
        if(isFull())
        {
            throw new RuntimeException("队列已满，无法添加新数据");
        }

        arr[rear] = data;
        rear = (rear + 1)%MaxSize;
    }

    //删除数据：出队列
    public int delete()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列已空，无法删除数据");
        }

        int ReadData = arr[front];
        arr[front] = 0;
        front = (front + 1)%MaxSize;
        return ReadData;
    }

    //显示队列数据
    //size求出队列中的有效数据
    public void show()
    {
        for(int i = front; i < front + size(); i++)
        {
            System.out.println("a[" + i%MaxSize + "]= " + arr[i%MaxSize]);
        }
    }

    //查看队列头数据，不取出
    public int head()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列已空，无头数据");
        }
        return arr[front];
    }

    //求出当前队列有效数据的个数
    public int size()
    {
        return (rear + MaxSize - front)%MaxSize;
    }
}
