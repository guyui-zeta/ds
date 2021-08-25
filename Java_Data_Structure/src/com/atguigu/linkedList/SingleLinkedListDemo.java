package com.atguigu.linkedList;

/**
 * @author Zeta
 * @version 1.0
 * @date 2021/3/16 21:11
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1,"宋江","及时雨");
        HeroNode h2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode h3 = new HeroNode(3,"吴用","智多星");
        HeroNode h4 = new HeroNode(4,"林冲","豹子头");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(h1);
        linkedList.add(h2);
        linkedList.add(h3);
        linkedList.add(h4);
        linkedList.delete(2);
        HeroNode newheroNode = new HeroNode(3,"无用","笨多星");
        linkedList.update(newheroNode);
        linkedList.showList();
        linkedList.addByOrder(h2);
        System.out.println("--------------------------");
        linkedList.showList();
        System.out.println("------------倒数第k个数--------------");
        System.out.println(linkedList.findFinalIndexNode(1));
        System.out.println("------------反转单链表--------------");
        linkedList.reverselink();
        linkedList.showList();

    }
}



class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;


    //链表节点构造方法不能有next，必须手动连接
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }



    //为了显示方便，重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'';
    }
}


//英雄管理类
class SingleLinkedList {
    //先初始化一个头节点，头节点不动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");//————————很重要的头节点
    //第一种添加方式：添加节点到单向链表的末端
    public void add(HeroNode heroNode)
    {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        while(true)
        {
            //找到链表的末端
            if(temp.next == null)
            {
                break;
            }
            //如果没有找到最后，每次temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //第二种添加方式：根据排名将英雄插入到指定位置
    public void addByOrder(HeroNode heroNode)
    {
        HeroNode temp = head;
        boolean flag = true;
        while(true)
        {
            if(temp.next == null)
            {
                break;
            }
            else if(temp.next.no > heroNode.no)
            {
                break;
            }
            else if(temp.next.no  == heroNode.next.no)
            {
                flag = false;
            }
            temp = temp.next;
        }
        if(flag == true)
        {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
        else
        {
            System.out.printf("准备插入的英雄编号%d已经存在\n",heroNode.no);
        }
    }


    //修改节点的信息，根据no编号来修改
    public void update(HeroNode newHeroNode)
    {
        HeroNode temp = head;
        boolean flag = false;
       //先判断是否为空：空链表
        if(temp.next == null)
        {
            System.out.println("链表已空");
            return;
        }
        while (true)
        {
            if(temp == null)
            {
                System.out.println("链表已空");
                break;
            }
            if(temp.no == newHeroNode.no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag)
        {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
        else
        {
            System.out.printf("未找到准备更新的英雄编号为%d",newHeroNode.no);
        }
    }


    //删除节点
    public void delete(int no)
    {
        HeroNode temp = head;
        boolean flag = false;
        if(temp.next == null)
        {
            System.out.println("链表已空");
            return;
        }
        while(true)
        {
            if(temp == null)
            {
                System.out.println("链表已空");
                break;
            }
            if(temp.next.no == no)
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag)
        {
            temp.next = temp.next.next;
        }
        else
        {
            System.out.printf("未找到需要删除的节点：%d",no);
        }
    }

    //显示链表
    public void showList()
    {
        //判断链表是否为空
        if(head.next == null)
        {
            System.out.println("链表已空");
            return;
        }
        HeroNode temp = head.next;
        while(true)
        {
            if(temp == null)
            {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //【新浪面试题】:寻找单链表中到数第k个结点
    public HeroNode findFinalIndexNode(int k)
    {
        HeroNode temp = head;
        if(head.next == null)
        {
            return null;
        }
        int length = getLength(head);
        if(k < 0 || k > length)
        {
            return null;
        }
        for(int i = 0; i <= length - k; i++)
        {
            temp = temp.next;
        }
        return temp;


    }

    //【面试题】获取链表的长度,统计有效节点的个数
    public int getLength(HeroNode head)
    {
        if(head.next == null)
        {
            return 0;
        }
        HeroNode temp = head;
        int length = 0;
        while(temp.next != null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //【面试题】反转链表,双指针法【链表双指针思路】
    //不能一个存结点，一个去操作，因为node始终只有一个
    public void reverselink()
    {
        //如果链表是空或者只有一个节点时，无需反转，直接返回
        if(head.next == null || head.next.next == null)
        {
            return;
        }
        HeroNode cur = head.next;//表示当前结点
        HeroNode next = null;//表示当前结点的下一个节点，作为【暂存】，避免消失
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur != null)
        {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;


    }
    
    
}