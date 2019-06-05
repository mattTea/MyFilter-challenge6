class MyFilter {

    fun numberIsLessThan5(number: Int): Boolean {
        return number < 5
    }

    fun <T> myFilter(list: List<T>, numberIsLessThan5: (T) -> Boolean): MutableList<T> {
        val result = mutableListOf<T>()
        list.forEach { if (numberIsLessThan5(it)) { result += it } }
        return result
    }

}

// Make recursive function to remove mutable variable in myFilter()
// (a function that calls itself - possibly tail recursion)

// if a numberIsLessThan5() returns true -> how store or keep in a recursive manner? Examples all show returning a single value

