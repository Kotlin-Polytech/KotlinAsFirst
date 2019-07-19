package lesson10.task1

import lesson10.task1.Expression.Operation.*
import java.io.File
import java.util.regex.Pattern

/**
 * Пример
 *
 * Во входном файле с именем inputName
 * содержится строчка, содержащая описание функции от x, например:
 *
 * 3*x*x - 2 / x  + 7 -x
 *
 * В списке values содержатся целочисленные значения аргумента x, например, (1, 2, -1)
 *
 * Вернуть ассоциативный массив (map), содержащий отображение заданных значений аргумента
 * в значение заданной в файле функции, в данном случае
 *
 * (1 to 7, 2 to 16, -1 to 13)
 *
 * В функции могут присутствовать четыре арифметических действия и круглые скобки.
 * Обратите внимание, что функция является целочисленной,
 * то есть деление также следует трактовать как целочисленное.
 */
fun parseExpr(inputName: String, values: List<Int>): Map<Int, Int> {
    val expr = File(inputName).readLines().firstOrNull()?.parseExpr() ?: throw IllegalArgumentException()
    val result = mutableMapOf<Int, Int>()
    for (value in values) {
        result[value] = expr.calculate(value)
    }
    return result
}

fun String.parseExpr(): Expression {
    val pattern = Pattern.compile("""x|\+|-|\*|/|\(|\)|\d+| +?|.+?""")
    val matcher = pattern.matcher(this)
    val groups = mutableListOf<String>()
    while (matcher.find()) {
        val group = matcher.group()
        if (group[0] != ' ') {
            groups.add(group)
        }
    }
    return Parser(groups).parse()
}

sealed class Expression {
    object Variable : Expression()

    class Constant(val value: Int) : Expression()

    enum class Operation {
        PLUS,
        MINUS,
        TIMES,
        DIV;
    }

    class Binary(val left: Expression, val op: Operation, val right: Expression) : Expression()

    class Negate(val arg: Expression) : Expression()

    fun calculate(x: Int): Int = when (this) {
        Variable -> x
        is Constant -> value
        is Binary -> when (op) {
            PLUS -> {
                left.calculate(x) + right.calculate(x)
            }
            MINUS -> {
                left.calculate(x) - right.calculate(x)
            }
            TIMES -> {
                left.calculate(x) * right.calculate(x)
            }
            DIV -> {
                left.calculate(x) / right.calculate(x)
            }
        }
        is Negate -> -arg.calculate(x)
    }
}

class Parser(private val groups: List<String>) {
    private var pos = 0

    fun parse(): Expression {
        val result = parseExpression()
        check(pos >= groups.size) { "Unexpected expression remainder: ${groups.subList(pos, groups.size)}" }
        return result
    }

    private fun parseExpression(): Expression {
        var left = parseItem()
        while (pos < groups.size) {
            when (val op = operationMap[groups[pos]]) {
                PLUS, MINUS -> {
                    pos++
                    val right = parseItem()
                    left = Expression.Binary(left, op, right)
                }
                else -> return left
            }
        }
        return left
    }

    private fun parseItem(): Expression {
        var left = parseFactor()
        while (pos < groups.size) {
            when (val op = operationMap[groups[pos]]) {
                TIMES, DIV -> {
                    pos++
                    val right = parseFactor()
                    left = Expression.Binary(left, op, right)
                }
                else -> return left
            }
        }
        return left
    }

    private fun parseFactor(): Expression {
        check(pos < groups.size) { "Unexpected expression end" }
        return when (val group = groups[pos++]) {
            "x" -> Expression.Variable
            "-" -> Expression.Negate(parseFactor())
            "(" -> {
                val arg = parseExpression()
                val next = groups[pos++]
                if (next == ")") arg
                else throw IllegalStateException(") expected instead of $next")
            }
            else -> Expression.Constant(group.toInt())
        }
    }

    private val operationMap = mapOf("+" to PLUS, "-" to MINUS, "*" to TIMES, "/" to DIV)
}