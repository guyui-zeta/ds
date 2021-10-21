package com.atguigu.binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @author Zeta
 * @version 1.0
 * @date 2021-10-21 14:24
 */
public class PreMidOrder {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        TreeNode<Integer> l = new TreeNode<Integer>(2);
        TreeNode<Integer> r = new TreeNode<Integer>(3);
        TreeNode<Integer> ll = new TreeNode<Integer>(4);
        TreeNode<Integer> lr = new TreeNode<Integer>(5);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        midOrder(root);


    }

    /**
     * 先序遍历非递归实现
     * @param root
     */
    private static void preOrder(TreeNode<Integer> root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode<Integer> node = stack.pop();
            System.out.print(node.val + " ");
            //把当前节点的左右孩子加进来
            //注意应该先是将右孩子加进来
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历非递归实现
     * 思路：
     * 1.先把所有的左子节点，入栈至无左节点：左
     * 2.出栈，作为无左的中节点，并打印：中
     * 3.更新为右节点：右
     * @param root
     */
    private static void midOrder(TreeNode<Integer> root){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                //将所有的左分支全部先入栈，直到root为空：左
                stack.push(root);
                root = root.left;
            }else{
                //左分支遍历完后，出栈root作为：中
                root = stack.pop();
                System.out.println(root.val);
                //中遍历完之后，同理遍历右：右
                root = root.right;
            }
        }
    }
}


class TreeNode<T>{
    T val;
    TreeNode<T> left;
    TreeNode <T> right;
    public TreeNode(T val) {
        super();
        this.val = val;
    }
}
