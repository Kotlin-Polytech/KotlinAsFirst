package lesson8.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    @Tag("Hard")
    fun transliterate() {
        transliterate(
                "input/trans_in1.txt",
                mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!"),
                "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Hard")
    fun chooseLongestChaoticWord() {
        chooseLongestChaoticWord("input/chaotic_in1.txt", "temp.txt")
        assertFileContent("temp.txt", "Карминовый, Некрасивый")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlSimple() {
        markdownToHtmlSimple("input/markdown_simple.md", "temp.html")

        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
                """
                <html>
                    <body>
                        <p>
                            Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
                            Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
                        </p>
                        <p>
                            Suspendisse <s>et elit in enim tempus iaculis</s>.
                        </p>
                    </body>
                </html>
                """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlLists() {
        markdownToHtmlLists("input/markdown_lists.md", "temp.html")

        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
                """
                <html>
                  <body>
                    <ul>
                      <li>
                        Утка по-пекински
                        <ul>
                          <li>Утка</li>
                          <li>Соус</li>
                        </ul>
                      </li>
                      <li>
                        Салат Оливье
                        <ol>
                          <li>Мясо
                            <ul>
                              <li>
                                  Или колбаса
                              </li>
                            </ul>
                          </li>
                          <li>Майонез</li>
                          <li>Картофель</li>
                          <li>Что-то там ещё</li>
                        </ol>
                      </li>
                      <li>Помидоры</li>
                      <li>
                        Фрукты
                        <ol>
                          <li>Бананы</li>
                          <li>
                            Яблоки
                            <ol>
                              <li>Красные</li>
                              <li>Зелёные</li>
                            </ol>
                          </li>
                        </ol>
                      </li>
                    </ul>
                  </body>
                </html>
                """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Normal")
    fun printMultiplicationProcess() {
        fun test(lhv: Int, rhv: Int, res: String) {
            printMultiplicationProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(19935,
             111,
             """
                19935
             *    111
             --------
                19935
             + 19935
             +19935
             --------
              2212785
             """
        )

        test(12345,
             76,
             """
               12345
             *    76
             -------
               74070
             +86415
             -------
              938220
             """
        )

        test(12345,
             6,
             """
              12345
             *    6
             ------
              74070
             ------
              74070
             """
        )

    }

    @Test
    @Tag("Impossible")
    fun printDivisionProcess() {

        fun test(lhv: Int, rhv: Int, res: String) {
            printDivisionProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(199735,
             22,
             """
              19935 | 22
             -198     906
             ----
                13
                -0
                --
                135
               -132
               ----
                  3
             """
        )

        test(2,
             20,
             """
              2 | 20
             -0   0
             --
              2
             """
        )

        test(99999,
             1,
             """
              99999 | 1
             -9       99999
             --
              09
              -9
              --
               09
               -9
               --
                09
                -9
                --
                 09
                 -9
                 --
                  0
             """
        )

        File("temp.txt").delete()
    }

}