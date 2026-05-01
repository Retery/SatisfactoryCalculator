

class ProductionNode(
    val id: ItemId, //Что производим
    val count: Float, //Количество предметов в минуту
    val recipe: Recipe?,
    val children: List<ProductionNode> = emptyList()
){
    fun isLeaf(): Boolean = children.isEmpty()
}

class ProductionCalculator(
    private val recipeService: RecipesService
) {
    fun buildTree(itemId: ItemId, amount: Float): ProductionNode{ //короче если ресурс базовый
        if(recipeService.isRaw(itemId)) {
            return ProductionNode(
                id = itemId,
                count = amount,
                recipe = null,
                children = emptyList()
            )
        }
        val recipes = recipeService.getRecipesFor(itemId)
        val recipe = recipes.first()

        val outputAmount = recipe.output.amount
        val scale = amount / outputAmount

        val children = recipe.input.map { input ->
            val childAmount = input.amount * scale
            buildTree(input.itemId, childAmount)
        }
        return ProductionNode(
            id = itemId,
            count = amount,
            recipe = recipe,
            children = children
        )

    }
}
fun totalPower(
    node: ProductionNode,
    recipeService: RecipesService,
): Float {

    val childrenPower = node.children.fold(0f) { acc, child ->
        acc + totalPower(child, recipeService)
    }

    val recipe = node.recipe ?: return childrenPower

    val outputAmount = recipe.output.amount
    val scale = node.count / outputAmount

    val remainder = scale % 1 //Остаток для формулы потребления
    val number = scale - remainder // Тупо без формулы
    println("${recipeService.getMachine(recipe)} предмет - ${recipe.id} кол-во - ${node.count} - проценты ${remainder*100}")
    val powerPerMachine =recipeService.getMachinePower(recipe,100f)
    val powerMachine = recipeService.getMachinePower(recipe,remainder*100)

    val currentPower = number * powerPerMachine + powerMachine

    return currentPower + childrenPower

}