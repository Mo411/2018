val input06a2 = """
268, 273
211, 325
320, 225
320, 207
109, 222
267, 283
119, 70
138, 277
202, 177
251, 233
305, 107
230, 279
243, 137
74, 109
56, 106
258, 97
248, 346
71, 199
332, 215
208, 292
154, 80
74, 256
325, 305
174, 133
148, 51
112, 71
243, 202
136, 237
227, 90
191, 145
345, 133
340, 299
322, 256
86, 323
341, 310
342, 221
50, 172
284, 160
267, 142
244, 153
131, 147
245, 323
42, 241
90, 207
245, 167
335, 106
299, 158
181, 186
349, 286
327, 108
""".trimIndent()

val input06a1= """
1, 1
1, 6
8, 3
3, 4
5, 5
8, 9
""".trimIndent()



fun main(args: Array<String>) {

    val grid = Array(10) { Array(10) { 0 } }

    val lines = input06a1.lines()
    for (lineIndex in lines.indices) {
        val coordX = lines[lineIndex].substringBefore(", ").toInt()
        val coordY = lines[lineIndex].substringAfter(", ").toInt()
        grid[coordY][coordX] = lineIndex + 1
        println("line: " + grid[coordY][coordX] + " x: " + coordX + " y: " +coordY)


        for(iteration in 1..10)  {

        }
    }





    grid.map { it.map {
        print("$it ")
        }
        println("|")
    }

}