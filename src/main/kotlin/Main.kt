fun main() {
    val repo = DataRepository()
    val items = repo.loadItems()
    val recipes = repo.loadRecipes()

    showCountDownloads(items, recipes)
}