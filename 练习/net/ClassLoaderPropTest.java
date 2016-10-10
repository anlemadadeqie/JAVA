package net;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by hjh on 16-8-11.
 */
/*访问JVM的类加载器*/

public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException {
        //获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器:"+systemLoader);
        /*获取系统类加载器的加载路径-通常由CLASSPATH环境变量指定，
        如果操作系统没有指定CLASSPATH环境变量，则默认以当前的路径
        作为系统类加载器的加载路径 */
        Enumeration<URL> eml = systemLoader.getResources("");
        while(eml.hasMoreElements()){
            System.out.println(eml.nextElement());
        }
        //获取系统类加载器的父类加载器，得到扩展类加载器
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println(extensionLader);
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(extensionLader.getParent());
    }
}
