package basics


// Example class with variables firstName and nationality declared in the primary constructor
class PersonExampleClass(var  firstName: String, lastName: String, var nationality: String = "CH") {
    // lastName, personId and email declared in body
    // lastName get is public (visible everywhere)
    // set of lastname private (only visible inside PersonExampleClass.kt)
    var lastName = lastName
        private set

    // set a value personId which is the hasCode from the firstname + lastname

    // Add a variable email which is initialized as empty string
    var email: String = ""



    // Create a updateNationality function which updates the nationality and returns the same object again


    // Write a getFullName function which returns the firstName with the lastName appended

    // Companion Object: seems like static but is not quite static (at runtime the companion objects are still members
    // of real objects -> use the @JvmStatic annotation to get a real Java-Static methods and fields
    companion object {
        // real JvmStatic create function

        // Extension function for setEmail (not very smart example)

    }

}

//val person = PersonExampleClass.create("asdf", "asdf", "asdf")
//    .updateNationality("ABC")
//    .also { println("The person with name ${it.getFullName()}, email ${it.email} and personId ${it.personId} lastname ist : ${it.lastName}") }.setEmail("thats@new.email")
