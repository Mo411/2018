val input04a1 = """
1518-03-09 23:46	Guard #727 begins shift
1518-03-10 00:05	falls asleep
1518-03-10 00:34	wakes up
1518-03-10 00:56	falls asleep
1518-03-10 00:58	wakes up
1518-03-10 23:57	Guard #691 begins shift
1518-03-11 00:10	falls asleep
1518-03-11 00:48	wakes up
1518-03-12 00:04	Guard #1987 begins shift
1518-03-12 00:21	falls asleep
1518-03-12 00:55	wakes up
""".trimIndent()

val input04a2 = """
1518-11-01 00:00	Guard #10 begins shift
1518-11-01 00:05	falls asleep
1518-11-01 00:25	wakes up
1518-11-01 00:30	falls asleep
1518-11-01 00:55	wakes up
1518-11-01 23:58	Guard #99 begins shift
1518-11-02 00:40	falls asleep
1518-11-02 00:50	wakes up
1518-11-03 00:05	Guard #10 begins shift
1518-11-03 00:24	falls asleep
1518-11-03 00:29	wakes up
1518-11-04 00:02	Guard #99 begins shift
1518-11-04 00:36	falls asleep
1518-11-04 00:46	wakes up
1518-11-05 00:03	Guard #99 begins shift
1518-11-05 00:45	falls asleep
1518-11-05 00:55	wakes up
""".trimIndent()

class guards(val items: Map<String, Int>)

fun main(args: Array<String>) {

    var currentGuard = 0
    var guardTimes = mutableMapOf<String, Int>()
//    guardTimes.put("G1059", 5)
//    guardTimes.put("G1059", )
//    println(guardTimes)

    val lines = input04a2.lines()
    for (lineIndex in lines.indices) {
        var timestamp = lines[lineIndex].substringBefore("\t")
        var text = lines[lineIndex].substringAfter("\t")
        if (text.contains("#"))
            currentGuard = text.substringAfter("#").substringBefore(" begins").toInt()
        else if (text.contains("wakes"))
            continue
        else {
            var sleepTime = timestamp.substringAfter(":").toInt()
            var wakeTime = lines[lineIndex+1].substringAfter(":").substringBefore("\t").toInt()
            var currentSleep:Int
            println("Guard: " + currentGuard)
            println("Sleep: " + sleepTime + " Wake: " + wakeTime)
            for (x in sleepTime..wakeTime) {
                if("G"+currentGuard+x !in guardTimes) currentSleep = 0
                //else currentSleep = guardTimes["G"+currentGuard+x]
                //currentSleep++
                //guardTimes.put("G"+currentGuard+x, currentSleep)

            }
        }

        //actualSleep =
        //guardTimes.put(currentGuard + "Test", value++)
        //println(currentGuard)
        //println(timestamp)
    }
}