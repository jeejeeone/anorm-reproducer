Reproduce warning for Macro.namedParser when using an enum with Scala 3.3.1

- sbt compile

```
[warn] -- [E121] Pattern Match Warning: /Users/jj/code/anorm-poc/src/main/scala/Main.scala:23:41
[warn] 23 |  val rowParser = anorm.Macro.namedParser[AnormRow]
[warn]    |                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
[warn]    |Unreachable case except for null (if this is intentional, consider writing case null => instead).
[warn] one warning found
[success] Total time: 4 s, completed 21 Mar 2024, 9.50.32
```

Curiously the next compilation succeeds without warnings. For example this will produce two cases for warning

- sbt compile (produces warning)
- sbt compile (does not produce the warning)
- sbt clean
- sbt compile (produces warning)
