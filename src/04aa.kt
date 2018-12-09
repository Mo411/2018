
var sleepTable = mutableMapOf<Int, MutableList<Int>>()
var currentGuard = 0

fun main(args: Array<String>) {
    val lines = input04a2.lines()
    var sleepStart = 0
    var sleepEnd = 0

    var hoursGuard = 0
    var sleepyGuard = 0

    for (lineIndex in lines.indices) {
        println(lines[lineIndex])
        var timestamp = lines[lineIndex].substringBefore("\t")
        var text = lines[lineIndex].substringAfter("\t")
        if (text.contains("#"))
            currentGuard = text.substringAfter("#").substringBefore(" begins").toInt()
        else if (text.contains("asleep"))
            sleepStart = timestamp.substringAfter(":").toInt()
        else {
            sleepEnd = timestamp.substringAfter(":").toInt()
//
            for (x in sleepStart..sleepEnd) {
                if (sleepTable.containsKey(x)) {
                    var addedList = sleepTable.get(x)
                    if (addedList != null) {
                        addedList.add(currentGuard)
                    }
                    sleepTable.put(x, addedList!!)
                } else {
                    sleepTable.put(x, mutableListOf(currentGuard))
                }
            }
        }
    }

    println(sleepTable)

//    for (x in 0..59) {
//
//    }
    sleepTable.forEach { t, u ->
        print(t)
        println(u)
    }

    sleepTable.flatMap { it.value }

    println(sleepTable)


}