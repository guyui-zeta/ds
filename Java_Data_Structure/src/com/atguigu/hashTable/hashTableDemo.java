package com.atguigu.hashTable;

public class hashTableDemo {
    public static void main(String[] args) {
        hashTab hashTab = new hashTab(5);
        //0.哈希表的添加
        hashTab.add(new emp(0,"0号"));
        hashTab.add(new emp(1,"1号"));
        hashTab.add(new emp(2,"2号"));
        hashTab.add(new emp(3,"3号"));
        hashTab.add(new emp(4,"4号"));
        hashTab.add(new emp(5,"5号"));
        hashTab.add(new emp(6,"6号"));
        //1.哈希表的遍历
        hashTab.list();
        //2.哈希表的查找
        hashTab.find(1);
        //3.哈希表的删除
        hashTab.del(1);
        hashTab.list();

    }
}
class emp{
    public int id;
    public String name;
    public emp next;

    public emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class empLinkedList{
    public emp head;
    //1.增加员工
    //如果头结点没有值，直接赋值，否则遍历到最后一个节点赋值
    public void add(emp emp){
        if(head == null){
            head = emp;
        }else{
            emp temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = emp;
        }
    }
    //2.遍历员工
    public void list(){
        emp temp = head;
        while(temp != null){
            System.out.println("员工id:"+ temp.id + "员工姓名:" + temp.name);
            temp = temp.next;
        }
    }
    //3.查找员工
    public emp find(int id){
        emp temp = head;
        while(temp != null){
            if(temp.id == id){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //4.删除员工
    public int del(int id){
        emp temp = head;
        //如果删除的是第一个结点,则更新新的head结点
        if(head.id == id){
            head = head.next;
            return 1;
        }
        while(temp != null){
            if(temp.next.id == id){
                temp.next = temp.next.next;
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
}
class hashTab{
    int size;
    empLinkedList[] empLinkedListArr;
    //构造器
    public hashTab(int size){
        this.size = size;
        empLinkedListArr = new empLinkedList[size];
        //【坑】还要初始化数组中的每一个链表，否则此时都是null，没有对象的【单例模式】
        for(int i = 0; i < size; i++){
            empLinkedListArr[i] = new empLinkedList();
        }
    }
    //散列/哈希规则
    public int hashFun(int id){
        return id % size;
    }
    //1.添加
    //先通过hashfun找到在链表数组中的位置，再从链表中添加
    public void add(emp emp){
        int afterHashId = hashFun(emp.id);
        empLinkedListArr[afterHashId].add(emp);
    }
    //2.遍历
    public void list(){
        for(int i = 0; i < size; i++){
            System.out.println("第" + i + "行散列表");
            empLinkedListArr[i].list();
        }
    }
    //3.查找
    public void find(int id){
        int afterHashId = hashFun(id);
        emp res = empLinkedListArr[afterHashId].find(id);
        System.out.println((res == null)?"没有找到该员工":"找到该员工为：" + "员工id:" + res.id
        + "员工姓名：" + res.name);
    }
    //4.删除
    public void del(int id){
        int afterHashId = hashFun(id);
        int res = empLinkedListArr[afterHashId].del(id);
        System.out.println((res == 1)?"删除成功":"删除失败");
    }




}
