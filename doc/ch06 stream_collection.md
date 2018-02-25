# 用流收集数据

## 本章内容
- 用 Collectors 类创建和使用收集器
- 将数据流归约为一个值
- 汇总:归约的特殊情况
- 数据分组和分区
- 开发自己的自定义收集器

指令编程
> 更难阅读，更难维护，更难修改。

##　收集器
- 将流元素归纳或汇总为一个值
- 元素分组
- 元素分区

```
public static <T> Collector<T, ?, Long> counting() {
    return reducing(0L, e -> 1L, Long::sum);
}
```

1.　创建
```
  public Supplier<List<T>> supplier() {
     return ArrayList::new;
  }

```
２．　累加
```
  public BiConsumer<List<T>, T> accumulator() {
    return List::add;
  }
```

3. 最终转换
```
  public Function<List<T>, List<T>> finisher() {
    return Function.identity();
  }
```

4. 合并
```
  public BinaryOperator<List<T>> combiner() {
    return (list1, list2) -> {
        list1.addAll(list2);
        return list1; 
      }
  }
```

5. characteristics
－ UNORDERED ——归约结果不受流中项目的遍历和累积顺序的影响。
－ CONCURRENT —— accumulator 函数可以从多个线程同时调用,且该收集器可以并行归
约流。如果收集器没有标为 UNORDERED ,那它仅在用于无序数据源时才可以并行归约。
－ IDENTITY_FINISH ——这表明完成器方法返回的函数是一个恒等函数,可以跳过。这种
情况下,累加器对象将会直接用作归约过程的最终结果。这也意味着,将累加器 A 不加检
查地转换为结果 R 是安全的

```
public Set<Characteristics> characteristics() {
  return Collections.unmodifiableSet(EnumSet.of(
  IDENTITY_FINISH, CONCURRENT));
}
```

