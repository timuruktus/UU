package trelico.ru.uu.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.dataSources.local.Settings;

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
}
