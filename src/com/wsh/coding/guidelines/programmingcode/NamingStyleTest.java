package com.wsh.coding.guidelines.programmingcode;

import java.util.Objects;

/**
 * @Title: NamingStyleTest
 * @ProjectName alibaba_coding_guidelines
 * @Description: 阿里巴巴编程规约 -- 命名风格
 * @Author WeiShiHuai
 * @Date 2018/10/8 11:47
 */
public class NamingStyleTest {

    public static void main(String[] args) {

        /**
         * 要点1: 变量的声明尽量不要以下划线或美元符号开始，也不要以下划线或美元符号结束
         */
        //不推荐用法
        String _name = "weixiaohuai";
        String $name = "weixiaohuai";
        String name_ = "weixiaohuai";
        String name$ = "weixiaohuai";


        //推荐用法(见名知意)
        String name = "weixiaohuai";

        /**
         * 要点2: 变量的声明尽量不要使用拼音，也不要使用中文,应该使用英文
         */
        //不推荐用法
        String xingming = "weixiaohuai";
        String 姓名 = "weixiaohuai";

        //推荐用法
        String stuName = "weixiaohuai";


        /**
         * 要点3: 类名、方法名、参数名称都必须采用驼峰命名规则(见名知意)
         */
        //不推荐用法
        String studentname = "weixiaohuai";
//        void printstudentname(String studentname) {}

        //推荐用法
        String studentName = "weixiaohuai";
//        void printStudentName(String studentName) {}

        /**
         * 要点4: 常量必须全部使用大写字母，并且多个英文之间用下划线_隔开
         */
        //不推荐用法
        final int max_num = 1024;
        final String accessKey = "test";

        //推荐用法
        final int MAX_NUM = 1024;
        final String ACCESS_KEY = "test";

        /**
         * 要点5: 声明数组的时候尽量采用String[]方式
         */
        //不推荐用法
        String arr[] = {"a", "b", "c"};

        //推荐用法
        String[] newArr = {"a", "b", "c"};

        /**
         * 要点6: 声明变量、属性的时候尽量使用通俗易懂的英文，必须随意取名字
         */
        //不推荐用法
        int a = 10;

        //推荐用法
        int num = 10;

        /**
         * 要点7: 接口中的方法、属性尽量不要加任何访问修饰符
         */


        /**
         * 要点8: 枚举类命名尽量加上Enum后缀，Enum成员名称必须使用大写字母，字母间使用下划线_分隔开
         */


        /**
         * 要点9: 各层命名规约:
         * A) Service/DAO层方法命名规约
         *      1） 获取单个对象的方法用get做前缀。   如: getUser()
         *      2） 获取多个对象的方法用list做前缀。  如: getUserList()
         *      3） 获取统计值的方法用count做前缀。  如:countUser()
         *      4） 插入的方法用save/insert做前缀。 如:saveUser()
         *      5） 删除的方法用remove/delete做前缀。 如:deleteUser()
         *      6） 修改的方法用update做前缀。  如:updateUser()
         * B) 领域模型命名规约
         *      1） 数据对象：xxxDO，xxx即为数据表名。  如:UserDO
         *      2） 数据传输对象：xxxDTO，xxx为业务领域相关的名称。  如:UserDTO
         *      3） 展示对象：xxxVO，xxx一般为网页名称。   如: userVO
         *      4） POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO.
         */


        /**
         * 要点10: 尽量不要允许任何魔法值（即未经定义的常量）直接出现在代码中
         */
        //不推荐用法
        String userId = "123456";
        String key = "KEY" + userId;

        /**
         * 要点11: long或者Long初始赋值时，使用大写的L，不能是小写的l，小写容易跟数字1混淆，造成误解。
         */
        //不推荐用法
        Long chineseScore = 100l;
        long mathScore = 90l;

        //推荐用法
        Long englishScore = 100L;
        long networkScore = 90L;

        /**
         * 要点12: 如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类。比如一些男女属性、状态值等，方便维护。
         */

        /**
         * 要点13: 避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用类名来访问即可
         */
        //不推荐用法
        Person person = new Person();
        person.printName();
        System.out.println(person.name);

        //推荐用法
        Person.printName();
        System.out.println(Person.name);

        /**
         * 要点14: 相同参数类型，相同业务含义，才可以使用Java的可变参数，避免使用Object。 说明：可变参数必须放置在参数列表的最后。
         * 可变参数相当于数组
         */
        //推荐用法
        Person.printNames(1, "zhangsan", "lisi", "wangwu");

        /**
         * 要点15: Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals。
         */
        //不推荐用法
        String personName = null;
        System.out.println(personName.equals("zhangsan"));

        //推荐用法
        System.out.println("zhangsan".equals(personName));
        System.out.println(Objects.equals("zhangsan", personName));


        /**
         * 要点16:序列化类新增属性时，请不要修改serialVersionUID字段，避免反序列失败；如果完全不兼容升级，避免反序列化混乱，那么请修改serialVersionUID值。 说明：注意serialVersionUID不一致会抛出序列化运行时异常。
         */


        /**
         * 要点17: POJO类必须写toString方法。如果继承了另一个POJO类，注意在前面加一下super.toString。
         * 说明：在方法执行抛出异常时，可以直接调用POJO的toString()方法打印其属性值，便于排查问题。
         */

        /**
         * 要点18: 循环体内，字符串的连接方式，使用StringBuilder的append方法进行扩展。
         * 说明：反编译出的字节码文件显示每次循环都会new出一个StringBuilder对象，然后进行append操作，最后通过toString方法返回String对象，造成内存资源浪费。
         */
        // 不推荐用法
        String str = "start";
        for (int i = 0; i < 100; i++) {
            str = str + "hello";
        }

        //推荐用法
        StringBuilder stringBuilder = new StringBuilder("start");
        for (int i = 0; i < 100; i++) {
            stringBuilder.append("hello");
        }

        /**
         * 要点19:
         */


    }


}
