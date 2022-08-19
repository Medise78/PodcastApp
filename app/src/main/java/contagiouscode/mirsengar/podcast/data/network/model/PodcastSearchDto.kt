package contagiouscode.mirsengar.podcast.data.network.model

import contagiouscode.mirsengar.podcast.domain.model.PodcastSearch

data class PodcastSearchDto(
          val count : Long ,
          val total : Long ,
          val results : List<EpisodeDto> ,
) {
     fun asDomainModel() = PodcastSearch(
               count ,
               total ,
               results.map { it.asDomainModel() }
     )
}
