import fancy.InlineExample.Companion.addString
import basics.PersonExampleClass
import basics.PersonExampleClass.Companion.setEmail
import basics.StringInterface
import basics.UserDataClass
import fancy.InlineExample.Companion.each


fun main(args: Array<String>) {
    //Print Hello World ------------------------------------------------------------------------------------------------
    println("hello world")

    // Variables: you have 5 dollars on your account. Now you buy a cookies for 1 dollar. Print in a single statement
    // the price and your account balance before and after your purchase
    var accountBalance = 5

    val priceCookie = 1
    accountBalance -= priceCookie

    // Print the following line: I bought a cookie for 1 dollar which leaves me with 4. Before I had 5 dollars
    println("I bought a cookie for $priceCookie dollar which leaves me with $accountBalance. Before I had ${accountBalance + priceCookie} dollars")

    // Types: Set the types of the variables
    val a: Int = 1000
    val b: String = "log message"
    val c: Double  = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'

    //Collections ------------------------------------------------------------------------------------------------------
    // -- List: ["red", "green", "blue"] --
    val colors = listOf("red", "green", "blue")
    println(colors) // [red, green, blue]


    // -- create a mutable list of Strings which holds animal names. --
    val animals = mutableListOf<String>()
    // Add a "dog" and an "elephant" to the list
    animals.add("dog")
    animals.add("elephant")
    println(animals) // ["dog", "elephant"]


    // -- Sets are unordered and unique --
    val colorSet = setOf("red", "green", "blue", "red")
    println(colorSet) // [red, green, blue]


    // -- Create a set of the employer addresses. Then check if "Bern" is in this set. Print the result to the terminal.
    val employerAddress = listOf("Bern", "Zürich", "Bern", "Geneva", "Zug", "Zürich")
    val cities = employerAddress.toSet()
    if ("Bern" in cities) println("Bern was found in the set $cities")


    // -- Maps: find values by unique keys
    // Map the inhabitants to the cities: bern -> 133115, zürich -> 402762, geneva -> 198978
    val population = mapOf(
        "bern" to 133115,
        "zürich" to 402762,
        "geneva" to 198978)

    // Print for each city: city has XXXX inhabitants
    population.forEach {
        println("${it.key} has ${it.value} inhabitants")
    }
    // Access by key: print the population of Zürich
    println("Zürich has ${population["zürich"]} inhabitants")

    // Control Flow ----------------------------------------------------------------------------------------------------
    // -- Write an if else statement where variable is printed if it is a color contained in the colors set
    val myColor  = "white"

    // -- If yellow print something, if the color is in the set report it was found, else report color does not exist
    if (myColor == "yellow") {
        println("the color is yellow")
    } else if (myColor in colorSet) {
        println("The color $myColor was found")
    } else {
        println("the color is not known")
    }

    // -- Check for every number in the range 1 to 10 if the number is a 1 or a 2 and report it. Else say the color is
    //  unknown. Hints: For (print when -> for i in range) and println(when (i))
    for (i in 1..4) {
        println( when(i) {
            1-> "1"
            2 -> "2"
            else -> "not found"
        })
    }


    // -- Do the same with a while loop but if the number 8 is reached break out of the loop
    var ii = 0
    while (ii < 10) {
        when (ii) {
            1,2 -> println("$ii was found")
            5 -> break
            else -> println("not found")
        }
        ii++
    }





    // Functions -------------------------------------------------------------------------------------------------------
    // Define a function which prints "Hello World"
    fun hello() {
        println("hello world")
    }
    hello()

    // -- Single expression functions: Create a single expression function which takes 2 strings and concatenates them
    // together. Provide a default parameter for the second parameter
    fun concatenateString(string1: String, string2: String): String {
        return string1 + string2
    }

    // Overload the concatenateString function to take 3 parameters. Use even a more concise function expression.
    fun concatenateString(string1: String, string2: String, string3: String) = string1 + string2 + string3

    println("Für ${concatenateString("Pausen", "brot")} steig ich ins Boot")
    println("Für ein ${concatenateString("Pausen", "brot", "fest")} geb ich den Rest")

    // The following function creates strings stating that bob eats all combinations of breads and jams.
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

    // -- Lambda functions: Use a lambda function to create the same strings but write the lambda function using just a
    // single line: Hint: lambda function with two times .map() and once .flatten()
    // With lambda function and two times map & flatten the array
    val bobsBreakfastFast = breads.map { bread -> jams.map { jam -> "Bob eats $bread with $jam-jam on top" } }.flatten()
    println("Fast eating Bob eats: $bobsBreakfastFast")

    // Functions are a type and can be stored in a variable (store eatingFunction which returns the string as a value)
    val eatingFunction: (String, String ) -> String  = {bread, jam -> "Bob eats $bread with $jam-jam on top"}
    println("Another fast eating Bob eats: \n ${breads.map { bread -> jams.map { jam -> eatingFunction(bread, jam) } }.flatten()}")

    // list.map explanation with numbers [1,2,3]
    val numbersList = listOf(1,2,3)
    println(numbersList.map { number -> number.times(2) })
    println(numbersList)
    // print [2,4,6]


    // Classes ---------------------------------------------------------------------------------------------------------
    // Standard Class
    // -> See the basics/PersonExampleClass.kt
    // Get an instance of the PersonExampleClass (Bob Marley) and set the email to reggae@guitar.com using
    val bob = PersonExampleClass("Bob", "Marley").apply{this.setEmail("reggae@guitar.com")}

    // Show that the bob.lastName property can only be retrieved but not set
    bob.firstName = "asdf"

    // -- Data Class with toString, equals and hash function
    val user = UserDataClass("Alex", 1)
    val secondUser = UserDataClass("Alex", 1)
    // Create a thirdUser also with name Alex but with id 2
    val thirdUser = UserDataClass("Alex", 2)


    // Compares user to second user
    println("user == secondUser: ${user == secondUser}")
    // user == secondUser: true

    // Compares user to third user
    println("user == thirdUser: ${user == thirdUser}")
    // user == thirdUser: false

    // With to PersonExampleClasses this works too not?
    val marlen = PersonExampleClass("Marlen", "Sample")
    println("is bob and marlen the same: ${bob == marlen}")

    // Why is this compare nice? (example with Compare(i:Int) class
    class Compare(i:Int)
    println(Compare(1) == Compare(1)) //false

    // -- Inheritance
    // Create an open BaseInt CLass with single property number
    open class BaseInt(var number: Int)
    // Create a IntAndString Class which inherits from the BaseInt class but has an additional parameter string
    class IntAndString(number: Int, var string: String): BaseInt(number)
    // Create an instance of the IntAndString class
    val sampleIntString = IntAndString(1, "asfd")
    println("The sampleIntString contains the number ${sampleIntString.number} and string ${sampleIntString.string}")

    // -- Interface : See the StringInterface (StringInterface.kt)
    // Create a StringAndInt class which implements the StringInterface
    class StringAndInt(override val string: String): StringInterface {
        override fun printStringNTimes(nPrints: Int) {
            for (i in 1..nPrints) {
                println("the string is $string")
            }
        }
    }
    StringAndInt("bla").printStringNTimes(2)

    // NullSafety ------------------------------------------------------------------------------------------------------

    // String Not null
    val notNullString: String = "not null"
    var nullString: String? = "still not null but maybe now?"

    // Make the nullString randomly null
    nullString = if ((1..10).random() < 5) {
        "not null"
    } else null

    // Print something if the nullString is indeed null
    if (nullString.isNullOrBlank()) {
        println("the string is indeed null")
    }
    // Create nullObject holding an Int? and a String
    val nullObject = object {
        var nullInt: Int? = null
        var string: String = "asdf"
    }

    // Null safe operations using ? - use the Int.times() function on the nullObject and return an Int?
    val calc: Int? = nullObject.nullInt?.times(2)
    // Elvis Operator - Same but return should have type Int
    val calcNotNull: Int = nullObject.nullInt?.times(2) ?:100




    //------------------------------------------------------------------------------------------------------------------
    // Fancy Part ------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------

    // Extension functions ---------------------------------------------------------------------------------------------
    // Extend the PersonExampleClass with a function that maps the personId to the email address
    fun PersonExampleClass.mapIdToEmail() = mapOf(personId to email)
    println("The email of ${bob.firstName} is ${bob.mapIdToEmail()[bob.personId]}")


    // Generics --------------------------------------------------------------------------------------------------------
    // Create a class with one property which is a list of a generic type <T>
    class AnyValue<T>(list: List<T>) {
        var myList: List<T?> = list
    }

    // create a function getOddItems which returns from a list a generic type the odd elements
    fun <T> getOddItems(list: List<T>): List<T> {
        return list.filterIndexed { index, _ -> index % 2 == 1 }
    }

    val rivers = AnyValue(listOf("Aare", "Rhone", "Nil", "Limmat"))
    val someNumbers = AnyValue(listOf(0,1,2,3))

    println("Rivers has the following odd items ${getOddItems(rivers.myList)}")
    println("someNumbers has the following odd items ${getOddItems(someNumbers.myList)}")

    // Inline functions ------------------------------------------------------------------------------------------------
    // Functions can be inlined: meaning at compile time they are placed in the code -> InlineExample.kt

    // Create an inline function which executes a code block on every item  in a collection.
    // This code block should multiply a number in a list with a random number
    // Hint: Use the listOf().each( block = {}) method

    println(" was a randomly multiplied list of ${listOf(1,2,3).each { it.times(2) } }}")

    // --Reified inline functions -> InlineExample.kt
    println("Append some strings: ${mutableListOf("z", "y").addString()}")


    // --Scope functions
    // Apply: change the string parameter of the nullObject and print it to the console
    nullObject.apply { this.nullInt = 123 }.also { println("The nullObject int is now: ${it.nullInt}") }
    // Use .let to add 1000 to the nullObject.nullInt parameter and print afterwards the new number to the console using
    // also
    nullObject.let { it.nullInt?.plus(1000) ?:99 }.also { println("result is $it") }



    // Infix functions -------------------------------------------------------------------------------------------------
    // Create a class Assertion which takes a generic target.
    // Provide an infix function isDifferentFrom(other: T) which compares two objects
    class Assertion<T>(private val target: T) {
        infix fun isDifferentFrom(other: T): Boolean {
            return target != other
        }
    }

    val a1 = Assertion(1)
    println("a1 is different from 2? ${a1 isDifferentFrom  2 }")




}