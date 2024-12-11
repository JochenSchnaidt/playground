package me.schnaidt.playground.java.amber.pattern;

import me.schnaidt.playground.java.Pair;
import org.junit.jupiter.api.Test;

class PatternMatchingTest {

 private final PatternMatching impl = new PatternMatching();

  @Test
  void legacy_switch_implementation_test() {

    impl.legacy_switch_implementation(2);
    impl.legacy_switch_implementation(Integer.valueOf(5));
    Integer foo = null;
    impl.legacy_switch_implementation(foo);
  }

  @Test
  void java_14_switch_expressions_test() {

    String result;
    result = impl.java_14_switch_expressions(2);
    System.out.println(result);
    result = impl.java_14_switch_expressions(Integer.valueOf(8));
    System.out.println(result);
    Integer foo = null;
    result = impl.java_14_switch_expressions(foo);
    System.out.println(result);
  }

  @Test
  void legacy_instanceof_implementation_test() {

    impl.legacy_instanceof_implementation("This is a long string");
    impl.legacy_instanceof_implementation("foo");

    impl.legacy_instanceof_implementation(42);
    impl.legacy_instanceof_implementation(512);

    short s = 5;
    impl.legacy_instanceof_implementation(s);
    impl.legacy_instanceof_implementation(null);
  }

  @Test
  void java_16_pattern_matching_for_instanceof_test() {

    impl.java_16_pattern_matching_for_instanceof("This is a long string");
    impl.java_16_pattern_matching_for_instanceof("foo");

    impl.java_16_pattern_matching_for_instanceof(42);
    impl.java_16_pattern_matching_for_instanceof(512);

    impl.java_16_pattern_matching_for_instanceof(new Pair<>(0.4, 0.5));
    impl.java_16_pattern_matching_for_instanceof(new Pair<>("ghj", 0.5));
    impl.java_16_pattern_matching_for_instanceof(new Pair<>(Boolean.TRUE, 0.5F));


    short s = 5;
    impl.java_16_pattern_matching_for_instanceof(s);
    impl.java_16_pattern_matching_for_instanceof(null);
  }

  @Test
  void java_21_pattern_matching_for_switch_test() {

    impl.java_21_pattern_matching_for_switch("This is a long string");
    impl.java_21_pattern_matching_for_switch("foo");

    impl.java_21_pattern_matching_for_switch(42);
    impl.java_21_pattern_matching_for_switch(512);

    short s = 5;
    impl.java_21_pattern_matching_for_switch(s);
    impl.java_21_pattern_matching_for_switch(null);
  }



  @Test
  void java_21_guarded_pattern_matching_for_switch_test() {

    impl.java_21_guarded_pattern_matching_for_switch("This is a long string");
    impl.java_21_guarded_pattern_matching_for_switch("foo");

    impl.java_21_guarded_pattern_matching_for_switch(42);
    impl.java_21_guarded_pattern_matching_for_switch(512);

    short s = 5;
    impl.java_21_guarded_pattern_matching_for_switch(s);
    impl.java_21_guarded_pattern_matching_for_switch(null);
  }

  @Test
  void java_21_guarded_pattern_matching_for_switch_expression_test() {

    String s;

    s = impl.java_21_guarded_pattern_matching_for_switch_expression("This is a long string");
    System.out.println(s);
    s = impl.java_21_guarded_pattern_matching_for_switch_expression("foo");
    System.out.println(s);

    s = impl.java_21_guarded_pattern_matching_for_switch_expression(42);
    System.out.println(s);
    s = impl.java_21_guarded_pattern_matching_for_switch_expression(512);
    System.out.println(s);

    short sh = 5;
    s = impl.java_21_guarded_pattern_matching_for_switch_expression(sh);
    System.out.println(s);
    s = impl.java_21_guarded_pattern_matching_for_switch_expression(null);
    System.out.println(s);
  }


  @Test
  void java_21_pattern_variable_shadowing_test() {

    String s = impl.java_21_pattern_variable_shadowing("This is a long string");
    System.out.println(s);

    s = impl.java_21_pattern_variable_shadowing("foo");
    System.out.println(s);
  }

  @Test
  void java_21_pattern_variable_mutability_test() {
    String s = impl.java_21_pattern_variable_mutability("This is a long string");
    System.out.println(s);

    s = impl.java_21_pattern_variable_mutability(null);
    System.out.println(s);
  }


  @Test
  void java_22_unnamed_pattern_matching_for_switch_test() {

    impl.java_22_unnamed_pattern_matching_for_switch("This is a long string");
    impl.java_22_unnamed_pattern_matching_for_switch(512);

    short s = 5;
    impl.java_22_unnamed_pattern_matching_for_switch(s);
    impl.java_22_unnamed_pattern_matching_for_switch(null);
  }


}