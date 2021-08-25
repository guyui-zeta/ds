package com.atguigu.queue;

import java.util.Scanner;

/**队列
 * @author Zeta
 * @version 1.0
 * @date 2021/3/15 13:05
 */
public class Queue {
    public static void main(String[] args) {
        //1.创建队列
        ArrayQueue queue = new ArrayQueue(10);
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

class ArrayQueue{
    private int front;
    private int rear;
    private int MaxSize;
    private int[] arr;
    //构造方法
    public ArrayQueue(int maxSize) {
        MaxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull()
    {
        return rear == MaxSize - 1;
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
        rear++;
        arr[rear] = data;
    }

    //删除数据：出队列
    public int delete()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列已空，无法删除数据");
        }
        front++;
        int ReadData = arr[front];
        arr[front] = 0;
        return ReadData;
    }

    //显示队列数据
    public void show()
    {
        for(int i = front + 1; i <= rear; i++)
        {
            System.out.println("a[" + i + "]= " + arr[i]);
        }
    }

    //查看队列头数据，不取出
    public int head()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列已空，无头数据");
        }
        return arr[front + 1];
    }
}
