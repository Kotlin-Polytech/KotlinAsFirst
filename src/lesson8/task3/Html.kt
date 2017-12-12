package lesson8.task3

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

