import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyFilterTest {

    private val filter = MyFilter()

    @Test
    fun `returns 4 from single item array`() {
        val array : Array<Int> = arrayOf(4)
        assertArrayEquals(array, filter.myFilter(array, filter.numberIsLessThan5(4)))
    }
}