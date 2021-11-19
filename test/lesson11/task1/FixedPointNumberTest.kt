package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

class FixedPointNumberTest {

    @Test
    @Tag("6")
    fun fpnGetPrecision() {
        val n = FixedPointNumber("1.2345")
        assertEquals(4, n.precision)
        val m = FixedPointNumber(42)
        assertEquals(0, m.precision)
    }

    @Test
    @Tag("6")
    fun fpnPlus() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("22.0982"), x + y)
    }

    @Test
    @Tag("4")
    fun fpnUnaryMinus() {
        val x = FixedPointNumber("2.345")
        assertEquals(FixedPointNumber("-2.345"), -x)
    }

    @Test
    @Tag("6")
    fun fpnMinus() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("17.4082"), y - x)
    }

    @Test
    @Tag("10")
    fun fpnTimes() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("46.3213"), x * y)
    }

    @Test
    @Tag("10")
    fun fpnDiv() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertEquals(FixedPointNumber("8.424"), y / x)
    }

    @Test
    @Tag("6")
    fun fpnEquals() {
        val x = FixedPointNumber(19.7532, 4)
        val y = FixedPointNumber("19.7532")
        assertTrue(x == y)
    }

    @Test
    @Tag("6")
    fun fpnHashCode() {
        val x = FixedPointNumber(19.7532, 4)
        val y = FixedPointNumber("19.7532")
        assertTrue(x.hashCode() == y.hashCode())
    }

    @Test
    @Tag("6")
    fun fpnCompareTo() {
        val x = FixedPointNumber("2.345")
        val y = FixedPointNumber("19.7532")
        assertTrue(y > x)
        assertTrue(x < y)
    }

    @Test
    @Tag("4")
    fun fpnToString() {
        val x = FixedPointNumber(19.7532, 4)
        assertEquals("19.7532", x.toString())
    }

    @Test
    @Tag("6")
    fun fpnToDouble() {
        val x = FixedPointNumber("19.7532")
        assertEquals(19.7532, x.toDouble(), 1e-5)
    }
}