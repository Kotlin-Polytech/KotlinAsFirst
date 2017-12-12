package lesson8.task3

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
