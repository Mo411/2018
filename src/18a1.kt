val input18a1 = """
.#.#...|#.
.....#|##|
.|..|...#.
..|#.....#
#.#|||#|#|
...#.||...
.|....|...
||...#|.#|
|.||||..|.
...#.|..|.
""".trimIndent()

val input18a2 = """
...|.#.|#.....|.#||#.|..|.........|...|.||#..||...
##.|..#...|..#..#.##.#....|.#..#........|#.##|....
.|..|#...#.....|||.|.....|.#.......|.#.....|...|..
.#|.||#......#.||.|.....#|..||...#..|....##..#..#.
.|.|##...##.|...|#..#|#|#...|...#||.|.|.|..|..||..
...|#|....#..##...#.|.|##.#||.......||..||..#...|#
.|..|.|.|.#|#.##.##|.#|.#|..|#.|....|..#...|#|#|.#
...|#|....|.#.|......|.|.##..#..#|..|..|...#.#|...
..||.|....|..#..||..|#|.##.....##||....|#........|
.#.#||...||#.##..#.....|.#||#......|...#.|.....|..
......##...#.........|.|#..||...|#||.##...|..##..|
...||..##.#||......#....|.||#|.....|..........#.|#
.....|..|##.|##.#....|.||#...#..#...#.|..|.#...###
.|.#|#.||..#..#...#..|..|......|#|....|.........|.
.#|.#.##..|.#.|.#.#..#|.....|#.#...#...|###..#.#.|
#|..#|..|.........|#.|...#..#.|.#|...|.....|.#||.#
.#....#..|.#|##|##...|.||##.#.|.|...|..#||..#...|.
#.|.||#|||.#|....|....#.##.||#|...|...#...#.##.#..
.#.##.|#.#..|##|.#...........|.|.|..||||.|.|...#|#
|..#...#.#..||....#...##..|.#..#..|..#....##....#.
.|||#.|.........#|.|.|#..##...|....##.|.|.....##..
.....|.|..|#||.#..|........||.#|.....###.#...||#.|
..|||||.##.##...##|...#|.|.#|......|...|#..#....#|
..|#.##......#||....|.|.##.#.|#|.#|||..|.#|.#.#.#.
...#.#...#...#..#..|.#.|...|..|............#...|..
#.....##...#.#.|..#....|.....#.##..##..#..........
||.##..###||.#.#.|..|.#..#.|||#...|#...|..#....|..
..||.#|..........|...|.##...|...|.#....|.#|...|#|.
..||.#...|.|.|...#|.##..||.....#.##....##....#.###
#####..#..#.||...|||...|....|||#.##.#.......##....
..|.##.#.#||.#..#.....||..|#..#...|.|..||.|||...|.
.#.#..#.#.|#.#...#.#.#.##..|#..|..#.||.#..#.....|.
#|..#|......#.#..|...#....#..#..#.##..##..|..#|...
#.|##...#..|.#..#..#||..#...|..#|#|.||#|.||.#.....
##|....#...#|.|#.##.|#|||#|#.#....|....||....|#...
.#|...#...#..#..........||.||...|..||.#.#..|....|#
|..#..####|#.|.#..#...#|.#.##....|#..#..||#.#|.#..
||.|#..|..#....|..#||.|||.|#.|.#|##.|.|.||.|.|#|..
.....|....|...|.#..####|#|....|...|.|....|..#..|..
...#|....|..##.#.|...|..#.#||#.|.#|..|#.|.#...|...
.....##...#|...#|#....|....|###|#..|..|.#.#.....#.
#.|.|.#.#|....#|.#...|##..#.|.##....|.||.....#.#.#
|#.#..#..#|||.....|...|.||||..##..##..|#.|###.|.|.
.#.|...|..........|.|.##|..|.......#|....#...|#|..
..#.#..||..|||...|..#||..#..|..||..#.#..|..|.|...|
|......##|......|..#||||#...|||..........|#.|.|.#.
#|..#.||..|..#........|#.#....#.|.#|#..#........|.
..|#..|.##.#.....#...#..|#.|##.#.#||#......##....|
..|..#.......|##.#.#.|##|.......|.#.......|.#.#.|.
#...|.....#|......|||#||...#....#||.|#....|...#..|
""".trimIndent()



fun runLumber(lumberColRun: Array<Array<Char>>, minutes:Long): Array<Array<Char>> {
    printLumberCol(lumberColRun)

    var newLumberColRun = lumberCol.copy()

    for (min in 1..minutes) {
        if(min%100 == 0L)println("Minute $min")

        newLumberColRun = calcNewAcres(newLumberColRun)

        //printLumberCol(newLumberColRun)
    }

    return newLumberColRun

}

