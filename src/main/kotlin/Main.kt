

fun main() {
    val repo = DataRepository()
    val items = repo.loadItems()
    val recipes = repo.loadRecipes()

    showCountDownloads(items, recipes)
    val recipeService = RecipesService(items,recipes)


    var item = recipeService.getItem("screws")
    println(item)
    while (true){
        val temp = recipeService.getRecipesFor(item.id)
        item = recipeService.getItem(temp.first().input.first().itemId)
        println(item)
        if(recipeService.isRaw(item.id))break
    }
    val calculator = ProductionCalculator(recipeService)
    val tree = calculator.buildTree("screws",60f)
}