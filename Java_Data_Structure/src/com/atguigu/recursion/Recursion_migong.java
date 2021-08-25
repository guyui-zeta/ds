package com.atguigu.recursion;

public class Recursion_migong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用 1 表示墙
        // 上下全部置为 1
        for(int i = 0; i < 7;i++)
        {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右全部置为 1
        for(int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;

        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //通过递归找到迷宫路径
        //1.起点1，1终点6,5
        //2.约定：map[i][j] = 0表示没走过
        //       map[i][j] = 1表示墙
        //       map[i][j] = 2表示通路可以走
        //       map[i][j] = 3表示走过且不通
        //3.迷宫策略：下右上左
        System.out.println(setway(map,1,1));
        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("迷宫的解");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }



    }
    public static boolean setway(int[][] map, int i, int j )
    {
        //设置递归结束条件：map[6][5] = 2
        if(map[6][5] == 2)
        {
            return true;
        }
        //分两类判断:map[i][j]=0和map[i][j]！=0即123
        //当0时，表示没走过，先设为2，然后递归判断下右上左
        //当123时，表示走不了或者之前走过，此时return false，表示该路不能走
        if(map[i][j] == 0)
        {
            map[i][j] = 2;
            if(setway(map,i+1,j))//下
            {
                return true;
            }
            else if(setway(map,i,j+1))//右
            {
                return true;
            }
            else if(setway(map,i-1,j))//上
            {
                return true;
            }
            else if(setway(map,i,j-1))//左
            {
                return true;
            }
            else
            {
                map[i][j] = 3;
                return false;
            }
        }
        else //当map[i][j]！=0，即=123时，表示走不通
        {
            return false;
        }

    }
}
