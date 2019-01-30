package trelico.ru.uu.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import trelico.ru.uu.dataSources.local.AppDatabase;
import trelico.ru.uu.dataSources.local.Settings;
import trelico.ru.uu.dataSources.remote.BackendlessAPI;

import static trelico.ru.uu.dataSources.remote.BackendlessAPI.BASE_URL;

@Module
public class AppModule{


    private Context appContext;

    public AppModule(Context appContext){
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    public Context provideAppContext(){
        return appContext;
    }

    @Provides
    @Singleton
    public Settings provideSettings(){
        return new Settings(appContext);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public BackendlessAPI provideBackendlessAPI(Retrofit retrofit){
        return retrofit.create(BackendlessAPI.class);
    }

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(){
        return Room.databaseBuilder(appContext, AppDatabase.class, "database").build();
    }

}
