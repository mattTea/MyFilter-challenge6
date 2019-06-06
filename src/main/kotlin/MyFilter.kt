class MyFilter {

    fun numberIsLessThan5(number: Int): Boolean {
        return number < 5
    }

    fun <T> List<T>.tail() = drop(1)
    fun <T> List<T>.head() = first()

    tailrec fun <T> myFilter(list: List<T>, result: List<T>, numberIsLessThan5: (T) -> Boolean): List<T> {
        return if (list.isEmpty()) {
            result
        } else {
            myFilter(list.tail(), if (numberIsLessThan5(list.head())) {
                result + listOf(list.head())
            } else {
                result
            }, numberIsLessThan5)
        }
    }
}
