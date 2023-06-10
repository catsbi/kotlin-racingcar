package racing.domain

import racing.domain.strategy.Navigator

class Cars(private val values: Set<Car>) : Set<Car> by values {
    constructor(capacity: Capacity) : this(createCarList(capacity))
    constructor(names: List<String>) : this(createCarList(names))

    fun notifyMoving(navigator: Navigator): Unit = values.forEach { it.move(navigator = navigator) }

    companion object {
        const val DELIMITER = ","

        private fun createCarList(names: List<String>): Set<Car> {
            val result = names.distinct()
                .map { it.trim() }
                .mapIndexed { idx, name ->
                    Car(id = idx, name = Name(name))
                }.toSet()

            require(names.size == result.size) {
                "자동차 이름은 중복될 수 없습니다."
            }

            return result
        }

        private fun createCarList(capacity: Capacity): Set<Car> {
            require(capacity > Capacity.ZERO) { "Invalid Size: ${capacity.value} required 0 over size" }
            return buildSet {
                repeat(capacity.value) {
                    add(Car(id = it))
                }
            }

            return capacity.availableRange.map { Car(id = it) }
                .toSet()
        }
    }
}
