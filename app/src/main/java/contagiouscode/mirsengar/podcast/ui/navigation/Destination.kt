package contagiouscode.mirsengar.podcast.ui.navigation

object Destination {
     const val welcome = "welcome"
     const val home = "home"
     const val podcast = "podcast/{id}"
     fun podcast(id : String) : String = "podcast/$id"
}