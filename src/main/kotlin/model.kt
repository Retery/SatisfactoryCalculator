typealias ItemId = String
data class ItemAmount(
    val itemId: ItemId,
    val amount: Float
)

data class Item(
    val id: ItemId,
    val name: String,
    val isRaw: Boolean
) {
}

data class Recipe(
    val id: String,
    val input: List<ItemAmount>,
    val output: ItemAmount,
    val machine: String
){}

