val input09_marble:Long = 7158800
val input09_player = 430

var playerScore = mutableMapOf<Int, Long>()

fun main(args: Array<String>) {

    //val startMarble = 0
    var currentMarble = 0L
    var marbleList = mutableListOf<Long>()
    var currentIndex = 0
    marbleList.add(currentMarble)
    //println("[-] " + currentMarble)

    for (x in 1..input09_player) {
        playerScore[x] = 0
    }


    while (currentMarble < input09_marble) {
        for (player in 1..input09_player) {

            if (currentMarble == input09_marble) continue

            //print("[$player] ")

            currentMarble += 1
            //println(currentMarble)

            if (currentMarble % 23 == 0L) {

                currentIndex -= 7
                if(currentIndex < 0 ) currentIndex += marbleList.lastIndex+1
                playerScore[player] = playerScore[player]!!+currentMarble
                playerScore[player] = playerScore[player]!!+marbleList[currentIndex]

                marbleList.removeAt(currentIndex)
                //marbleList.removeAll(listOf(marbleList[currentIndex]))

            } else {

                when (currentIndex) {
                    0 -> currentIndex = 1
                    marbleList.lastIndex -> currentIndex = 1
                    else -> currentIndex += 2
                }

                marbleList.add(currentIndex, currentMarble)
            }

            //print("M: ($currentMarble) I: $currentIndex  ")
            //println(marbleList)


        }

    }

    println(playerScore)
    println(playerScore.maxBy { it.value })

}
