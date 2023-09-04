package aop;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE aop
 * @DESCRIPTION TODO
 * @AUTHOR jianglu
 * @DATE 2022/11/20
 *******************************************************************************************************/
public class ProxyServiceImpl implements ProxyService {
    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void drink() {
        System.out.println("drink");
    }

    @Override
    public void play() {
        this.eat();
        System.out.println("play");
    }
}
