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

}