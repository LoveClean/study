package javasenior.enumeration;

/**
 * 使用enum关键字
 * 说明：继承于Java.lang.Enum类
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/14 12:23
 */
public class SeasonDemo2 {
    public static void main(String[] args) {
        Season2 summer = Season2.SUMMER;
        System.out.println(summer);

//        System.out.println(summer.getClass().getSuperclass());
        System.out.println("******************");
        // values()
        Season2[] values = Season2.values();
        for (Season2 season2 : values) {
            System.out.println(season2);
        }
        // valueOf(String name)：根据提供的ObjName，返回对应的对象
        // 如果没有ObjName的枚举类对象，则抛异常：IllegalArgumentException
        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter);

        System.out.println("******************");
        summer.show();
        winter.show();
    }
}

interface Info {
    void show();
}

enum Season2 implements Info{
    // 1.提供当前枚举类的多个对象：用,隔开 ;结束
    SPRING("春天", "描述"){
        @Override
        public void show() {
            System.out.println("春天悄悄过去");
        }
    },
    SUMMER("夏天", "描述"){
        @Override
        public void show() {
            System.out.println("夏天好热");
        }
    },
    AUTUMN("秋天", "描述"),
    WINTER("冬天", "描述");

    // 2.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 3.私有化类的构造器，并给对象属性赋值
    private Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4.其他述求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public void show() {
        System.out.println("我是默认实现");
    }

//    // 5.其他述求：提供toString
//    @Override
//    public String toString() {
//        return "Season2{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
