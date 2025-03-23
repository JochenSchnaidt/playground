package me.schnaidt.playground.java.amber.pattern;

import me.schnaidt.playground.java.Pair;

public class PatternMatching {

  /**
   * Statement -> no return value
   * Works with primitives (except long), wrapper, enums and String.
   * switch labels of same type as selector
   * Fall through, default not required
   */
  void legacy_switch_implementation(int i) {

    switch (i) {
      case 2:
      case 4:
        System.out.println("two or four");
        break;
      case 5:
        System.out.println("five");
        break;
      case 8:
        System.out.println("eight");
        break;
      default:
        System.out.println("Something else");
        break;
    }
  }

  /// Java 14 Switch Expressions<br>
  /// [JEP 361: Switch Expressions](https://openjdk.org/jeps/361)<br>
  /// [Java Almanac](https://javaalmanac.io/features/switch/)<br>
  /// <br>
  /// Handling
  /// - Expression -> return value
  /// - works with primitives (except long), wrapper, enums and String.
  /// - switch labels of same type as selector
  /// - no more fall through, comma separated list, default required
  String java_14_switch_expressions(int i) {

    return switch (i) {
      case 2, 4 -> "two or four";
      case 5 -> "five";
      case 8 -> {
        System.out.println("\tblocks are allowed here");
        yield "eight";
      }
      default -> "Something else";
    };
  }

