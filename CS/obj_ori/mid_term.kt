
class Basket {
    private var buyMap = mutableListOf<String>()

    fun add(item: String) {
        this.buyMap.add(item)
    }

    fun calcPrice(priceList: MutableMap<String, Int>) : Int {
        var totalPrice = 0
        this.buyMap.forEach { item ->
            if (priceList.containsKey(item)) {
                totalPrice += priceList[item] as Int
            }
        }
        return totalPrice
    }
}

fun main(args: Array<String>) {
    val basket = Basket()
    basket.add("juice")
    basket.add("bagle")
    basket.add("umai")
    basket.add("thunder")
    println(basket.calcPrice(mutableMapOf("juice" to 100, "bagle" to 300, "umai" to 10, "thunder" to 30)))
    

}

