package com.wsh.coding.guidelines.programmingcode;

import java.util.*;

/**
 * @Title: JavaCodeOptimize
 * @ProjectName alibaba_coding_guidelines
 * @Description: Java代码优化常用方法
 * @Author WeiShiHuai
 * @Date 2018/10/9 16:58
 */
public class JavaCodeOptimize {

    public static void main(String[] args) {

        /**
         * 优化方法1: 尽量重用对象，避免不必要的new创建对象
         */
        String namePrefix = "wei";
        String nameSuffix = "xiaohuai";
        //不推荐用法
        //Java虚拟机会重新创建一个新的对象返回,影响效率
        String name = namePrefix + nameSuffix;
        System.out.println(name);

        //推荐用法
        //字符串拼接使用StringBuilder或者StringBuffer
        StringBuilder stringBuilder = new StringBuilder("wei");
        stringBuilder.append("xiaohuai");
        System.out.println(stringBuilder);


        /**
         * 优化方法2: 在进行IO操作的时候，要及时关闭流对象
         * 一般采用try-catch-finally的finally块中关闭流
         */
        //推荐用法
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(new File("D:/a.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != inputStream) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


        /**
         * 优化方法3: for循环遍历的时候尽量减少对变量(集合长度)的重复计算
         */
        //不推荐用法
        List<String> list = new ArrayList<>(10);
        list.add("zhangsan");
        list.add("lisi");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //推荐用法
        //先计算集合的总长度,避免重复计算，在集合非常大的时候效率会提高很多
        for (int i = 0, size = list.size(); i < size; i++) {
            System.out.println(list.get(i));
        }

        /**
         * 优化方法4: 在需要用到的时候才创建变量(懒加载)
         */
        //不推荐使用
        String str = "wangwu";
        int idx = 1;
        if (idx == 1) {
            System.out.println(str);
        }

        //推荐使用（在需要使用的时候才创建）
        if (idx == 1) {
            String s = "wangwu";
            System.out.println(s);
        }


        /**
         * 优化方法5: 复制大量数据时，使用System.arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
         * 说明: 避免循环数组，一个一个加入到新数组中，这样数据量大的时候效率很低
         */
        //推荐用法
        String[] names = new String[]{"a", "b", "c", "d"};
        String[] newNames = new String[names.length];
        System.arraycopy(names, 0, newNames, 0, names.length);
        //[a, b, c, d]
        System.out.println(Arrays.toString(newNames));


        /**
         * 优化方法6: 在循环中不要不断创建对象引用
         */
        //不推荐用法
        //这样在内存中会存在10000份person对象的引用，耗内存资源
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            //...一系列操作
        }

        //推荐用法
        //内存中只有一份Person对象引用，每次new Person()创建对象，person对象引用指向不同的Person，节省内存资源
        Person person = null;
        for (int i = 0; i < 10000; i++) {
            person = new Person();
            //...一系列操作
        }


        /**
         * 优化方法7: 避免随意使用静态变量
         */
        //不推荐用法
        //Java的垃圾回收器不会回收static对象，如果A类不被卸载，那么引用B指向的B对象会常驻内存，直到程序终止
//        public class A {
//            private static B b = new B();
//        }


        /**
         * 优化方法8: 常量尽量定义为static final，这样在编译的时候就可以把值放入常量池中，避免计算常量的值
         */
//        static final String ACCESS_TOKEN = "abcd";


        /**
         * 优化方法9: 随机访问比较多、顺序插入的场景使用ArrayList,中间插入、删除、更新多、随机访问少的场景使用LinkedList
         * 说明: ArrayList底层实现是数组，随机访问直接通过下标获取，速度快，但是删除、中间插入需要移动元素，速度慢
         * LinkedList底层实现是链表，插入删除只需要改变指针，速度快，但是随机访问需要循环遍历，速度慢
         */

        /**
         * 优化方法10: 字符串变量和字符串常量equals的时候将字符串常量写在前面
         */
        //不推荐用法
        //可能会发生NotPointerException空指针异常
        String word = "abc";
        if (word.equals("abc")) {
            //...
        }

        //推荐用法
        if ("abc".equals(word)) {
            //...
        }
        //或
        boolean isEqual = Objects.equals("abc", word);

        /**
         * 优化方法11: 基本数据类型转为字符串，基本数据类型.toString()是最快的方式、String.valueOf(数据)次之、数据+""最慢
         */
        //推荐使用
        int i = 10;
        String iStr = Integer.toString(i);

        String s = String.valueOf(10);

        //不推荐
        String s1 = i + "";


        /**
         * 优化方法12: 使用效率高的方法遍历Map,尽量使用entrySet，直接将key/value都查询出来。
         */
        Map<String, Object> map = new HashMap<>(10);
        map.put("name", "weixiaohuai");
        map.put("age", "20");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
        }


        /**
         * 优化方法13: 底层使用可变数组的数据结构尽量指定长度
         * 说明: 当指定长度时，只有在超过指定的长度时，才会执行扩容操作，使用的时候应尽量预估它的大小，尽量指定大小
         */
        //推荐用法
        List<String> newList = new ArrayList<>(10);
        Map<String, Object> newMap = new HashMap<>(10);

        /**
         * 优化方法14: String类尽量使用StringBuffer、StringBuilder
         */
        //不推荐用法
        //java 虚拟机会在堆中创建三个变量，"wei" 、"xiaohuai"、 "weixiaohuai,最终newName指向"weixiaohuai"，"wei"、"xiaohuai"就没有对象引用它们，需要GC回收，耗性能
        String newNamePrefix = "wei";
        String newName = newNamePrefix + "xiaohuai";

        //推荐用法
        //java虚拟机只会在堆中开辟一个空间"wei",执行append时只会在 "wei" 的空间上 + "xiaohuai" , 避免了GC的回收，也避免了内存的浪费
        StringBuilder sb = new StringBuilder("wei");
        sb.append("xiaohuai");

        /**
         * 要点15: 尽可能多使用三目运算符，代码看起来会比较清晰
         * 说明: 对于if-else结构的，视情况优化为三目运算符
         */
        //不推荐用法
        int a = 10;
        if (a > 10) {
            System.out.println("a大于10");
        } else {
            System.out.println("a小于10");
        }

        //推荐用法
        System.out.println(a > 10 ? "a大于10" : "a小于10");

    }


}
