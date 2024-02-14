package basics

import com.sun.org.apache.bcel.internal.classfile.JavaClass

class InlineExample {
    companion object {
        // Execute a code block on each item in a collection
        inline fun <T> Collection<T>.each(block: (T) -> T): Collection<T> {
            for (item in this)  print("${block(item)}, ")
            return this
        }

        // Types are erased when inlining a function. Use reified to access the passed type
        inline fun <reified T> MutableList<T>.addString(): Collection<T> {
            val string = "a"
            if (string is T) {
                this.add(string)
            }
            return this
        }
    }
}