package designpattern.abstractfactory.order;

import designpattern.abstractfactory.pizza.BasePizza;
import designpattern.abstractfactory.pizza.CheesePizza;
import designpattern.abstractfactory.pizza.GreekPizza;
import designpattern.abstractfactory.pizza.PepperPizza;

/**
 * 这是工厂子类
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/4 0:15
 */
public class LdFactory implements AbstractFactory {
    @Override
    public BasePizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        BasePizza pizza = null;
        switch (orderType) {
            case "greek":
                pizza = new GreekPizza();
                break;
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
