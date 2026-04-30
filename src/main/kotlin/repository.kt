import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import java.io.File

class DataRepository {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    fun loadItems(): List<Item> {
        val itemsJson = File("src/main/kotlin/items.json").readText()
        return json.decodeFromString<List<Item>>(itemsJson)
    }

    fun loadRecipes(): List<Recipe> {
        val recipesJson = File("src/main/kotlin/recipes.json").readText()
        return json.decodeFromString<List<Recipe>>(recipesJson)
    }
}