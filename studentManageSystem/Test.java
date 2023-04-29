package li.zhe.studentManageSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建集合存储信息
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            //搭建选择菜单
            System.out.println("--------------学生信息管理系统--------------");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.更改学生信息");
            System.out.println("4.查询学生信息");
            System.out.println("5.退出系统");
            System.out.println("请选择：");

            String choose = sc.next();
            //根据选择实现对应功能
            switch (choose) {
                case "1":
                    System.out.println("----添加----");
                    addInfo(list);
                    break;
                case "2":
                    System.out.println("----删除----");
                    delInfo(list);
                    break;
                case "3":
                    System.out.println("----更改----");
                    replaceInfo(list);
                    break;
                case "4":
                    System.out.println("----查询----");
                    referInfo(list);
                    break;
                case "5":
                    System.out.println("---退出系统---");
                    System.exit(1);
                default:
                    System.out.println("选择错误，请重选：");

            }
        }
    }

    //添加
    public static void addInfo(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        //创建学生对象
        Student stu = new Student();
        //录入信息
        System.out.println("请输入id：");
        //id唯一性判断
        while (true) {
            String s = sc.next();
            boolean flag = idOnly(list, s);
            if (flag) {
                System.out.println("id已存在，请重新输入：");
            } else {
                stu.setId(s);
                break;
            }
        }

        System.out.println("请输入姓名：");
        stu.setName(sc.next());
        System.out.println("请输入年龄：");
        stu.setAge(sc.nextInt());
        System.out.println("请输入家庭住址：");
        stu.setAddress(sc.next());
        //将录入信息存入集合
        list.add(stu);
    }

    //删除
    public static void delInfo(ArrayList<Student> list) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("输入要删除信息的id:");
            String s=sc.next();
            //判断系统中是否有该id
            boolean flag=idOnly(list,s);
            //有，删除该信息
            if (flag){
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().equals(s)) {
                        list.remove(i);
                        System.out.println("删除成功");
                        break;
                    }
                }
                break;
            //没有，给出提示
            }else {
                System.out.println("该id不存在！");
            }
        }
    }

    //更改
    public static void replaceInfo(ArrayList<Student> list) {
        Scanner sc=new Scanner(System.in);
        int flag;
        while (true) {
            System.out.println("请输入要修改的信息的id:");
            String s=sc.next();
            //查询id是否存在并返回索引
            flag=idOnly2(list,s);
            if (flag!=-1){
                break;
            }else {
                System.out.println("该id不存在！");
            }
        }
        //修改信息
        System.out.println("请输入姓名：");
        list.get(flag).setName(sc.next());
        System.out.println("请输入年龄：");
        list.get(flag).setAge(sc.nextInt());
        System.out.println("请输入家庭住址：");
        list.get(flag).setAddress(sc.next());
        System.out.println("修改成功！");
    }


    //查询
    public static void referInfo(ArrayList<Student> list) {
        if (list.size() == 0)
            System.out.println("当前系统无信息，请添加后再进行查询");
        else {
            System.out.println("id\t姓名\t年龄\t家庭住址");
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getAddress());
            }
        }
    }

    //检查id是否存在
    public static boolean idOnly(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id))
                return true;
        }
        return false;
    }
    //将对应id的索引返回
    public static int idOnly2(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }
    
}
