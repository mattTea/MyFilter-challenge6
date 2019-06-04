class MyFilter {

    fun numberIsLessThan5(number: Int): Boolean {
        return number < 5
    }

    fun myFilter(list: List<Int>, numberIsLessThan5: (Int) -> Boolean): MutableList<Int> {
        var result : MutableList<Int> = mutableListOf()
        for (item in list) {
            if (numberIsLessThan5(item)) {
                result.add(item)
            }
        }
        return result
    }
}

