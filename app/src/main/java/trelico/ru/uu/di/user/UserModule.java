package trelico.ru.uu.di.user;

import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.data_sources.local.AppDatabase;
import trelico.ru.uu.data_sources.local.dao.UserDAO;
import trelico.ru.uu.di.scopes.PerFeature;

@Module
public class UserModule{


    @Provides
    @PerFeature
    UserDAO provideUserDAO(AppDatabase appDatabase){
        return appDatabase.userDAO();
    }
}
