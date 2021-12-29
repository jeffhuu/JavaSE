package com.jeff.Proxy.CGLIBProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @program: JavaSE
 * @description:
 * @author: Jack Hu 2021/12/29 17:16
 */
public class CglibProxyFactory {
    public static Object getProxy(Object target) {
        Class<?> clazz = target.getClass();
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
