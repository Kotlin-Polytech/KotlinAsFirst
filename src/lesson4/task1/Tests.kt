package lesson4.task1

import org.junit.Test

import org.junit.Assert.*

class Tests {
    @Test
    fun mean() {
        assertEquals(0.0, mean(listOf()), 1e-5)
        assertEquals(1.0, mean(listOf(1.0)), 1e-5)
        assertEquals(2.0, mean(listOf(3.0, 1.0, 2.0)), 1e-5)
        assertEquals(3.0, mean(listOf(0.0, 2.0, 7.0, 8.0, -2.0)), 1e-5)
    }

    @Test
    fun center() {
        assertEquals(listOf<Double>(), center(arrayListOf()))
        assertEquals(listOf(0.0), center(arrayListOf(3.14)))
        assertEquals(listOf(1.0, -1.0, 0.0), center(arrayListOf(3.0, 1.0, 2.0)))
        assertEquals(listOf(-3.0, -1.0, 4.0, 5.0, -5.0), center(arrayListOf(0.0, 2.0, 7.0, 8.0, -2.0)))
    }

    @Test
    fun times() {
        assertEquals(0.0, times(listOf(), listOf()), 1e-5)
        assertEquals(-5.0, times(listOf(1.0, -4.0), listOf(3.0, 2.0)), 1e-5)
        assertEquals(-19.0, times(listOf(-1.0, 2.0, -3.0), listOf(3.0, -2.0, 4.0)), 1e-5)
    }

    @Test
    fun abs() {
        assertEquals(0.0, abs(listOf()), 1e-5)
        assertEquals(3.0, abs(listOf(3.0)), 1e-5)
        assertEquals(5.0, abs(listOf(3.0, -4.0)), 1e-5)
        assertEquals(8.774964, abs(listOf(4.0, -5.0, 6.0)), 1e-5)
    }

    @Test
    fun polynom() {
        assertEquals(0.0, polynom(listOf(), 1000.0), 1e-5)
        assertEquals(42.0, polynom(listOf(42.0), -1000.0), 1e-5)
        assertEquals(13.0, polynom(listOf(3.0, 2.0), 5.0), 1e-5)
        assertEquals(0.0, polynom(listOf(2.0, -3.0, 1.0), 1.0), 1e-5)
        assertEquals(45.0, polynom(listOf(-7.0, 6.0, 4.0, -4.0, 1.0), -2.0), 1e-5)
    }

    @Test
    fun accumulate() {
        assertEquals(listOf<Double>(), accumulate(arrayListOf()))
        assertEquals(listOf(3.14), accumulate(arrayListOf(3.14)))
        assertEquals(listOf(1.0, 3.0, 6.0, 10.0), accumulate(arrayListOf(1.0, 2.0, 3.0, 4.0)))
    }

    @Test
    fun factorize() {
        assertEquals(listOf(2), factorize(2))
        assertEquals(listOf(3, 5, 5), factorize(75))
        assertEquals(listOf(2, 3, 3, 19), factorize(342))
    }

    @Test
    fun factorizeToString() {
        assertEquals("2", factorizeToString(2))
        assertEquals("3*5*5", factorizeToString(75))
        assertEquals("2*3*3*19", factorizeToString(342))
    }

    @Test
    fun convert() {
        assertEquals(listOf(1), convert(1, 2))
        assertEquals(listOf(1, 2, 1, 0), convert(100, 4))
        assertEquals(listOf(1, 3, 12), convert(250, 14))
        assertEquals(listOf(2, 14, 12), convert(1000, 19))
    }

    @Test
    fun convertToString() {
        assertEquals("1", convertToString(1, 2))
        assertEquals("1210", convertToString(100, 4))
        assertEquals("13c", convertToString(250, 14))
        assertEquals("2ec", convertToString(1000, 19))
        assertEquals("z", convertToString(35, 36))
    }

    @Test
    fun decimal() {
        assertEquals(1, decimal(listOf(1), 2))
        assertEquals(100, decimal(listOf(1, 2, 1, 0), 4))
        assertEquals(250, decimal(listOf(1, 3, 12), 14))
        assertEquals(1000, decimal(listOf(2, 14, 12), 19))
    }

    @Test
    fun decimalFromString() {
        assertEquals(1, decimalFromString("1", 2))
        assertEquals(100, decimalFromString("1210", 4))
        assertEquals(250, decimalFromString("13c", 14))
        assertEquals(1000, decimalFromString("2ec", 19))
        assertEquals(35, decimalFromString("z", 36))
    }

    @Test
    fun roman() {
        assertEquals("I", roman(1))
        assertEquals("MMM", roman(3000))
        assertEquals("MCMLXXVIII", roman(1978))
        assertEquals("DCXCIV", roman(694))
    }

    @Test
    fun russian() {
        assertEquals("триста семьдесят пять", russian(375))
        assertEquals("двадцать две тысячи девятьсот шестьдесят четыре", russian(22964))
        assertEquals("сто девятнадцать тысяч пятьсот восемь", russian(119508))
    }
}