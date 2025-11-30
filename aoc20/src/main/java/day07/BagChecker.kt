package day07

class BagChecker(private val bagMaps: Map<String, Map<String, Int>>) {

    fun countContainedBy(target: String): Int = bagMaps.count { bagContains(target, it.value) }

    private fun bagContains(target: String, containedBags: Map<String, Int>): Boolean {
        if (containedBags.containsKey(target)) {
            return true
        }
        return containedBags.keys.any { bagContains(target, bagMaps[it] ?: emptyMap()) }
    }

    fun sumContainedBags(target: String): Int = sumContainedBags(bagMaps[target] ?: emptyMap())

    private fun sumContainedBags(containedBags: Map<String, Int>): Int {
        if (containedBags.isEmpty()) {
            return 0
        }

        return containedBags
            .map { it.value + it.value * sumContainedBags(bagMaps[it.key] ?: emptyMap()) }
            .sum()
    }
}