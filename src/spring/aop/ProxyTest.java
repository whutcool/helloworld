package aop;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE aop
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/20
 *******************************************************************************************************/
public class ProxyTest {
    public static void main(String[] args) {
        ProxyService proxyService = (ProxyService) ServiceProxy.getProxy(ProxyService.class, new ProxyServiceImpl());
        proxyService.play();
    }
}
