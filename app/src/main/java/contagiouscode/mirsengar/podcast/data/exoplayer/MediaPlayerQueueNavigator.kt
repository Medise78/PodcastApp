package contagiouscode.mirsengar.podcast.data.exoplayer

import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.TimelineQueueNavigator
import contagiouscode.mirsengar.podcast.data.exoplayer.PodcastMediaSource

class MediaPlayerQueueNavigator(
          mediaSession : MediaSessionCompat ,
          private val mediaSource : PodcastMediaSource ,
) : TimelineQueueNavigator(mediaSession) {
     override fun getMediaDescription(player : Player , windowIndex : Int) : MediaDescriptionCompat {
          return mediaSource.mediaMetadataEpisodes[windowIndex].description
     }
}