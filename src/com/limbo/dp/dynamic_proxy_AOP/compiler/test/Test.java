package com.limbo.dp.dynamic_proxy_AOP.compiler.test;

import com.limbo.dp.dynamic_proxy_AOP.Movable;
import com.limbo.dp.dynamic_proxy_AOP.Tank;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Break.D on 7/20/16.
 */
public class Test {
    public static void main(String[] args) throws Exception {

        String str =
                "package com.limbo.dp.dynamic_proxy_AOP;" +
                        "public class TankTimeProxy implements Movable {" +
                        "private Movable t;" +

                        "public TankTimeProxy(Movable t) {" +
                        "this.t = t;" +
                        "}" +

                        "@Override " +
                        "public void move() {" +
                        "long t1 = System.currentTimeMillis();" +
                        "t.move();" +
                        "long t2 = System.currentTimeMillis();" +
                        "System.out.println(\"Tank moved \" + (t2 - t1) + \" seconds\");" +
                        "}" +
                        "}";
        //写出 java 文件
        String filename = System.getProperty("user.dir") + "/src/com/limbo/dp/dynamic_proxy_AOP/TankTimeProxy.java";
//System.out.println(filename);
        File f = new File(filename);
        FileWriter writer = new FileWriter(f);
        writer.write(str);
        writer.flush();
        writer.close();

        //编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable files = fileManager.getJavaFileObjects(filename);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
        task.call();
        fileManager.close();

        //load into memory and create an instance

        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.limbo.dp.dynamic_proxy_AOP.TankTimeProxy");
//System.out.println(c);

        Constructor con = c.getConstructor(Movable.class);
        Movable m = (Movable) con.newInstance(new Tank());
        m.move();
    }
}
