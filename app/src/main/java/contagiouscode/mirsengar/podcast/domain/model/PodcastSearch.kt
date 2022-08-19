package contagiouscode.mirsengar.podcast.domain.model

import contagiouscode.mirsengar.podcast.domain.model.Episode

data class PodcastSearch(
          val count : Long ,
          val total : Long ,
          val results : List<Episode> ,
)