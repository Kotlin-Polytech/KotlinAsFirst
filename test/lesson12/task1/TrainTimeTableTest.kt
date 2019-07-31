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
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertFalse(ttt.addStop("N1", Stop("СПб", Time(6, 31))))
        assertTrue(ttt.addStop("N1", Stop("Купчино", Time(6, 46))))
        assertThrows(IllegalArgumentException::class.java) {
            ttt.addStop("N1", Stop("Неверная", Time(7, 11)))
        }
        assertThrows(IllegalArgumentException::class.java) {
            ttt.addStop("N1", Stop("СПб", Time(6, 50)))
        }
        assertFalse(ttt.addStop("N1", Stop("Купчино", Time(6, 44))))
        assertFalse(ttt.addStop("N1", Stop("Пушкин", Time(7, 0))))
        assertThrows(IllegalArgumentException::class.java) {
            ttt.addStop("N1", Stop("Пушкин", Time(6, 40)))
        }
    }

    @Test
    @Tag("Normal")
    fun removeStop() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt.addStop("N1", Stop("Купчино", Time(6, 48))))
        assertFalse(ttt.removeStop("N1", "Неверная"))
        assertFalse(ttt.removeStop("N1", "СПб"))
        assertFalse(ttt.removeStop("N1", "Пушкин"))
        assertTrue(ttt.removeStop("N1", "Купчино"))
    }

    @Test
    @Tag("Hard")
    fun trains() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 6))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt.addTrain("N3", Time(6, 42), Stop("Пушкин", Time(7, 10))))
        assertTrue(ttt.addStop("N1", Stop("Купчино", Time(6, 52))))
        assertTrue(ttt.addStop("N2", Stop("Купчино", Time(6, 32))))
        assertTrue(ttt.addStop("N3", Stop("Купчино", Time(6, 49))))
        assertEquals(
            listOf(
                Train("N3", Stop("СПб", Time(6, 42)), Stop("Купчино", Time(6, 49)), Stop("Пушкин", Time(7, 10))),
                Train("N1", Stop("СПб", Time(6, 35)), Stop("Купчино", Time(6, 52)), Stop("Пушкин", Time(7, 6)))
            ), ttt.trains(Time(6, 30), "Купчино")
        )
    }

    @Test
    @Tag("Hard")
    fun testEquals() {
        val ttt1 = TrainTimeTable("СПб")
        assertTrue(ttt1.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt1.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt1.addStop("N2", Stop("Купчино", Time(6, 31))))
        assertTrue(ttt1.addStop("N2", Stop("Шушары", Time(6, 35))))
        val ttt2 = TrainTimeTable("СПб")
        assertTrue(ttt2.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt2.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt2.addStop("N2", Stop("Шушары", Time(6, 35))))
        assertTrue(ttt2.addStop("N2", Stop("Купчино", Time(6, 31))))
        assertTrue(ttt1 == ttt2)
    }
}