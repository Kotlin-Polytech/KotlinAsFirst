package lesson10.task2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

class Tests {
    @Test
    @Tag("Example")
    fun convertToHtmlTable() {
        val data = listOf(listOf("1", "2", "3"), listOf("4", "5", "6"))
        assertEquals(
            "<html><body><table>" +
                    "<tr><td>1</td><td>2</td><td>3</td></tr>" +
                    "<tr><td>4</td><td>5</td><td>6</td></tr>" +
                    "</table></body></html>", data.convertToHtmlTable()
        )
    }

    @Test
    @Tag("Example")
    fun convertToHtmlTableUsingKotlinxHTML() {
        val data = listOf(listOf("1", "2", "3"), listOf("4", "5", "6"))
        assertEquals(
            "<html><body><table>" +
                    "<tr><td>1</td><td>2</td><td>3</td></tr>" +
                    "<tr><td>4</td><td>5</td><td>6</td></tr>" +
                    "</table></body></html>", data.convertToHtmlTableUsingKotlinxHtml().replace("\\s+".toRegex(), "")
        )
    }

    @Test
    @Tag("Example")
    fun generateSimpleHtml() {
        assertEquals("<html><body>Hello!</body></html>", generateSimpleHtml("Hello!"))
    }

    @Test
    @Tag("5")
    fun generateListHtml() {
        assertEquals(
            """
                 <html><body>
                     <ol>
                         <li>Alpha</li>
                         <li>Beta</li>
                         <li>Omega</li>
                     </ol>
                  </body></html>
            """.trimIndent().replace("[\\r\\n ]".toRegex(), ""), generateListHtml(listOf("Alpha", "Beta", "Omega"))
        )
    }
}