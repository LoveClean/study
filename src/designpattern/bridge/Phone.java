package designpattern.bridge;

/**
 * 相当于桥
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/5 1:16
 */
public abstract class Phone {
    // 组合品牌
    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Phone(Brand brand) {
        this.brand = brand;
    }

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }
}
