

fun main() {
    val repo = DataRepository()
    val items = repo.loadItems()
    val recipes = repo.loadRecipes()

    showCountDownloads(items, recipes)
    val recipeService = RecipesService(items,recipes)

    val calculator = ProductionCalculator(recipeService)
    val tree = calculator.buildTree("iron_plate",1300f)
    printTree(tree,recipeService)
    val total = totalPower(tree,recipeService)
    println("Total power: $total MW")
}