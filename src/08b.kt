import kotlin.math.absoluteValue

val input08b2 = """
0 2 5 5
""".trimIndent()


val input08b9 = """
2 0 1 1 0 2 2 2
""".trimIndent()
/*
A C c c c b b a a a
 */



fun sumMetaData3(liste: MutableList<Int>, actSum: Int): Int {
    //println("Liste Start: " + liste)
    var summe = 0
    var hasChild:Boolean = true
    var tempResult:MutableMap<Int, Int> = mutableMapOf()
    //liste = liste.get
    if(liste.get(0) == 0) { //
        hasChild = false
    }

    if (liste.get(0) > 0) {
        for (x in 1..liste.get(0)) {
            //println("Last-Index: "  + liste.lastIndex)
            var tmp = sumMetaData3(liste.subList(2, liste.lastIndex+1), summe)
            liste.set(0, liste.get(0)-1)
            //println("tmp: " + tmp)
            //summe += tmp
            tempResult.put(x, tmp)
        }
    }
    if (liste.get(0) == 0) {
        //println("Liste vorher: " + liste)
        if (hasChild == false) {
            summe += liste.subList(2, liste.get(1) + 2).sum()
        } else {
            var childIndex = 1
            //println(liste)
            val tmpListe: List<Int> = liste.subList(2, liste.get(1) + 2)
            println(tmpListe)
            tmpListe.forEach {it->
                //println(it)
                //println(tempResult)
                if (tempResult.containsKey(it))
                summe += tempResult.get(it)!!
            }
        }

        for (y in liste.get(1) + 1 downTo 0) liste.removeAt(y)
        //println("Liste nachher: " + liste)
    }
    //summe += actSum
    return summe


}

fun main(args: Array<String>) {
    var summe = 0
    val liste = input08a2.split(" ").map { it.toInt() }.toMutableList()
    //println("Input-Liste: " + liste)
    val result = sumMetaData3(liste, summe)
    println("End-Ergebnis: " + result)

}