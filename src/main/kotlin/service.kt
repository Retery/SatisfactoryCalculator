import kotlin.math.pow

class RecipesService(
    private val items: List<Item>,
    private val recipes: List<Recipe>)
{
    private val itemsMap = items.associateBy { it.id } //Ключ - iron_ore
    // значение - item(id:ItemId,name,isRaw)
    private val machinePower = mapOf(
        "smelter" to 4f,
        "constructor" to 4f,
        "assembler" to 15f,
        "foundry" to 16f,
        "refinery" to 30f,
        "manufacturer" to 55f,
        "converter" to 400f,
        "blender" to 75f
    )
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
    fun getMachine(recipe: Recipe): String {

        return recipe.machine
    }
    fun getMachinePower(recipe: Recipe, percent: Float): Float {
        val power = machinePower.getValue(recipe.machine)
        return if(percent==100f) power
        else power * (percent/100f).pow(1.32f)
    }
}