package contagiouscode.mirsengar.podcast.ui.podcast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import contagiouscode.mirsengar.podcast.R
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun PodcastImage(
     url : String ,
     modifier : Modifier = Modifier ,
     aspectRatio : Float = 1f ,
) {
     val imagePainter = rememberImagePainter(url)
     
     Box(
          modifier
               .clip(MaterialTheme.shapes.medium)
               .aspectRatio(aspectRatio)
               .background(MaterialTheme.colors.onBackground.copy(alpha = 0.08f))
     ) {
          Image(
               painter = imagePainter ,
               contentDescription = stringResource(R.string.podcast_thumbnail) ,
               contentScale = ContentScale.Crop ,
               modifier = Modifier.fillMaxSize() ,
          )
          
          Icon(
               painter = painterResource(R.drawable.ic_microphone) ,
               contentDescription = stringResource(R.string.podcast_thumbnail) ,
               tint = MaterialTheme.colors.onBackground.copy(alpha = 0.14f) ,
               modifier = Modifier
                    .size(48.dp)
                    .align(Alignment.Center) ,
          )
     }
}