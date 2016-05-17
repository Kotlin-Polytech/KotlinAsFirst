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

}