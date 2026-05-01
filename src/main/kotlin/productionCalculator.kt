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