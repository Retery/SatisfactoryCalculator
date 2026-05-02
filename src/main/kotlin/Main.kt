

fun main() {
    val repo = DataRepository()
    val items = repo.loadItems()
    val recipes = repo.loadRecipes()

    showCountDownloads(items, recipes)
    val recipeService = RecipesService(items,recipes)

    val calculator = ProductionCalculator(recipeService)
    val tree = calculator.buildTree("rotor",13f)
    printTree(tree,recipeService)

    println("\n==Общее количество ресурсов==")
    val totalResources = collectionResources(tree)
    totalResources.forEach {(itemId, amount) ->
        val name = recipeService.getItem(itemId).name
        println("$name $amount")
    }

    val totalEnergy = totalPower(tree,recipeService)
    println("\nTotal power: $totalEnergy MW")

}