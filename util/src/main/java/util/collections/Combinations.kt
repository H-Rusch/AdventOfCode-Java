package util.collections

fun <T> pairwise(collection: Collection<T>): Sequence<Pair<T, T>> = sequence {
    for ((i, element) in collection.withIndex()) {
        for ((j, other) in collection.withIndex()) {
            if (i != j) {
                yield(element to other)
            }
        }
    }
}

