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
    fun `returns 4 from single item list`() {
        val list : List<Int> = listOf(4)
        assertEquals(list, filter.myFilter(list, listOf(), filter::numberIsLessThan5))
    }

    @Test
    fun `returns 3 and 4 from listOf(3, 4)`() {
        val list : List<Int> = listOf(3, 4)
        assertEquals(list, filter.myFilter(list, listOf(), filter::numberIsLessThan5))
    }

    @Test
    fun `returns 3 and 4 from listOf(3, 4, 5)`() {
        val list : List<Int> = listOf(3, 4)
        assertEquals(list, filter.myFilter(listOf(3, 4, 5), listOf(), filter::numberIsLessThan5))
    }
}