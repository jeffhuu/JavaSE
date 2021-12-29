package com.jeff.Proxy.JDKDynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 16:41
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}
