#Chapter 5: Working with streams
## summary
It’s been a long but rewarding chapter! You can now process collections more effectively. Indeed, streams let you express sophisticated data processing queries concisely. In addition, streams can be parallelized transparently. Here are some key concepts to take away from this chapter:

1. The Streams API lets you express complex data processing queries. Common stream operations are summarized in table 5.1.

Table 5.1. Intermediate and terminal operations
|Operation|Type|Return type|Type/functional interface used|Function descriptor|
|-------|-------|-------|-------|-------|-------|
|filter|Intermediate|Stream<T>|Predicate<T>|T -> boolean|
|distinct|Intermediate (stateful-unbounded)|Stream<T>| | |
|skip|Intermediate (stateful-bounded)|Stream<T>|long| |
|limit|Intermediate (stateful-bounded)|Stream<T>|long| |
|map|Intermediate|Stream<R>|Function<T, R>|T -> R|
|flatMap|Intermediate|Stream<R>|Function<T, Stream<R>>|T -> Stream<R>|
|sorted|Intermediate (stateful-unbounded)|Stream<T>|Comparator<T>|(T, T) -> int|
|anyMatch|Terminal|boolean|Predicate<T>|T -> boolean|
|noneMatch|Terminal|boolean|Predicate<T>|T -> boolean|
|allMatch|Terminal|boolean|Predicate<T>|T -> boolean|
|findAny|Terminal|Optional<T>| | |
|findFirst|Terminal|Optional<T>| | |
|forEach|Terminal|void|Consumer<T>|T -> void|
|collect|terminal|R|Collector<T, A, R>| |
|reduce|Terminal (stateful-bounded)|Optional<T>|BinaryOperator<T>|(T, T) -> T|
|count|Terminal|long| | |

2. You can filter and slice a stream using the filter, distinct, skip, and limit methods.
3. You can extract or transform elements of a stream using the map and flatMap methods.
4. You can find elements in a stream using the findFirst and findAny methods. You can match a given predicate in a stream using the allMatch, noneMatch, and anyMatch methods.
5. These methods make use of short-circuiting: a computation stops as soon as a result is found; there’s no need to process the whole stream.
6. You can combine all elements of a stream iteratively to produce a result using the reduce method, for example, to calculate the sum or find the maximum of a stream.
7. Some operations such as filter and map are stateless; they don’t store any state. Some operations such as reduce store state to calculate a value. Some operations such as sorted and distinct also store state because they need to buffer all the elements of a stream before returning a new stream. Such operations are called stateful operations.
8. There are three primitive specializations of streams: IntStream, DoubleStream, and LongStream. Their operations are also specialized accordingly.
9. Streams can be created not only from a collection but also from values, arrays, files, and specific methods such as iterate and generate.
10. An infinite stream is a stream that has no fixed size.