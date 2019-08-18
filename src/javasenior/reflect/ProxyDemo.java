package javasenior.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/18 13:19
 */
public class ProxyDemo {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // proxyInstance：代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        proxyInstance.getBelief();
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*********************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}

class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        Class<?> objClass = obj.getClass();
        Object instance = Proxy.newProxyInstance(objClass.getClassLoader(), objClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理开始。。。");

                // method：即为代理类对象调用的方法，调用方法时，就会自动的调用如下方法
                Object invoke = method.invoke(obj, args);

                System.out.println("动态代理结束。。。");
                return invoke;
            }
        });
        return instance;
    }
}

interface Human {
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {
    @Override
    public String getBelief() {
        System.out.println("I believe i can fly!");
        return "I believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}