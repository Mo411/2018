val input08a1 = """
2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2
""".trimIndent()

val input08a0 = """
1 1 0 1 9 1 3 2 1 2
""".trimIndent()
/*
A C c c c b b a a a
 */

val input08a9 = """
2 0 1 1 0 2 2 2
""".trimIndent()
/*
A C c c c b b a a a
 */

fun sumMetaData (liste:List<Int>):Int {
    var summe = 0
    if (liste.get(0) == 0) {
        println(liste.subList(2, liste.get(1) + 2))
        println(liste.subList(2, liste.get(1) + 2).sum())
        summe += liste.subList(2, liste.get(1) + 2).sum()
    }
    for (x in 1..liste.get(0)) {
        summe += sumMetaData(liste.subList(1, liste.lastIndex))
    }
    return summe
    

//    if (liste.get(0) == 0) {
//        println(liste.subList(2, liste.get(1)+2))
//        println(liste.subList(2, liste.get(1)+2).sum())
//    return liste.subList(2, liste.get(1)+2).sum()
//    } else {
//        return sumMetaData(liste.subList(1, liste.lastIndex))
//    }
//    return 0
}

fun main(args: Array<String>) {
    val result = sumMetaData(input08a9.split(" ").map { it.toInt()})
    println(result)
}