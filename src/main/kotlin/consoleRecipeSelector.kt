fun consoleRecipeSelector(
    itemId: ItemId,
    recipes: List<Recipe>,
    recipesService: RecipesService
):Recipe{
    val itemName = recipesService.getItem(itemId).name
    println("Для $itemName есть следующие рецепты:")
    recipes.forEachIndexed { index, recipe ->
        println("${index + 1}. ${recipe.name} ${recipe.machine}")
    }

    println("Выберите номер рецепта:")
    var choice: Int = -1
    while (choice !in 0 until recipes.size){
        val input = readln()
        choice = input.toIntOrNull()?.minus(1) ?: -1
        if (choice !in 0..recipes.size)
            println("Выберите номер рецепта из списка")
    }
    return recipes[choice]
}