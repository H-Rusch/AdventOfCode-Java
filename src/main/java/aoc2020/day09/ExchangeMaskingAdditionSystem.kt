package aoc2020.day09


fun findInvalidValue(values: List<Long>, size: Int): Long {
    val subList = values.subList(size, values.size)
    val windows = values.windowed(size)

    return subList.zip(windows)
        .find { !isValid(it.first, it.second) }!!
        .first
}

private fun isValid(value: Long, window: List<Long>): Boolean {
    for (i in window.indices) {
        for (j in window.indices) {
            if (i == j) {
                continue
            }
            if (window[i] + window[j] == value) {
                return true
            }
        }
    }

    return false
}

fun findContiguousSum(target: Long, values: List<Long>): Long {
    var leftIndex = 0
    var rightIndex = 1
    var runningSum: Long = values[leftIndex] + values[rightIndex]

    while (rightIndex < values.size - 1) {
        if (runningSum == target) {
            val sortedSubList = values.subList(leftIndex, rightIndex).sorted()
            return sortedSubList.first() + sortedSubList.last()
        }

        if (runningSum < target) {
            rightIndex++
            runningSum += values[rightIndex]
        } else {
            runningSum -= values[leftIndex]
            leftIndex++
        }
    }

    return -1
}
