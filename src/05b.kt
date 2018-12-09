fun main(args: Array<String>) {

    var string = input05a1

    var c:Char = 'A'
    var smallest = 999999


    while (c <= 'Z') {

        var finished = false
        var charIndex = 0

        val cs = c + 32
        var tmpString2 = string.replace("$c", "")
        var tmpString = tmpString2.replace("$cs", "")
        print("$c ")
//var tmpString2 = string.replace("A", "")
//    var tmpString = tmpString2.replace("a", "")

//    var testString = "abc"
//    println("before: " + testString)
//    testString = testString.replace("a", "")
//    println("after: " + testString)

        while (!finished) {
            //println("CurrentIndex: " + charIndex)
            if (charIndex + 1 == tmpString.length) finished = true
            else if (equalUpLow(tmpString[charIndex], tmpString[charIndex + 1])) {
                //println(string)
                tmpString = tmpString.removeRange(charIndex, charIndex + 2)
                //println(string)
                if (charIndex > 1) charIndex -= 2
                //charIndex = 0
            } else charIndex++
        }
        println("Smallest war: " + smallest + " Aktuell ist: " + tmpString.length)
        if (tmpString.length < smallest) smallest = tmpString.length

        c+=1
    }
//
    println(smallest)

}