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
    }
}

enum Season2 {
    // 1.提供当前枚举类的多个对象：用,隔开 ;结束
    SPRING("春天", "描述"),
    SUMMER("夏天", "描述"),
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

//    // 5.其他述求：提供toString
//    @Override
//    public String toString() {
//        return "Season2{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
