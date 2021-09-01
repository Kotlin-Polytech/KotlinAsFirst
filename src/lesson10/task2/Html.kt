package lesson10.task2

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

/**
 * Пример: преобразование списка списков в HTML таблицу (решение в лоб)
 */
fun List<List<String>>.convertToHtmlTable(): String {
    val sb = StringBuilder()
    sb.append("<html>")
    sb.append("<body>")
    sb.append("<table>")
    for (row in this) {
        sb.append("<tr>")
        for (data in row) {
            sb.append("<td>")
            sb.append(data)
            sb.append("</td>")
        }
        sb.append("</tr>")
    }
    sb.append("</table>")
    sb.append("</body>")
    sb.append("</html>")
    return sb.toString()
}

/**
 * Пример: преобразование списка списков в HTML таблицу
 * (через функции библиотеки kotlinx.html)
 */
fun List<List<String>>.convertToHtmlTableUsingKotlinxHtml(): String {
    val inputList = this
    val sb = StringBuilder()
    sb.appendHTML().html {
        body {
            table {
                for (row in inputList) {
                    tr {
                        for (data in row) {
                            td { +data }
                        }
                    }
                }
            }
        }
    }
    return sb.toString()
}

/**
 * Пример: генерация простого HTML (собственный мини-DSL)
 */
fun generateSimpleHtml(s: String): String {
    val sb = StringBuilder()
    sb.myHtml {
        myBody {
            +s
        }
    }
    return sb.toString()
}

/**
 * Средняя (5 баллов)
 *
 * Преобразовать заданный список строк в нумерованный список HTML.
 * К примеру, из ["Alpha", "Beta", "Omega"] мы должны получить следующее
 * <html><body>
 * <ol>
 *     <li>Alpha</li>
 *     <li>Beta</li>
 *     <li>Omega</li>
 * </ol>
 * </body></html>
 *
 * В этом задании вы должны заменить на реальный код содержимое функций myList, myItem, unaryPlus
 * и использовать их в функции generateSimpleHtml
 *
 * Пробелы и переводы строк между тегами в этом задании значения не имеют.
 */
fun generateListHtml(list: List<String>): String {
    val sb = StringBuilder()
    sb.myHtml {
        myBody {
            myList {
                TODO()
            }
        }
    }
    return sb.toString()
}

private class HTML(val sb: StringBuilder) {
    fun myBody(init: HTMLBody.() -> Unit): HTMLBody {
        val body = HTMLBody(sb)
        sb.append("<body>")
        body.init()
        sb.append("</body>")
        return body
    }
}

private class HTMLBody(val sb: StringBuilder) {
    operator fun String.unaryPlus() {
        sb.append(this)
    }

    fun myList(init: HTMLList.() -> Unit): HTMLList {
        TODO()
    }
}

private class HTMLList(val sb: StringBuilder) {
    fun myItem(init: HTMLItem.() -> Unit): HTMLItem {
        TODO()
    }
}

private class HTMLItem(val sb: StringBuilder) {
    operator fun String.unaryPlus() {
    }
}

private fun StringBuilder.myHtml(init: HTML.() -> Unit): HTML {
    val html = HTML(this)
    append("<html>")
    html.init()
    append("</html>")
    return html
}

