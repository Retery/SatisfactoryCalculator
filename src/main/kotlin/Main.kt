

fun main() {
    val repo = DataRepository()
    val items = repo.loadItems()
    val recipes = repo.loadRecipes()

    showCountDownloads(items, recipes)
    val recipeService = RecipesService(items,recipes)

    val calculator = ProductionCalculator(recipeService)
    val tree = calculator.buildTree("rotor",4f)
    printTree(tree,recipeService)
}