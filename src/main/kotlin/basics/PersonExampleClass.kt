package basics

import basics.PersonExampleClass.Companion.setEmail

// Example class with variables firstName and nationality declared in the primary constructor
class PersonExampleClass(var  firstName: String, lastName: String, var nationality: String = "CH") {
    // lastName, personId and email declared in body
    // lastName get is public (visible everywhere)
    // set of lastname private (only visible inside PersonExampleClass.kt)
    var lastName = lastName
        private set

    val personId: Int = (firstName + lastName).hashCode()
    var email: String = ""


    fun updateNationality(countryCode: String) {
        nationality = countryCode
    }

    fun getFullName() = firstName+lastName

    // Companion Object: seems like static but is not quite static (at runtime the companion objects are still members
    // of real objects -> use the @JvmStatic annotation to get a real Java-Static methods and fields
    companion object {
        // static create function
        @JvmStatic
        fun create(firstName: String, lastName: String, nationality: String) = PersonExampleClass(firstName,lastName, nationality)

        // Extension function for setEmail (not very smart example)
        fun PersonExampleClass.setEmail(email: String) {
            this.email = email
        }
    }

}

val person = PersonExampleClass.create("asdf", "asdf", "asdf")
