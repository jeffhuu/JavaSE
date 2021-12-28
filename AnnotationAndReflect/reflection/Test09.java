package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: demo
 * @description: 通过反射，动态的创建对象
 * @author: Jack Hu 2021/12/10 17:14
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得class对象
        Class<?> c1 = Class.forName("com.jeff.reflection.User");
        //构造一个对象
//        User user = (User) c1.newInstance(); //本质是调用了类的无参构造器
//        System.out.println(user);

        //通过构造器创建对象
//        Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        User user1 = (User) constructor.newInstance("lavan", 1, 23);
//        System.out.println(user1);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        System.out.println("操作前：" + user3);
        Method getName = c1.getDeclaredMethod("getName");
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "lavan");
        System.out.println("操作后：" + user3);
        System.out.println("使用反射调用getName：" + getName.invoke(user3,null));

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        System.out.println("改变属性前：" + user4);
        Field name = c1.getDeclaredField("name");
        System.out.println("===============setAccessible 为 True，关闭程序安全检测 以访问私有属性");
        name.setAccessible(true);
        name.set(user4, "lavan2");
        System.out.println("改变属性后：" + user4);
    }
}
