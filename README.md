# DesignPattern
SSH 演绎设计模式

## 1. FilterChain

模拟了 Struts2 的拦截器实现原理：

* 将拦截器们装在一个容器里
* 拦截器都实现同一个接口
* 将拦截器的容器作为参数传递给每个拦截器的 doFilter 方法，在方法内部调用容器内的拦截器的 doFilter 方法跳出当前方法
* 递归——注意收敛条件

## 2. Hibernate_Simulate(待完善)
