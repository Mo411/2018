//data class Person(val name: String, val age: Int)
//val people = listOf(Person("Paul", 30), Person("Alice", 29), Person("Bob", 31))
//val alice: Person? = findAlice(people)
//
//
//fun findAlice(people: List<Person>): Person? {
//    return people.find { it.name == "Alice" }
//}
//
//
//
//
//
//import java.util.*
//
//fun main(args: Array<String>) {
//    val product = arrayOf("this", "is", "an", "example", "product", "name")
//    val tests = mapOf(
//        arrayOf("example", "product") to true,
//        arrayOf("an", "name") to true,
//        arrayOf("mple", "name") to true,
//        arrayOf("example", "name") to true,
//        arrayOf("this", "prod") to true
//    )
//
//    tests.forEach { (terms, result) ->
//        System.out.println(search(product, terms) == result)
//    }
//}
//
//fun match(product: Array<String>, terms: Array<String>): Boolean {
//    return terms.all { term -> product.any { word -> word.contains(term) } }
//}
