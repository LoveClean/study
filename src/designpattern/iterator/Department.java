package designpattern.iterator;

/**
 * 系
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/6 18:38
 */
public class Department {
    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
