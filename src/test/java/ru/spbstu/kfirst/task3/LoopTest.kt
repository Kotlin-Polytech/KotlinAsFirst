package ru.spbstu.kfirst.task3

import org.junit.Test

import org.junit.Assert.*

class LoopTest {
    @Test
    fun fib() {
        assertEquals(1, fib(1))
        assertEquals(1, fib(2))
        assertEquals(2, fib(3))
        assertEquals(5, fib(5))
        assertEquals(21, fib(8))
        assertEquals(102334155, fib(40))
    }

    @Test
    fun lcm() {
        assertEquals(13, lcm(13, 13))
        assertEquals(8, lcm(2, 8))
        assertEquals(24, lcm(6, 8))
        assertEquals(975, lcm(39, 75))
    }

    @Test
    fun minDivisor() {
        assertEquals(2, minDivisor(2))
        assertEquals(3, minDivisor(75))
        assertEquals(5, minDivisor(75 / 3))
        assertEquals(97, minDivisor(97))
        assertEquals(7, minDivisor(49))
        assertEquals(17, minDivisor(8653))
    }

    @Test
    fun revert() {
        assertEquals(87431, revert(13478))
        assertEquals(0, revert(0))
        assertEquals(3, revert(3))
        assertEquals(111, revert(111))
        assertEquals(17571, revert(17571))
        assertEquals(123456789, revert(987654321))
    }

    @Test
    fun isAnagram() {
        assertTrue(isAnagram(3))
        assertFalse(isAnagram(3653))
        assertTrue(isAnagram(15751))
        assertTrue(isAnagram(24688642))
    }

    @Test
    fun digitNumber() {
        assertEquals(1, digitNumber(0))
        assertEquals(1, digitNumber(7))
        assertEquals(2, digitNumber(10))
        assertEquals(2, digitNumber(99))
        assertEquals(3, digitNumber(123))
        assertEquals(10, digitNumber(Int.MAX_VALUE))
    }

    @Test
    fun squareSequenceDigit() {
        assertEquals(1, squareSequenceDigit(1))
        assertEquals(4, squareSequenceDigit(2))
        assertEquals(5, squareSequenceDigit(7))
        assertEquals(6, squareSequenceDigit(12))
        assertEquals(0, squareSequenceDigit(17))
        assertEquals(9, squareSequenceDigit(27))
    }

    @Test
    fun fibSequenceDigit() {
        assertEquals(1, fibSequenceDigit(1))
        assertEquals(1, fibSequenceDigit(2))
        assertEquals(3, fibSequenceDigit(4))
        assertEquals(2, fibSequenceDigit(9))
        assertEquals(5, fibSequenceDigit(14))
        assertEquals(2, fibSequenceDigit(20))
    }

    @Test
    fun isCoPrime() {
        assertTrue(isCoPrime(25, 49))
        assertFalse(isCoPrime(6, 8))
        assertTrue(isCoPrime(17, 97))
        assertFalse(isCoPrime(37, 111))
    }

    @Test
    fun squareBetweenExists() {
        assertTrue(squareBetweenExists(1, 1))
        assertTrue(squareBetweenExists(21, 28))
        assertFalse(squareBetweenExists(51, 61))
        assertFalse(squareBetweenExists(999, 1001))
    }
}