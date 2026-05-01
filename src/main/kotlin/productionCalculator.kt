class ProductionNode(
    val id: ItemId, //Что производим
    val count: Float, //Количество предметов в минуту
    val recipeService: RecipesService,
    val children: List<ProductionNode> = emptyList()
){
    val recipe = recipeService.getRecipesFor(id).first() //По какому рецепту производим

    fun isLeaf(): Boolean = children.isEmpty()
}

class ProductionCalculator(
    private val recipeService: RecipesService
) {
    fun buildTree(itemId: ItemId, amount: Float): ProductionNode{

    }
}