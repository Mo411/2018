val input07a1 = """
Step C must be finished before step A can begin.
Step C must be finished before step F can begin.
Step A must be finished before step B can begin.
Step A must be finished before step D can begin.
Step B must be finished before step E can begin.
Step D must be finished before step E can begin.
Step F must be finished before step E can begin.
""".trimIndent()

fun hasDependencies (act:String, lines:List<String>):Boolean {
    return true
}

fun main(args: Array<String>) {
    val lines = input07a1.lines()
    for (lineIndex in lines.indices) {
        val actualChar = lines[lineIndex].split(" ").get(1)
        //var
        //if(!hasDependencies(actualChar, lines))

    }

    /*
    C -> A   A wait for C
    C -> F   F wait for C
    A -> B   B wait for A
    A -> D   D wait for A
    B -> E   E wait for B
    D -> E   E wait for D
    F -> E   E wait for F

    A wait for: C
    B wait for: A
    C wait for:
    D
    E
    F
    G
    H


    schleife
      als nächstes true
      prüfe alle ob

    C  (A F)
    A  (B D)
    B  (E)
    D  (E)
    F  (E)

    E  (B D F)
    A  (C)
    D  (A)
    F  (C)
    B  (A)
*/




}