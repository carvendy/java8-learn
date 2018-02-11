# 第三章 Lambda 表达式
- Lambda管中窥豹
- 在哪里以及如何使用Lambda
- 环绕执行模式
- 函数式接口,类型推断
- 方法引用
- Lambda复合

## 3.1 Lambda管中窥豹
> 含义:λ演算法  
函数、匿名、传递、简洁

**结构**
(Class a,Class b) -> {}

**测验3.1:Lambda语法**   
根据上述语法规则,以下哪个不是有效的Lambda表达式?  
1. () -> {}
2. () -> "Raoul"
3. () -> {return "Mario";}
4. (Integer i) -> return "Alan" + i; （x）
5. (String s) -> {"IronMan";} (x)

**函数式接口（使用）**
```
@FunctionalInterface 
public interface Predicate<T> {
    boolean test(T var1);
}
```

## 3.3 把Lamdba付诸实践：环绕执行模式
FunctionTest
**任何函数式接口都不允许抛出受检异常**

类型多，可读性好。

## 3.5 类型检查、推断以及限制
1. 检查
> 过程分解，上下文检查  。  

**特殊的void兼容规则**
> 如果一个Lambda的主体是一个语句表达式, 它就和一个返回 void 的函数描述符兼容(当
  然需要参数列表也兼容)。例如,以下两行都是合法的,尽管 List 的 add 方法返回了一个
  boolean ,而不是 Consumer 上下文( T -> void )所要求的 void :
  
**闭包，closure**

## 3.6 方法引用
```
File[] files = new File(".").listFiles(File::isHidden);
```

**表3-4 Lambda及其等效方法引用的例子**

Lambda | 等效的方法引用  |
---|---
(Apple a) -> a.getWeight() | Apple::getWeight
() -> Thread.currentThread().dumpStack() | Thread.currentThread()::dumpStack
(str, i) -> str.substring(i) | String::substring
(String s) -> System.out.println(s) | System.out::println

## 3.7 Lambda 和方法引用实战
1. 复合 Lambda 表达式的有用方法
2. 比较器复合


## 3.10 小结
以下是你应从本章中学到的关键概念。  
- Lambda 表达式可以理解为一种匿名函数:它没有名称,但有参数列表、函数主体、返回
类型,可能还有一个可以抛出的异常的列表。
- Lambda 表达式让你可以简洁地传递代码。  
- 函数式接口就是仅仅声明了一个抽象方法的接口。
- 只有在接受函数式接口的地方才可以使用 Lambda 表达式。
- Lambda 表达式允许你直接内联,为函数式接口的抽象方法提供实现,并且将整个表达式
作为函数式接口的一个实例。
- Java 8 自带一些常用的函数式接口,放在 java.util.function 包里,包括 Predicate
<T> 、 Function<T,R> 、 Supplier<T> 、 Consumer<T> 和 BinaryOperator<T> ,如表
3-2 所述。
- 为了避免装箱操作,对 Predicate<T> 和 Function<T, R> 等通用函数式接口的原始类型
特化: IntPredicate 、 IntToLongFunction 等。3.10 小结
65
- 环绕执行模式(即在方法所必需的代码中间,你需要执行点儿什么操作,比如资源分配
和清理)可以配合 Lambda 提高灵活性和可重用性。
- Lambda 表达式所需要代表的类型称为目标类型。
- 方法引用让你重复使用现有的方法实现并直接传递它们。
- Comparator 、 Predicate 和 Function 等函数式接口都有几个可以用来结合 Lambda 表达
式的默认方法。



