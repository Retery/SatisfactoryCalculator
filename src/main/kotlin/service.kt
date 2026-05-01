class RecipesService(
    private val items: List<Item>,
    private val recipes: List<Recipe>)
{
    private val itemsMap = items.associateBy { it.id } //Ключ - iron_ore
    // значение - item(id:ItemId,name,isRaw)

    fun isRaw(itemId: ItemId): Boolean {
        return itemsMap[itemId]?.isRaw ?: false
    }

    fun getRecipesFor(itemId: ItemId): List<Recipe> {
        return recipes.filter { recipe ->
            recipe.output.itemId == itemId
        }
    }
    fun getItem(itemId: ItemId): Item{
        return itemsMap.getValue(itemId)
    }
}