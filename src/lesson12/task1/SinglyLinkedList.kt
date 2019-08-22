package lesson12.task1

/**
 * Пример: класс "Однонаправленный линейный (связный) список".
 *
 * Подробности по организации см. статью Википедии "Связный список".
 * Поддерживаемые возможности: добавление (в начало),
 * удаление (в начало и в конец), удаление заданного значения,
 * вычисление размера и признака пустоты,
 * сравнение списков на равенство
 * (списки равны, если равны их размеры и соответствующие элементы),
 * преобразование в строку.
 *
 * Возможные улучшения: преобразование в шаблонный класс <T>,
 * реализация интерфейса (Mutable)List<Int> или (Mutable)List<T>
 */
class SinglyLinkedList {

    // Ссылка на первый узел в списке
    private var start: Node? = null

    private class Node(
        val value: Int,
        var next: Node? // next == null означает, что данный узел -- последний в списке
    )

    fun add(newValue: Int) {
        // Узел всегда добавляется в первую позицию в списке
        start = Node(newValue, start)
    }

    // Удаление первого узла, возвращает false, если список пуст
    fun removeFirst(): Boolean {
        if (start == null) return false
        start = start?.next
        return true
    }

    // Удаление последнего узла, возвращает false, если список пуст
    fun removeLast(): Boolean {
        val start = start ?: return false
        if (start.next == null) {
            this.start = null
        } else {
            var current = start
            while (current.next?.next != null) {
                current = current.next!!
            }
            current.next = null
        }
        return true
    }

    // Удаление узла по значению, возвращает false, если узла с таким значением нет в списке
    fun remove(removedValue: Int): Boolean {
        val start = start ?: return false
        if (start.value == removedValue) {
            this.start = start.next
            return true
        } else {
            var current = start
            while (current.next != null) {
                if (current.next?.value == removedValue) {
                    current.next = current.next?.next
                    return true
                }
                current = current.next!!
            }
            return false
        }
    }

    // Размер
    val size: Int
        get() {
            var current = start
            var result = 0
            while (current != null) {
                current = current.next
                result++
            }
            return result
        }

    // Признак пустоты
    fun isEmpty(): Boolean = start == null

    // Списки равны, если равны их размеры и соответствующие элементы
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SinglyLinkedList) return false
        var ourCurrent = start
        var otherCurrent = other.start
        while (ourCurrent != null) {
            if (otherCurrent == null || ourCurrent.value != otherCurrent.value) return false
            ourCurrent = ourCurrent.next
            otherCurrent = otherCurrent.next
        }
        return otherCurrent == null
    }

    override fun hashCode(): Int {
        var current = start
        var result = 13
        while (current != null) {
            result = result * 31 + current.value
            current = current.next
        }
        return result
    }

    override fun toString(): String {
        return buildString {
            append("[")
            val start = start
            if (start != null) {
                append(start.value)
                var current = start
                while (current?.next != null) {
                    current = current.next
                    append(", ")
                    append(current!!.value)
                }
            }
            append("]")
        }
    }
}
