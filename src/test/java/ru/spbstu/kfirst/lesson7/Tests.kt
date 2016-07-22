package ru.spbstu.kfirst.lesson7

import org.junit.Test

import org.junit.Assert.*

class Tests {

    @Test
    fun createMatrix() {
        val matrix = createMatrix<Double>(4, 6)
        assertEquals(4, matrix.height)
        assertEquals(6, matrix.width)
    }

    @Test
    fun getSetInt() {
        val matrix = createMatrix<Int>(3, 2)
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
        val matrix = createMatrix<String>(2, 2)
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

    private fun<E> createMatrix(height: Int, width: Int, values: List<List<E>>): Matrix<E> {
        val matrix = createMatrix<E>(height, width)
        for (row in 0..height - 1) {
            for (column in 0..width - 1) {
                matrix[row, column] = values[row][column]
            }
        }
        return matrix
    }

    @Test
    fun generateSpiral() {
        assertEquals(createMatrix(1, 1, listOf(listOf(1))), generateSpiral(1, 1))
        assertEquals(createMatrix(2, 2,
                listOf(
                        listOf(1, 2),
                        listOf(4, 3)
                )), generateSpiral(2, 2))
        assertEquals(createMatrix(3, 4,
                listOf(
                    listOf(1, 2, 3, 4),
                    listOf(10, 11, 12, 5),
                    listOf(9, 8, 7, 6)
                )), generateSpiral(3, 4))
    }
}