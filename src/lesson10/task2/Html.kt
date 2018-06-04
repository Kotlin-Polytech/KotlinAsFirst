package lesson10.task2

import kotlinx.html.*
import kotlinx.html.stream.appendHTML

/**
 * Пример: преобразование списка списков в HTML таблицу
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

fun generateSimpleHtml(s: String): String {
    val sb = StringBuilder()
    sb.myHtml {
        myBody {
            +s
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
}

private fun StringBuilder.myHtml(init: HTML.() -> Unit): HTML {
    val html = HTML(this)
    append("<html>")
    html.init()
    append("</html>")
    return html
}

