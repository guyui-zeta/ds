package com.atguigu.array;

/**
 * 稀疏数组
 * @author Zeta
 * @version 1.0
 * @date 2021/3/11 21:18
 */
public class Sparsearry {
    //二维数组转稀疏数组的思路
    /**
     * 1.遍历原始的二维数组，得到有效数据的个数sum
     * 2.根据sum就可以创建稀疏数组sparseArr int[sum+1][3];
     * 3.将二维数组的有效数据存入到稀疏数组
     */
    //稀疏数组转原始的二维数组的思路
    /**
     * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组12323232
     * 2.在读取稀疏数组后几行的数据，并付给原始的二维数组即可123
     */
    public static void main(String[] args) {
        //创建一个原始的二维数组11*1
        //默认为0：没有旗子，1表示黑子，2表示蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        System.out.println("原始的二维数组：");
        for(int[] row : chessArr)
        {
            for(int data: row)
            {
                System.out.printf("%d",data);
            }
            System.out.println();
        }

        //一、将二维数组转换为稀疏数组
        //计算出二维数组中的有效值个数
        int sum = 0;
        for(int[] row : chessArr)
        {
            for(int data : row)
            {
                if(data != 0)
                {
                  sum++;
                }
            }
        }
        //行数：sum+1，第一行存储稀疏数组的信息
        //列数：3，【行，列，值】
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组第一行赋值
        //稀疏数组的第一行存储【行数，列数，有效值个数】
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int i = 1;
        //给稀疏数组后几行赋值
        for(int x = 0; x < chessArr.length; x++)
        {
            for(int y = 0; y < chessArr[x].length; y++)
            {
                if(chessArr[x][y] != 0)
                {
                    sparseArr[i][0] = x;
                    sparseArr[i][1] = y;
                    sparseArr[i][2] = chessArr[x][y];
                    i++;
                }
            }
        }
        System.out.println("转化为稀疏数组后为：");
        for(int[] row : sparseArr)
        {
            for(int data : row)
            {
                System.out.printf("%d",data);
            }
            System.out.println();
        }

        //二、稀疏数组转化为原数组
        //1.读取稀疏数组的第一行，确定原数组的尺寸
        //2.读取稀疏数组的后面几行，确定有效数值的位置和val
        int x = sparseArr[0][0];
        int y = sparseArr[0][1];
        sum = sparseArr[0][2];
        int chessArr2[][] = new int[x][y];
        for(i = 1; i <= sum; i++)
        {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("稀疏数组转化为原数组：");
        for(int[] row : chessArr2)
        {
            for(int data : row)
            {
                System.out.printf("%d",data);
            }
            System.out.println();
        }

    }
}
