# common-assertions

A simple assertion class inspired by 
[Spring's `Assert` class](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/Assert.html),
[Guavas Preconditions](https://github.com/google/guava/wiki/PreconditionsExplained)
and [Apache Commons `Validate` class](https://commons.apache.org/proper/commons-lang/javadocs/api-3.6/org/apache/commons/lang3/Validate.html).

Usage:
```
Assert.notNull(field);
Assert.notNull(field, "field");
Assert.notEmpty(myString);
Assert.notEmpty(myString, "myString");
Assert.isTrue(myBooleanValue);
Assert.state(list.size() == 42, "List with 42 items required")
```