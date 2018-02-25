# 并行流

## 本章内容
- 用并行流并行处理数据
- 并行流的性能分析
- 分支/合并框架
- 使用 Spliterator 分割流

**否有必要使用并行流**
- 不清楚的，请自行测试．
- 注意装箱
- 可能有性能问题
- 考虑流水线操作的计算成本
- 数据量少选择流，并不是好选择
- 要考虑背后的数据结构是否容易拆解
- 分解，性能问题
- 合并，性能问题

## 分支/合并框架
```
public class ForkJoinSumCalculator
  extends java.util.concurrent.RecursiveTask<Long> {}

public static long forkJoinSum(long n) {
  long[] numbers = LongStream.rangeClosed(1, n).toArray();
  ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
  return new ForkJoinPool().invoke(task);
}
```
### 使用分支/合并框架的最佳做法
- join会线程阻塞，直到任务出结果
- 不应该在 RecursiveTask 内部使用 ForkJoinPool 的 invoke 方法
- 对子任务调用 fork 方法可以把它排进 ForkJoinPool
- 调试使用分支/合并框架的并行计算可能有点棘手
- 可能有性能问题．

**工作窃取**
> 任务差不多被平均分配到 ForkJoinPool 中的所有线程上.

## Spliterator?　
