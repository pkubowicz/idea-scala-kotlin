A comparison of Java interoperability in Scala and Kotlin just for educational purposes

# Quickstart

Run with `./gradlew build`. Start reading from `Runner.java`.

# Features

## Good in both

- no problems implementing K/S interfaces in Java or Java interfaces in K/S
- easy to write a lambda implementing Java functional interface

## Good in Scala

- good translation to static methods when used in Java
- can use named parameters on Java code compiled with `-parameters`
- sometimes you can use a lambda to create an anonymous class instance

## Bad in Scala

- calling Java varargs from Scala is sometimes impossible
- calling Scala varargs from Java is very inconvenient if Scala API does not use a special annotation
- using collections from the other language: need to Google for [complicated conversions](http://stackoverflow.com/questions/17737631/convert-from-scala-collection-seqstring-to-java-util-liststring-in-java-code) in both directions
- when overriding methods, Scala `Int` is not Java `Integer`; same for `Long`
- some very confusing syntactic magic: `foo()` can be understood as `foo(null)`
- cannot use function instances as Java functional interfaces (but inline functions are fine) - see `ScalaLambdas.passLambdasToJava`

## Good in Kotlin

- calling varargs in both directions
- using lists from Java in Kotlin: you can use Kotlin syntax sugar as with Kotlin types
- using overloaded operators on Java classes if Java methods use a convention
- null safety when using properly annotated Java classes
- null warnings in Java when calling nullable Kotlin code
- default method parameters used in Java: work great if you use a proper annotation, if you don't use - work as in Scala
- POJO-compatible data classes
- smart casts
- can use function instances as Java functional interfaces - see `KotlinLambdas.passLambdasToJava`

## Bad in Kotlin

- default methods in Kotlin interfaces need to be implemented in Java
- immutable Kotlin collections seen as native Java collections in Java, compiler won't warn when you try to modify them (as in pure Java)
- wrong name of getter for boolean fields (does not conform to JavaBean spec)

## Bad in both

- when implementing lambdas returning Unit ('void') in Java you need to return null
- cannot use Java functional interface instances as K/S functions (but inline lambdas are fine) - see `Lambdas.passLambdasFromJava`

# Compilation time and result size

```
java-module 1.5s Kotlin 4s Scala 16s
0.25  0.9   7.8
0.2   1.5  14
5    15   102
```

More classes in Kotlin (it generate anonymous classes). Compare size with dependencies: `gradle dependenciesSize`

# Testing refactoring

- from Java: rename `MapCalculator.Result.status`
- from Kotlin: rename `KotlinButton.caption()`
- from Scala: rename `ScalaButton.caption()`
