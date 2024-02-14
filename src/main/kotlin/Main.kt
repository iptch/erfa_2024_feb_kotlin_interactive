import basics.InlineExample.Companion.addString
import basics.InlineExample.Companion.each
import basics.PersonExampleClass
import basics.PersonExampleClass.Companion.setEmail
import basics.StringInterface
import basics.UserDataClass


fun main(args: Array<String>) {
    //Print Hello World ------------------------------------------------------------------------------------------------
    println("Hello World!")

    // Variables: you have 5 dollars on your account. Now you buy a cookies for 1 dollar. Print in a single statement
    // the price and your account balance before and after your purchase
    var accountBalance = 5

    val priceCookie = 1
    accountBalance -= priceCookie

    println("I bought a cookie for $priceCookie money which leaves me with $accountBalance. Before I had " +
            "${accountBalance + priceCookie} dollars")

    // Types: Set the types of the variables
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'

    //Collections ------------------------------------------------------------------------------------------------------
    // List
    val colors = listOf("red", "green", "blue")
    println(colors) // [red, green, blue]

    // create a mutable list of Strings which holds animal names. Add a "dog" and a "elephant" to the list
    var animals: MutableList<String> = mutableListOf()
    animals.add("dog")
    animals.add("elephant")

    // Sets are unordered and unique
    val colorSet = setOf("red", "red", "green", "blue")
    println(colorSet) // [red, green, blue]

    // create a set of the employer addresses. Then check if "Bern" is in this set. Print the result to the terminal.
    val employerAddress = listOf("Bern", "Zürich", "Bern", "Geneva", "Zug", "Zürich")
    val cities = employerAddress.toSet()
    println("Is Bern part of the set? ${"Bern" in cities}")

    // Maps: find values by unique keys
    var population = mapOf(
        "bern" to 133115,
        "zürich" to 402762,
        "geneva" to 198978)
    population.forEach { populationMap ->
        println("${populationMap.key} has ${populationMap.value} inhabitants")
    }
    // print the population of Zürich
    println(population["Zürich".lowercase()])

    // Control Flow ----------------------------------------------------------------------------------------------------
    // Write an if else statement where variable is printed if it is a color contained in the colors set
    val myColor  = "green" //readLine()

    if (myColor == "yellow") {
        println("blaaa")
    } else if (myColor in colorSet) {
        println("$myColor was found")
    } else {
        println("$myColor does not exist")
    }

    //For (print when -> for i in range)
    for (i in 1..10){
        println(when (i) {
            1 -> "Its a one"
            2 -> "Its a two"
            else -> "$i is unkown"
        })
    }

    // while
    var ii = 0
    while (ii < 10){
        println(when (ii) {
            1 -> "Its a one"
            2 -> "Its a two"
            else -> "$ii is unkown"
        })
        ii += 1
        when {
            ii > 8 -> break
            else -> continue
        }
    }




    // Functions -------------------------------------------------------------------------------------------------------
    // Define a function which prints "Hello World"
    fun hello() {
        println("Hello World")
    }
    hello()

    //single expression functions (2 strings with default parameter)
    fun concatenateString(string1: String, string2: String = "Bla"): String {
        return string1+string2
    }
    fun concatenateString(string1: String, string2: String, string3: String): String = string1 + string2 + string3
    println("Für ${concatenateString("Pausen", "brot")} steig ich ins Boot")
    println("Für ein ${concatenateString("Pausen", "brot", "fest")} geb ich den Rest")

    //Use a lambda function to Bob eat all the combinations with bread, butter and ham
    val breads = listOf("white bread", "whole grain bread")
    val jams = listOf("strawberry", "raspberry")

    fun makeBobEatBread(breads: List<String>, jams: List<String>): List<String> {
        val bobEats = mutableListOf<String>()
        for (bread in breads) {
            for (jam in jams) {
                bobEats.add("Bob eats $bread with $jam-jam on top")
            }
        }
        return bobEats
    }
    println("Slow eating Bob eats: " + makeBobEatBread(breads, jams))

    // With lambda function and two times map & flatten the array
    val bobsBreakfastFast = breads.map { bread -> jams.map { jam -> "Bob eats $bread with $jam-jam on top"} }.flatten()
    println("Fast eating Bob eats: $bobsBreakfastFast")

    // Functions are a type and can be stored in a variable (store eatingFunction as a value)
    val eatingFunction: (String, String) -> String = {bread, jam -> "Bob eats $bread with $jam-jam on top"}
    println("Another fast eating Bob eats: \n ${breads.map { bread -> jams.map { jam -> eatingFunction(bread, jam) } }.flatten()}")

    // list.map explanation with numbers [1,2,3]
    val numbers = listOf(1,2,3)
    println(numbers.map { it * 2 }) // [2,4,6]


    // Classes ---------------------------------------------------------------------------------------------------------
    // Standard Class
    // -> See the basics/PersonExampleClass.kt
    // Get an instance of the PersonExampleClass (Bob Marley) and set the email to reggae@guitar.com
    val bob = PersonExampleClass("bob", "Marley").apply {setEmail("reggae@guitar.com")}
    // Get the full name and store it in a variable
    val name = bob.getFullName()
    val bobLastName = bob.lastName


    // Data Class with toString, equals and hash function
    val user = UserDataClass("Alex", 1)
    val secondUser = UserDataClass("Alex", 1)
    val thirdUser = UserDataClass("Alex", 2)

    // Compares user to second user
    println("user == secondUser: ${user == secondUser}")
    // user == secondUser: true

    // Compares user to third user
    println("user == thirdUser: ${user == thirdUser}")
    // user == thirdUser: false

    val marlen = PersonExampleClass("Marlen", "Sample")
    println("is bob and marlen the same: ${bob == marlen}")

    // Why is this compare nice? (example with Compare(i:Int) class
    class Compare(i:Int)
    println("Do we compare the data of the Compare class? ${Compare(1) == Compare(1)}") // false

    // Inheritance (an open Int class and a int&String class)
    open class BaseInt(var number: Int)
    class IntAndString(number: Int, var string: String): BaseInt(number)

    val sampleIntString = IntAndString(1,"two")
    println("The sampelIntString contains the number ${sampleIntString.number} and string ${sampleIntString.string}")

    // Interface (StringInterface.kt)
    class StringAndInt(override var string: String) : StringInterface {
        override fun printStringNTimes(n: Int) {
            for (i in 1 .. n) {
                println("$i: string is: $string")
            }
        }
    }
    StringAndInt("bla").printStringNTimes(2)

    // NullSafety ------------------------------------------------------------------------------------------------------

    // String Not null
    val notNullString: String = "not null"
    var nullString: String? = "still not null but maybe now?"

    // Make the nullString randomly null
    if ((0..9).random() < 5) {
        nullString = null
    }

    // Check for null
    if (nullString.isNullOrEmpty()) {
        println("now the nullString is null $nullString")
    }

    // Create nullObject holding an Int? and a String
    val nullObject = object {
        var nullInt: Int? = null
        var string: String = "asdf"
    }

    // Null safe operations using ? - use the Int.times() function on the nullObject and return a Int?
    val nullMultiplied: Int? = nullObject.nullInt?.times(100)

    // Elvis Operator - Same but return should have type Int
    val multiplied: Int = nullObject.nullInt?.times(100) ?: 199




    //------------------------------------------------------------------------------------------------------------------
    // Fancy Part ------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    // Extension functions ---------------------------------------------------------------------------------------------
    // Extend the PersonExampleClass with a function that maps the name to the email address
    fun PersonExampleClass.mapIdToEmail() = mapOf( this.personId to this.email)
    println("The email of ${bob.firstName} is ${bob.mapIdToEmail()[bob.personId]}")


    // Generics --------------------------------------------------------------------------------------------------------
    class AnyValue<T>(list: List<T>) {
        var anyList: List<T?> = list
    }

    fun <T> getOddItems(list: List<T>): List<T> {
        return list.filterIndexed { index, _ -> index % 2  == 1 }
    }

    val rivers = AnyValue(listOf("Aare", "Rhone", "Nil", "Limmat"))
    val someNumbers = AnyValue(listOf(0,1,2,3))

    println("Rivers has the following odd items ${getOddItems(rivers.anyList)}")
    println("someNumbers has the following odd items ${getOddItems(someNumbers.anyList)}")

    // Inline functions ------------------------------------------------------------------------------------------------
    // Functions can be inlined: meaning at compile time they are placed in the code
    // Create an inline function which executes a code block on every item  in a collection

    println(" was a randomly multiplied list of ${listOf(1,2,3,4).each ( block = {it.times((1..10).random()) }) }")

    // reified inline functions
    println("Append some strings: ${mutableListOf("z", "y").addString()}")


    // Scope functions
    // Apply: change the paramters of the nullObject
    println(nullObject.apply {
        string = "hallo new world"
    }.string)

    // let and also
    println(nullObject.let { it.nullInt?.plus(1000) ?: -1 }.also { println("We calculated a new number $it") })



    // Infix functions -------------------------------------------------------------------------------------------------
    class Assertion<T>(private val target: T) {
        infix fun isEqualTo(other: T): Boolean {
            return this == other
        }

        infix fun isDifferentFrom(other: T): Boolean {
            return this != other
        }
    }

    val a1 = Assertion(1)
    println("a1 is different from 2? ${a1 isDifferentFrom 2 }")









    fun copy(from: Array<out Any>, to: Array<Any>){
        assert(from.size == to.size)
        for (i in from.indices)
            to[i] = from[i]
    }
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    copy(ints, any)

}