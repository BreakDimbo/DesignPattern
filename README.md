# DesignPattern
SSH 演绎设计模式

## 1. FilterChain

模拟了 Struts2 的拦截器实现原理：

* 将拦截器们装在一个容器里
* 拦截器都实现同一个接口
* 将拦截器的容器作为参数传递给每个拦截器的 doFilter 方法，在方法内部调用容器内的拦截器的 doFilter 方法跳出当前方法
* 递归——注意收敛条件

## 2. Hibernate_Simulate(待完善)

模拟了 Hibernate 的 ORM 实现原理：

* 写一个 Session 类，模拟 save(Student s) 方法，从配置文件读取需要被 mapping 的 bean 的信息，装到一个 Map<String, String> 里(字段名，属性)
* 难点在于：拼字符串，利用反射取得 Student 的各个属性的 get 方法的返回值类型，动态生成 ResultSet 的 setXXX()方法。

## 3. Dynamic_Proxy

模拟了 Spring 的 AOP 实现原理：

难点在于：动态代理+反射+参数的传递（InvokeHandler：规定 invoke(Obejct o, Method m)）

* 理解静态代理：接口实现+聚合
* 理解动态代理（可以生成任何对象（需要实现接口），任何方法（需要实现接口）的代理）：
  - 使用 IO 生成.java 文件——用于生成代理对象的源码
  - 使用 JavaComplier 对源码进行编译生成.class 文件
  - 使用 URLClassLoader(ClassLoader) 将.class 对象载入内存，动态生成所需对象（c.newinstance()）
* 运行脉络：InvokeHandlerImpl 里面增加需要切入的业务逻辑——>将被代理对象(target)聚合进去——>业务逻辑+m.invoke(target)+业务逻辑——>m 来自代理对象调用InvokeHandler.invoke(this, m)——>此时注意分清内外层（即字符串所写的是另一个类）


## 4. Strategy 

模拟了 JDK 的 Comparable 接口和 Comparator 接口

对接口实现和多态的深刻理解——权力下放。
