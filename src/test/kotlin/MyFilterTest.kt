import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyFilterTest {

    private val filter = MyFilter()

    @Test
    fun `numberIsLessThan5 returns true for number 4`() {
        assertTrue(filter.numberIsLessThan5(4))
    }

    @Test
    fun `numberIsLessThan5 returns false for number 5`() {
        assertFalse(filter.numberIsLessThan5(5))
    }

    @Test
    fun `returns 4 from single item array`() {
        val array : Array<Int> = arrayOf(4)
        assertArrayEquals(array, filter.myFilter(array, filter.numberIsLessThan5(4)))
    }

    @Test
    fun `returns 3 and 4 from arrayOf(3, 4)`() {
        val array : Array<Int> = arrayOf(3, 4)
        assertArrayEquals(array, filter.myFilter(array, true))
    }
}