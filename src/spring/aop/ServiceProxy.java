package aop;

import java.lang.reflect.Proxy;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE aop
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/20
 *******************************************************************************************************/
public class ServiceProxy {
    public static Object getProxy(Class<?> clazz, Object target) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{clazz}, (proxy, method, args) -> {
            Object invoke = method.invoke(target, args);
            System.out.println("after method:" + method.getName());
            return invoke;
        });
    }
}
