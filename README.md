A comparison of Java interoperability in Scala and Kotlin just for educational purposes

Some results
------------

```
java-module 1.5s Kotlin 4s Scala 16s
0.25  0.9   7.8
0.2   1.5  14
5    15   102
```

More classes in Kotlin (it generate anonymous classes)

    ls -1 {kotlin,scala}-module/build/classes/main/example/*

Compare size with dependencies: `gradle dependenciesSize`

Refactoring
-----------

- from Java: rename `MapCalculator.Result.status`
- from Kotlin: rename `KotlinUser.name()`
- from Scala: rename `ScalaUser.name()`
