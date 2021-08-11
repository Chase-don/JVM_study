public class LazyMan {
    private LazyMan() {

    }

    private volatile static LazyMan lazyMan;

    //双重检测锁的懒汉模式
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}