  /**
   * matching on class, explicit cast necessary
   * further processing afterward -> more complexity
   */
  void legacy_instanceof_implementation(Object o) {

    if (o instanceof String) {
      String s = (String) o;
      if (s.length() > 10) {
        System.out.println("long string: " + s);
      } else {
        System.out.println("short string: " + s);
      }
    } else if (o instanceof Integer) {
      Integer i = (Integer) o;
      if (i > 100) {
        System.out.println("integer above 100: " + i);
      } else {
        System.out.println("integer below 100: " + i);
      }
    } else {
      System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /// Java 16 Pattern Matching for instanceof<br>
  /// [JEP 394: Pattern Matching for instanceof](https://openjdk.org/jeps/394)<br>
  /// [Java Almanac](https://javaalmanac.io/features/instanceof-patterns/)<br>
  /// <br>
  /// Handling
  /// - match on class includes pattern variable which can directly be used
  /// - less complexity
  /// - order matters
  /// - variable scopes exits
  void java_16_pattern_matching_for_instanceof(Object o) {

    if (o instanceof String s && s.length() > 10) {
      System.out.println("long string: " + s);
    } else if (o instanceof String s) {
      System.out.println("short string: " + s);

    } else if (o instanceof Integer i && i > 100) {
      System.out.println("integer above 100: " + i);
    } else if (o instanceof Integer i) {
      System.out.println("integer below 100: " + i);

    } else if (o instanceof Pair(Double d1, Double d2)) {
      System.out.println("pair of doubles: " + d1 + ", " + d2);
    } else if (o instanceof Pair(String s, Double d2)) {
      System.out.println("pair for key/value: " + s + ", " + d2);
    } else if (o instanceof Pair(var v1, var v2)) {
      System.out.println("pair for anything else: " + v1 + ", " + v2);

    } else {
      System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /*
   * Java 17
   * Sealed Classes
   * Pattern Matching for switch - 1. Preview
   */

  /*
   * Java 18
   * Pattern Matching for switch - 2. Preview
   */

  /*
   * Java 19
   * Record Patterns - 1. Preview
   * Pattern Matching for switch - 3. Preview
   */

  /*
   * Java 20
   * Record Patterns - 2. Preview
   * Pattern Matching for switch - 4. Preview
   */

  /*
   * Java 21
   * Unnamed Patterns and Variables - 1. Preview
   */

  /// Java 21 Pattern Matching for switch<br>
  /// [JEP 441: JEP 441: Pattern Matching for switch](https://openjdk.org/jeps/441)<br>
  /// [Java Almanac](https://javaalmanac.io/features/typepatterns/)<br>
  /// <br>
  /// Handling
  /// - pattern variables must be present - differs from instanceof
  /// - default case must be present
  /// - default case dominates null case
  /// - default does not include null
  /// - null case to handle o == null, no NPE on switch (o)
  /// - null case missing -> NPE backward compatibility
  void java_21_pattern_matching_for_switch(Object o) {

    switch (o) {
      case String s -> {
        if (s.length() > 10) {
          System.out.println("long string: " + s);
        } else {
          System.out.println("short string: " + s);
        }
      }
      case Integer i -> {
        if (i > 100) {
          System.out.println("integer above 100: " + i);
        } else {
          System.out.println("integer below 100: " + i);
        }
      }
      case null -> System.out.println("we prevented a NPE");
      default -> System.out.println("¯\\_(ツ)_/¯");
    }
  }

  void java_21_pattern_matching_for_instanceof(Object o) {
    // TODO jschnaidt
  }

  /**
   * when reserved word in this context only
   * all validations on left side of arrow
   * all statements on the right side of arrow
   * guard: "s.length() > 10"
   * guarded pattern: String s when s.length() > 10
   * guarded pattern case label: case String s when s.length() > 10
   * order matters
   */
  void java_21_guarded_pattern_matching_for_switch(Object o) {

    switch (o) {
      case String s when s.length() > 10 -> System.out.println("long string: " + s);
      case String s -> System.out.println("short string: " + s);
      case Integer i when i > 100 -> System.out.println("integer above 100: " + i);
      case Integer i -> System.out.println("integer below 100: " + i);
      case null, default -> System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /**
   * Expression -> return value
   * when reserved word in this context only
   * all validations on left side of arrow
   * all statements on the right side of arrow
   * guard: "s.length() > 10"
   * guarded pattern: String s when s.length() > 10
   * guarded pattern case label: case String s when s.length() > 10
   * order matters
   */
  String java_21_guarded_pattern_matching_for_switch_expression(Object o) {

    return switch (o) {
      case String s when s.length() > 10 -> "long string: " + s;
      case String s -> "short string: " + s;
      case Integer i when i > 100 -> "integer above 100: " + i;
      case Integer i -> "integer below 100: " + i;
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }

  /**
   * pattern variable must not have the same name as an already defined variable in the scope.
   * leads to "Variable 's' is already defined in the scope"
   * equally named class variable is fine although
   */
  String s = "class level defined variable for long strings";

  String java_21_pattern_variable_shadowing(Object o) {

    // not allowed: String s = "Gone with the wind";
    return switch (o) {
      case String s when s.length() > 10 -> this.s;
      case String s -> "short string: " + s;
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }

  /**
   * pattern variable are mutable and their value can be changed
   */
  String java_21_pattern_variable_mutability(Object o) {
    return switch (o) {
      case String s -> s = "something different";
      case null, default -> s = "¯\\_(ツ)_/¯";
    };
  }

  /// Java 22 Unnamed Variables & Patterns<br>
  /// [JEP 456: Unnamed Variables & Patterns](https://openjdk.org/jeps/456)<br>
  /// <br>
  /// Handling
  /// - pattern variables not needed in statement group
  void java_22_unnamed_pattern_matching_for_switch(Object o) {

    switch (o) {
      case String _ -> System.out.println("it's a string");
      case Integer _ -> System.out.println("it's a integer");
      case null -> System.out.println("we prevented a NPE");
      default -> System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /// Java 23 Primitive Types in Patterns, instanceof, and switch<br>
  /// [JEP 455: Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455)<br>
  /// <br>
  /// Handling
  void java_23_primitive_types_in_pattern_for_switch(Object o) {
    // TODO jschnaidt
  }

  /// Java 23 Primitive Types in Patterns, instanceof, and switch<br>
  /// [JEP 455: Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455)<br>
  /// <br>
  /// Handling
  void java_23_primitive_types_in_pattern_for_instanceof(Object o) {
    // TODO jschnaidt
  }

  /*
   * Upcoming Java 24
   * Primitive Types in Patterns, instanceof, and switch - 2. Preview (JEP 488)
   */

}
