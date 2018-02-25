# 函数式的思考
本章内容
- 为什么要进行函数式编程
- 什么是函数式编程
- 声明式编程以及引用透明性
- 编写函数式Java的准则
- 迭代和递归

**声明式编程**
> 陈述语句

担心-->副作用
1. 赋值操作
2. 抛异常
3. 文件输入\输出

``` 
static List<List<Integer>> concat(List<List<Integer>> a,
  List<List<Integer>> b) {
  a.addAll(b);
  return a;
}

不过,我们真正建议你采用的是下面这种方式:
static List<List<Integer>> concat(List<List<Integer>> a,
  List<List<Integer>> b) {
  List<List<Integer>> r = new ArrayList<>(a);
  r.addAll(b);
  return r;
}
```

1. 递归的效率低
2. "尾-递",效率会高一些.(坏消息是,目前Java还不支持这种优化)

## 小结
- 从长远看,减少共享的可变数据结构能帮助你降低维护和调试程序的代价。
- 函数式编程支持无副作用的方法和声明式编程。
- 函数式方法可以由它的输入参数及输出结果进行判断。
- 如果一个函数使用相同的参数值调用,总是返回相同的结果,那么它是引用透明的。采
用递归可以取得迭代式的结构,比如 while 循环。
- 相对于Java语言中传统的递归,
“尾递”可能是一种更好的方式,它开启了一扇门,让我
们有机会最终使用编译器进行优化。