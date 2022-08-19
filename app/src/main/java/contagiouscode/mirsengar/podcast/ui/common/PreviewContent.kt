package contagiouscode.mirsengar.podcast.ui.common

import androidx.compose.runtime.Composable
import contagiouscode.mirsengar.podcast.ui.navigation.ProvideNavHostController
import contagiouscode.mirsengar.podcast.ui.theme.PodcastAppTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PreviewContent(
          darkTheme : Boolean = false ,
          content : @Composable () -> Unit ,
) {
     PodcastAppTheme(darkTheme = darkTheme) {
          ProvideWindowInsets {
               ProvideNavHostController {
                    content()
               }
          }
     }
}