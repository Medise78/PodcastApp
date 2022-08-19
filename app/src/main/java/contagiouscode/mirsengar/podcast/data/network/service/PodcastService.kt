package contagiouscode.mirsengar.podcast.data.network.service

import contagiouscode.mirsengar.podcast.data.network.constant.ListenNotesAPI
import contagiouscode.mirsengar.podcast.data.network.model.PodcastSearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PodcastService {
     @GET(ListenNotesAPI.SEARCH)
     suspend fun searchPodcasts(
               @Query("q") query : String ,
               @Query("type") type : String ,
     ) : PodcastSearchDto
}