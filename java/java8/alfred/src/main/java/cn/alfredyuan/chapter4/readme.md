#Introducing streams

**the Streams API in Java 8 lets you write code that’s**
1. Declarative— More concise and readable
2. Composable— Greater flexibility
3. Parallelizable— Better performance

##Stream
###what exactly is a stream?
A short definition is “a sequence of elements from a source that supports data processing operations.”

a stream is a conceptually fixed data structure (you can’t add or remove elements from it) whose elements are computed on demand. another view is that a stream is like a lazily constructed collection: values are computed when they’re solicited by a consumer

**keep in mind that you can consume a stream only once!**

##Internal Iteration
The Streams library by contrast uses internal iteration—it does the iteration for you and takes care of storing the resulting stream value somewhere; you merely provide a function saying what’s to be done.

###Intermediate operations
Intermediate operations such as filter or sorted return another stream as the return type. 

This allows the operations to be connected to form a query. What’s important is that intermediate operations don’t perform any processing until a terminal operation is invoked on the stream pipeline—they’re lazy. 

This is because intermediate operations can usually be merged and processed into a single pass by the terminal operation.

###Working with streams
To summarize, working with streams in general involves three items:
1. A data source (such as a collection) to perform a query on
2. A chain of intermediate operations that form a stream pipeline
3. A terminal operation that executes the stream pipeline and produces a result

###Summary
Here are some key concepts to take away from this chapter:
1. A stream is a sequence of elements from a source that supports data processing operations.
2. Streams make use of internal iteration: the iteration is abstracted away through operations such as filter, map, and sorted.
3. There are two types of stream operations: intermediate and terminal operations.
4. Intermediate operations such as filter and map return a stream and can be chained together. They’re used to set up a pipeline of operations but don’t produce any result.
5. Terminal operations such as forEach and count return a nonstream value and process a stream pipeline to return a result.
6. The elements of a stream are computed on demand.