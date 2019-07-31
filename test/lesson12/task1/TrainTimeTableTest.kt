package lesson12.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

class TrainTimeTableTest {

    @Test
    @Tag("Normal")
    fun addTrain() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertFalse(ttt.addTrain("N1", Time(6, 25), Stop("Пушкин", Time(6, 49))))
        assertEquals(
            listOf(
                Train("N2", Stop("СПб", Time(6, 18)), Stop("Пушкин", Time(6, 45))),
                Train("N1", Stop("СПб", Time(6, 35)), Stop("Пушкин", Time(7, 4)))
            ), ttt.trains()
        )
    }

    @Test
    @Tag("Normal")
    fun removeTrain() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertFalse(ttt.removeTrain("N3"))
        assertTrue(ttt.removeTrain("N1"))
        assertEquals(1, ttt.trains().size)
    }

    @Test
    @Tag("Hard")
    fun addStop() {
    }

    @Test
    @Tag("Normal")
    fun removeStop() {
    }

    @Test
    @Tag("Hard")
    fun trains() {
    }

    @Test
    @Tag("Hard")
    fun testEquals() {
    }
}