package lesson12.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

internal class TableFunctionTest {

    @Test
    @Tag("Normal")
    fun add() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        function.add(3.0, 4.0)
        assertTrue(function.add(5.0, 6.0))
        assertFalse(function.add(5.0, 7.0))
        assertEquals(3, function.size)
    }

    @Test
    @Tag("Normal")
    fun remove() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        function.add(3.0, 4.0)
        assertTrue(function.remove(1.0))
        assertFalse(function.remove(1.0))
        assertEquals(1, function.size)
    }

    @Test
    @Tag("Normal")
    fun getPairs() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        val pairs = function.getPairs()
        assertEquals(1, pairs.size)
        assertEquals(1.0 to 2.0, pairs.single())
    }

    @Test
    @Tag("Normal")
    fun findPair() {
        val function = TableFunction()
        function.add(1.0, 2.0)
        function.add(3.0, 4.0)
        function.add(5.0, 6.0)
        assertEquals(5.0 to 6.0, function.findPair(5.75))
        assertEquals(1.0 to 2.0, function.findPair(1.5))
    }

    @Test
    @Tag("Hard")
    fun getValue() {
        val function = TableFunction()
        try {
            function.getValue(0.0)
        } catch (ex: IllegalArgumentException) {
            // pass
        } catch (ex: NotImplementedError) {
            throw ex
        }
        function.add(1.0, 2.0)
        assertEquals(2.0, function.getValue(1.5))
        function.add(3.0, 4.0)
        function.add(5.0, 6.0)
        assertEquals(5.0, function.getValue(4.0), 1e-10)
        assertEquals(0.0, function.getValue(-1.0), 1e-10)
    }

    @Test
    @Tag("Normal")
    fun equals() {
        val f1 = TableFunction()
        f1.add(1.0, 2.0)
        f1.add(3.0, 4.0)
        val f2 = TableFunction()
        f2.add(3.0, 4.0)
        f2.add(1.0, 2.0)
        assertEquals(f1, f2)
    }
}