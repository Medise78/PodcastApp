package contagiouscode.mirsengar.podcast.di

import android.content.Context
import contagiouscode.mirsengar.podcast.data.datastore.PodcastDataStore
import contagiouscode.mirsengar.podcast.data.exoplayer.PodcastMediaSource
import contagiouscode.mirsengar.podcast.data.network.client.ListenNotesAPIClient
import contagiouscode.mirsengar.podcast.data.network.service.PodcastService
import contagiouscode.mirsengar.podcast.data.service.MediaPlayerServiceConnection
import contagiouscode.mirsengar.podcast.domain.repository.PodcastRepository
import contagiouscode.mirsengar.podcast.domain.repository.PodcastRepositoryImpl
import contagiouscode.mirsengar.podcast.domain.repository.PodcastRepositoryMockImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
     @Provides
     fun provideHttpClient() : OkHttpClient = ListenNotesAPIClient.createHttpClient()
     
     @Provides
     @Singleton
     fun providePodcastService(
               client : OkHttpClient ,
     ) : PodcastService = ListenNotesAPIClient.createPodcastService(client)
     
     @Provides
     @Singleton
     fun providePodcastDataStore(
               @ApplicationContext context : Context ,
     ) : PodcastDataStore = PodcastDataStore(context)
     
     @Provides
     @Singleton
     fun providePodcastRepository(
               service : PodcastService ,
               dataStore : PodcastDataStore ,
     ) : PodcastRepository = PodcastRepositoryImpl(service , dataStore)
     
     
     @Provides
     @Singleton
     fun provideMediaPlayerServiceConnection(
               @ApplicationContext context : Context ,
               mediaSource : PodcastMediaSource ,
     ) : MediaPlayerServiceConnection = MediaPlayerServiceConnection(context , mediaSource)
}