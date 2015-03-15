package com.donc;

/**
 * Created by donovan on 15/02/20.
 */
public interface HelloMBean {

    public void sayHello();
    public int add(int x, int y);
    public String getName();
    public int getCacheSize();
    public void setCacheSize(int size);

}
