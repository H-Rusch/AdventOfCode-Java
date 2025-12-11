package util.matrix

fun <T> transpose(matrix: List<List<T>>): List<List<T>> {
    if (matrix.isEmpty() || matrix.any { it.isEmpty() }) return emptyList()
    val rowCount = matrix.size
    val colCount = matrix[0].size
    require(matrix.all { it.size == colCount }) { "All rows must have the same number of columns" }
    return List(colCount) { col ->
        List(rowCount) { row -> matrix[row][col] }
    }
}
