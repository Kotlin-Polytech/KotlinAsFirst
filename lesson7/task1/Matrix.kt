@file:Suppress("UNUSED_PARAMETER", "unused")
package lesson7.task1

/* Ячейка матрицы: row = ряд, column = колонка */
data class Cell(val row: Int, val column: Int)

/* Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы */
interface Matrix<E> {
    /* Высота */
    val height: Int

    /* Ширина */
    val width: Int

    /* Доступ к ячейке. Методы могут вернуть null, если в ячейку ранее ничего не было записано */
    operator fun get(row: Int, column: Int): E?
    operator fun get(cell: Cell): E?

    /* Запись в ячейку */
    operator fun set(row: Int, column: Int, value: E)
    operator fun set(cell: Cell, value: E)
}

/*
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int): Matrix<E> = TODO()

/* Реализация интерфейса "матрица" */
class MatrixImpl<E> : Matrix<E> {
    override val height: Int = TODO()

    override val width: Int = TODO()

    override fun get(row: Int, column: Int): E? = TODO()

    override fun get(cell: Cell): E? = TODO()

    override fun set(row: Int, column: Int, value: E) {
        TODO()
    }

    override fun set(cell: Cell, value: E) {
        TODO()
    }

    override fun equals(other: Any?) = TODO()

    override fun toString(): String = TODO()
}

