import kotlinx.serialization.Serializable
typealias ItemId = String

@Serializable
data class ItemAmount(
    val itemId: ItemId,
    val amount: Float
)
@Serializable
data class Item(
    val id: ItemId,
    val name: String,
    val isRaw: Boolean
) {
}
@Serializable
data class Recipe(
    val id: String,
    val input: List<ItemAmount>,
    val output: ItemAmount,
    val machine: String
){}

