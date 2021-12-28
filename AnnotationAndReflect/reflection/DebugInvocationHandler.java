package reflection;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/28 17:00
 */
public class DebugInvocationHandler implements InvocationHandler {

    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object result = method.invoke(proxy, args);
        System.out.println("after method " + method.getName());
        return result;
    }

    public static void main(String[] args) throws Throwable {
        User user = new User("Jeff", 18, 18);
        DebugInvocationHandler debugInvocationHandler = new DebugInvocationHandler(user);
        Class<? extends User> userClass = user.getClass();
        Method said = userClass.getMethod("said");
        debugInvocationHandler.invoke(user, said, null);

        Method playGames = userClass.getMethod("playGames", String.class);
        Object[] objects = new Object[] {"《英雄联盟》"};
        debugInvocationHandler.invoke(user, playGames, objects);
    }
}
