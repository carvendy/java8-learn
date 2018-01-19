## 第一章 为什么要关心Java 8
1. 流处理（类似于linux）==>并行+多核处理
2. 用行为参数化把代码传递给方法（Comparator的累赘实现）
3. 并行与共享可变数据（）

编程的目的在与操作值。==>Scala和Groovy证明了Lambda，有利于编程。


```
File[] files = new File(".").listFiles(File::isHidden);//匿名函数=>简洁
```

```
 List<Apple> apples = filterApples(list, (Apple a) -> "red".equals(a.getColor()));
  System.out.println(apples);
```

流（用于数据的计算）
- 遍历问题（简单）
- 多线程问题（使用了多核）