package stringcalculator

@JvmInline
value class Number(val value: Int) {
    constructor(value: String) : this(
        requireNotNull(value.toIntOrNull()) {
            throw IllegalArgumentException("Invalid value: $value required number formattable value")
        }
    )

    operator fun plus(target: Number): Number = Number(value + target.value)
    operator fun minus(target: Number): Number = Number(value - target.value)
    operator fun times(target: Number): Number = Number(value * target.value)
    operator fun div(target: Number): Number {
        if (target.value == 0) {
            throw ArithmeticException("0으로 나눌 수 없습니다.")
        }

        return Number(value / target.value)
    }
}
