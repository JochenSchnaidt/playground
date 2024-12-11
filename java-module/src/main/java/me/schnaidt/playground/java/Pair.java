package me.schnaidt.playground.java;

/**
 * A tuple of things.
 *
 * @param first
 * @param second
 * @param <S> type of first
 * @param <T> type of second
 */
public record Pair<S,T>(S first, T second) {
}
