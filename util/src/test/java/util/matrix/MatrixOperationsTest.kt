package util.matrix

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MatrixOperationsTest {

    @Nested
    inner class TransposeTest {

        @Test
        fun `transpose square matrix`() {
            val input = listOf(
                listOf(1, 2),
                listOf(3, 4)
            )
            val expected = listOf(
                listOf(1, 3),
                listOf(2, 4)
            )

            val result = transpose(input)

            assertThat(result).isEqualTo(expected)
        }

        @Test
        fun `transpose rectangular matrix`() {
            val input = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, 6)
            )
            val expected = listOf(
                listOf(1, 4),
                listOf(2, 5),
                listOf(3, 6)
            )

            val result = transpose(input)

            assertThat(result).isEqualTo(expected)
        }

        @Test
        fun `transpose empty matrix`() {
            val result = transpose(emptyList<List<Int>>())

            assertThat(result).isEmpty()
        }

        @Test
        fun `transpose matrix with empty rows`() {
            val input = listOf(emptyList<Int>(), emptyList<Int>())

            val result = transpose(input)

            assertThat(result).isEmpty()
        }

        @Test
        fun `throws on misformed matrix`() {
            val input = listOf(
                listOf(1, 2),
                listOf(3)
            )

            assertThatThrownBy({ transpose(input) })
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }
}