//fun Array<CharArray>.copy() = map { it.clone() }.toTypedArray()
fun Array<Array<Char>>.copy() = Array(size) { get(it).clone() }

fun calcNewAcres(lumberColTemp: Array<Array<Char>>):Array<Array<Char>> {
    val newLumberCol: Array<Array<Char>> = lumberColTemp.copy()
    for (lumberLine in lumberColTemp.indices) {
        val line = lumberColTemp[lumberLine]
        for (lumberChar in line.indices) {
            //var acre = line[lumberChar]
            var acre = transformAcre(lumberColTemp, lumberChar, lumberLine)
            newLumberCol[lumberLine][lumberChar] = acre
            //lumberColTemp[0][0] = 'a'
        }
    }
    return newLumberCol
}


fun transformAcre(lumberColTrans: Array<Array<Char>>, x:Int, y:Int):Char {
    //val neighbors = collectNeighbors(lumberCol, x, y)
    val neighbors:MutableList<MutableMap<Char,Int>> = mutableListOf()

    //lo
    if(x>0 && y>0) {
        neighbors.add(mutableMapOf('x' to x-1, 'y' to y-1))
    }
    //o
    if(y>0) {
        neighbors.add(mutableMapOf('x' to x, 'y' to y-1))
    }
    //ro
    if(x<lumberColTrans[0].lastIndex && y>0) {
        neighbors.add(mutableMapOf('x' to x+1, 'y' to y-1))
    }
    //r
    if(x<lumberColTrans[0].lastIndex) {
        neighbors.add(mutableMapOf('x' to x+1, 'y' to y))
    }
    //ru
    if(x<lumberColTrans[0].lastIndex && y<lumberColTrans.lastIndex) {
        neighbors.add(mutableMapOf('x' to x+1, 'y' to y+1))
    }
    //u
    if(y<lumberColTrans.lastIndex) {
        neighbors.add(mutableMapOf('x' to x, 'y' to y+1))

    }
    //lu
    if(x>0 && y<lumberColTrans.lastIndex) {
        neighbors.add(mutableMapOf('x' to x-1, 'y' to y+1))
    }
    //l
    if(x>0) {
        neighbors.add(mutableMapOf('x' to x-1, 'y' to y))
    }

    //println("x$x y$y" + neighbors)
    var countTrees = 0
    var countLumberYard = 0
    var newStatus = '*'
    neighbors.forEach() {
        if (lumberColTrans[it['y']!!][it['x']!!] == '|') countTrees++
        if (lumberColTrans[it['y']!!][it['x']!!] == '#') countLumberYard++
    }

    if (lumberColTrans[y][x] == '.') {
        if (countTrees>=3) {newStatus = '|'} else newStatus = lumberColTrans[y][x]
    } else if (lumberColTrans[y][x] =='|'){
        if (countLumberYard>=3) {newStatus = '#'} else newStatus = lumberColTrans[y][x]
    } else if (lumberColTrans[y][x] =='#'){
        if( countLumberYard>=1 && countTrees>=1) {newStatus = '#'} else newStatus = '.'
    } else {
        newStatus = lumberColTrans[y][x]
    }


    return newStatus
}

//fun collectNeighbors(lumberCol: Array<Array<Char>>, x: Int, y: Int):Array<Int, Int> {
//
//}



fun printLumberCol(lumberColPrint:Array<Array<Char>>) {
    for (array in lumberColPrint) {
        for (value in array) {
            print("$value ")
        }
        println()
    }
    println()
}






var lumberCol = arrayOf<Array<Char>>()

fun main(args: Array<String>) {
    val lines = input18a2.lines()

    for (i in 0..49) {
        var array = arrayOf<Char>()
        for (j in 0..49) {
            array += '.'
        }
        lumberCol += array
    }


    for (lineIndex in lines.indices) {
        val line = lines[lineIndex]
        for (charIndex in line.indices) {
            val char = line[charIndex]
            lumberCol[lineIndex][charIndex] = char
        }
    }

    lumberCol = runLumber(lumberCol, 1000000000)


    //printLumberCol(lumberCol)

    var countWood = 0
    var countLumber = 0
    for (line in lumberCol) {
        for (char in line) {

            if (char == '|') countWood++

            if (char == '#') countLumber++
        }
    }

    println("Wood: $countWood Lumber: $countLumber Ergebnis: " + countLumber*countWood)


    //printLumberCol(lumberCol)



}