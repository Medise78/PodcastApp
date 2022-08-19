package contagiouscode.mirsengar.podcast.domain.repository

import contagiouscode.mirsengar.podcast.data.datastore.PodcastDataStore
import contagiouscode.mirsengar.podcast.data.network.service.PodcastService
import contagiouscode.mirsengar.podcast.domain.model.PodcastSearch
import contagiouscode.mirsengar.podcast.error.Failure
import contagiouscode.mirsengar.podcast.util.Either
import contagiouscode.mirsengar.podcast.util.left
import contagiouscode.mirsengar.podcast.util.right

class PodcastRepositoryImpl(
          private val service : PodcastService ,
          private val dataStore : PodcastDataStore ,
) : PodcastRepository {
     companion object {
          private const val TAG = "PodcastRepository"
     }
     
     override suspend fun searchPodcasts(
               query : String ,
               type : String ,
     ) : Either<Failure , PodcastSearch> {
          return try {
               val canFetchAPI = dataStore.canFetchAPI()
               if (canFetchAPI) {
                    val result = service.searchPodcasts(query , type).asDomainModel()
                    dataStore.storePodcastSearchResult(result)
                    right(result)
               }
               else {
                    right(dataStore.readLastPodcastSearchResult())
               }
          }
          catch (e : Exception) {
               left(Failure.UnexpectedFailure)
          }
     }
}