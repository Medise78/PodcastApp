package contagiouscode.mirsengar.podcast.domain.repository

import contagiouscode.mirsengar.podcast.domain.model.PodcastSearch
import contagiouscode.mirsengar.podcast.error.Failure
import contagiouscode.mirsengar.podcast.util.Either

interface PodcastRepository {
     suspend fun searchPodcasts(
               query : String ,
               type : String ,
     ) : Either<Failure , PodcastSearch>
}