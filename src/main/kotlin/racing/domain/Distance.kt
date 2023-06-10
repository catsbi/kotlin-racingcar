package racing.domain

@JvmInline
value class Distance(val value: Long) : Comparable<Distance> {

    operator fun plus(target: Distance): Distance = Distance(value + target.value)

    override operator fun compareTo(other: Distance): Int = value compareTo other.value

    companion object {
        val ZERO = Distance(0L)
    }
}
