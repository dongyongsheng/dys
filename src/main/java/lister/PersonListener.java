package lister;

/**
 * 事件监听器
 *
 * 监听Person事件源的eat和sleep方法
 */
interface PersonListener{

    void doEat(Event event);
    void doSleep(Event event);
}
