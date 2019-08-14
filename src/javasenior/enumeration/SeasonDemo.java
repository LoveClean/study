package javasenior.enumeration;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/14 12:11
 */
public class SeasonDemo {
    public static void main(String[] args) {
        System.out.println(Season.SPRING.getSeasonName());
        System.out.println(Season.AUTUMN);
    }
}

class Season {
    // 1.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 2.私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供当前枚举类的多个对象：public static final的
    public static final Season SPRING = new Season("春天", "描述");
    public static final Season SUMMER = new Season("夏天", "描述");
    public static final Season AUTUMN = new Season("秋天", "描述");
    public static final Season WINTER = new Season("冬天", "描述");

    // 4.其他述求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 5.其他述求：提供toString
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}