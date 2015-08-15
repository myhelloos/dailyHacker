###Following are the key concepts you should take away from this chapter:
1. A lambda expression can be understood as a kind of anonymous function: it doesn’t have a name, but **it has a list of parameters, a body, a return type, and also possibly a list of exceptions that can be thrown**.
2. Lambda expressions let you pass code concisely.
3. A functional interface is an interface that declares exactly one abstract method.
4. Lambda expressions can be used only where a functional interface is expected.
5. Lambda expressions let you provide the implementation of the abstract method of a functional interface directly inline and treat the whole expression as an instance of a functional interface.
6. Java 8 comes with a list of common functional interfaces in the ***java.util .function*** package, which includes Predicate<T>, Function<T, R>, Supplier<T>, Consumer<T>, and BinaryOperator<T>
7. There are primitive specializations of common generic functional interfaces such as Predicate<T> and Function<T, R> that can be used to avoid boxing operations: IntPredicate, IntToLongFunction, and so on.
8. The execute around pattern (that is, you need to execute a bit of behavior in the middle of code that’s always required in a method, for example, resource allocation and cleanup) can be used with lambdas to gain additional flexibility and reusability.
9. The type expected for a lambda expression is called the target type.
10. Method references let you reuse an existing method implementation and pass it around directly.
11. Functional interfaces such as Comparator, Predicate, and Function have several default methods that can be used to combine lambda expressions.