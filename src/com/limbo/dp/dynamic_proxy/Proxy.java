package com.limbo.dp.dynamic_proxy;

import com.limbo.dp.dynamic_proxy.invokeHandler.InvokeHandler;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Break.D on 7/20/16.
 */
public class Proxy {

    public static Object getProxyInstance(Class interf, InvokeHandler h) throws Exception {

        String methodStr = "";

        Method[] methods = interf.getMethods();
        for (Method m : methods) {
            methodStr += "@Override " +
                    "public void " + m.getName() + "() {" +
                    "try { " +
                    "Method md = " + interf.getName() + ".class.getMethod(\"" + m.getName() + "\");" +
                    "h.invoke(this, md);" +
                    "} catch(NoSuchMethodException e) {" +
                    " e.printStackTrace();" +
                    "}" +
            "}";
        }

        String str =
                "package com.limbo.dp.dynamic_proxy;" +
                        "import java.lang.reflect.Method;" +
                        "import java.lang.Exception;" +
                        "public class $Proxy1 implements " + interf.getName() + "{" +
                        "private " + h.getClass().getName() + " h;" +
                        "public $Proxy1(" + h.getClass().getName() + " h) {" +
                        "this.h = h;" +
                        "}" +

                        methodStr
                        +
                        "}";


        //生成 java 文件
        String filename = System.getProperty("user.dir") + "/src/com/limbo/dp/dynamic_proxy/$Proxy1.java";
//System.out.println(filename);
        File f = new File(filename);
        FileWriter writer = new FileWriter(f);
        writer.write(str);
        writer.flush();
        writer.close();

        //编译生成 class 文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> files = fileManager.getJavaFileObjects(filename);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, files);
        task.call();
        fileManager.close();

        //load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("com.limbo.dp.dynamic_proxy.$Proxy1");
//System.out.println(c);

        Constructor con = c.getConstructor(h.getClass());
        Object o = con.newInstance(h);
        return o;

    }

}
