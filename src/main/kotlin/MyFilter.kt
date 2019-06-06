class MyFilter {

    fun numberIsLessThan5(number: Int): Boolean {
        return number < 5
    }

    fun <T> List<T>.tail() = drop(1)
    fun <T> List<T>.head() = first()

    fun <T> myFilter(list: List<T>, numberIsLessThan5: (T) -> Boolean): List<T> {
        return if (list.isEmpty()) {
            listOf()
        } else {
            // if first element isLessThan5 return first element + run myFilter on remainder of list
            if (numberIsLessThan5(list.head())) {
                listOf(list.head()) + myFilter(list.tail(), numberIsLessThan5)
            // else run myFilter on remainder of list without returning first element
            } else {
                myFilter(list.tail(), numberIsLessThan5)
            }
        }
    }
}
