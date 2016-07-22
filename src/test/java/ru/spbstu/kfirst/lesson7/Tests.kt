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

    @Test
    fun generateRectangles() {
        assertEquals(createMatrix(1, 1, listOf(listOf(1))), generateRectangles(1, 1))
        assertEquals(createMatrix(2, 2,
                listOf(
                        listOf(1, 1),
                        listOf(1, 1)
                )), generateRectangles(2, 2))
        assertEquals(createMatrix(4, 3,
                listOf(
                        listOf(1, 1, 1),
                        listOf(1, 2, 1),
                        listOf(1, 2, 1),
                        listOf(1, 1, 1)
                )), generateRectangles(4, 3))
        assertEquals(createMatrix(5, 6,
                listOf(
                        listOf(1, 1, 1, 1, 1, 1),
                        listOf(1, 2, 2, 2, 2, 1),
                        listOf(1, 2, 3, 3, 2, 1),
                        listOf(1, 2, 2, 2, 2, 1),
                        listOf(1, 1, 1, 1, 1, 1)
                )), generateRectangles(5, 6))

    }

    @Test
    fun generateSnake() {
        assertEquals(createMatrix(1, 1, listOf(listOf(1))), generateSnake(1, 1))
        assertEquals(createMatrix(2, 2,
                listOf(
                        listOf(1, 2),
                        listOf(3, 4)
                )), generateSnake(2, 2))
        assertEquals(createMatrix(4, 2,
                listOf(
                        listOf(1, 2),
                        listOf(3, 4),
                        listOf(5, 6),
                        listOf(7, 8)
                )), generateSnake(4, 2))
        assertEquals(createMatrix(5, 4,
                listOf(
                        listOf(1, 2, 4, 7),
                        listOf(3, 5, 8, 11),
                        listOf(6, 9, 12, 15),
                        listOf(10, 13, 16, 18),
                        listOf(14, 17, 19, 20)
                )), generateSnake(5, 4))

    }

    @Test
    fun rotate() {
        val m = createMatrix(1, 1, listOf(listOf(("single"))))
        assertEquals(m, rotate(m))
        assertEquals(createMatrix(2, 2, listOf(listOf("alpha", "beta"),
                                               listOf("gamma", "delta"))),
                     rotate(createMatrix(2, 2, listOf(listOf("beta", "delta"),
                                                      listOf("alpha", "gamma")))))
        assertEquals(createMatrix(3, 3, listOf(listOf(7, 4, 1), listOf(8, 5, 2), listOf(9, 6, 3))),
                     rotate(createMatrix(3, 3, listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)))))
    }

    @Test
    fun isLatinSquare() {
        assertTrue(isLatinSquare(createMatrix(1, 1, listOf(listOf(1)))))
        assertFalse(isLatinSquare(createMatrix(1, 1, listOf(listOf(2)))))
        assertTrue(isLatinSquare(createMatrix(2, 2, listOf(listOf(1, 2), listOf(2, 1)))))
        assertFalse(isLatinSquare(createMatrix(2, 2, listOf(listOf(1, 2), listOf(1, 2)))))
        assertTrue(isLatinSquare(createMatrix(3, 3, listOf(listOf(2, 3, 1), listOf(1, 2, 3), listOf(3, 1, 2)))))
        assertFalse(isLatinSquare(createMatrix(3, 3, listOf(listOf(2, 3, 1), listOf(1, 2, 3), listOf(3, 1, 4)))))
        assertFalse(isLatinSquare(createMatrix(3, 3, listOf(listOf(2, 3, 1), listOf(1, 2, 3), listOf(1, 3, 2)))))
        assertFalse(isLatinSquare(createMatrix(3, 3, listOf(listOf(2, 3, 0), listOf(1, 2, 3), listOf(3, 1, 2)))))
    }
}