A comparison of Java interoperability in Scala and Kotlin just for educational purposes

# Features

## Good in both

- no problems implementing K/S interfaces in Java or Java interfaces in K/S
- easy to write a lambda implementing Java functional interface

## Good in Scala

- good translation to static methods when used in Java 
- sometimes you can use a lambda to create an anonymous class instance

## Bad in Scala

- calling Java varargs from Scala is sometimes impossible
- calling Scala varargs from Java is very inconvenient if Scala API does not use a special annotation
- using collections from the other language: need to Google for complicated conversions in both directions
- some very confusing syntactic magic: `foo()` can be understood as `foo(null)`
- when overriding methods, Scala `Int` is not Java `Integer`

## Good in Kotlin

- calling varargs in both directions
- using lists from Java in Kotlin: you can use Kotlin syntax sugar as with Kotlin types
- using overloaded operators on Java classes if Java methods use a convention
- null safety when using properly annotated Java classes
- null warnings in Java when calling nullable Kotlin code
- default method parameters used in Java: work great if you use a proper annotation, if you don't work as in Scala
- smart casts

## Bad in Kotlin

- immutable Kotlin collections seen as native Java collections in Java, compiler won't warn when you try to modify them (as in pure Java)

# Compilation time and result size

```
java-module 1.5s Kotlin 4s Scala 16s
0.25  0.9   7.8
0.2   1.5  14
5    15   102
```

More classes in Kotlin (it generate anonymous classes)

    ls -1 {kotlin,scala}-module/build/classes/main/example/*

Compare size with dependencies: `gradle dependenciesSize`

# Testing refactoring

- from Java: rename `MapCalculator.Result.status`
- from Kotlin: rename `KotlinUser.name()`
- from Scala: rename `ScalaUser.name()`
