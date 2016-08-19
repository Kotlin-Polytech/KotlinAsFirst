package lesson7.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Tests {
    @Test
    fun createMatrix() {
        val matrix = createMatrix(4, 6, 0.0)
        assertEquals(4, matrix.height)
        assertEquals(6, matrix.width)
    }

    @Test
    fun getSetInt() {
        val matrix = createMatrix(3, 2, 0)
        var value = 0
        for (row in 0..matrix.height - 1) {
            for (column in 0..matrix.width - 1) {
                matrix[row, column] = value++
            }
        }
        value = 0
        for (row in 0..matrix.height - 1) {
            for (column in 0..matrix.width - 1) {
                assertEquals(value++, matrix[Cell(row, column)])
            }
        }
    }

    @Test
    fun getSetString() {
        val matrix = createMatrix(2, 2, "")
        val strings = listOf("alpha", "beta", "gamma", "omega")
        var index = 0
        for (row in 0..matrix.height - 1) {
            for (column in 0..matrix.width - 1) {
                matrix[Cell(row, column)] = strings[index++]
            }
        }
        index = 0
        for (row in 0..matrix.height - 1) {
            for (column in 0..matrix.width - 1) {
                assertEquals(strings[index++], matrix[row, column])
            }
        }
    }
}