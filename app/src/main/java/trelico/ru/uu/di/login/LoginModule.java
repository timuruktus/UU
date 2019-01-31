package trelico.ru.uu.di.login;

import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.data_sources.local.AppDatabase;
import trelico.ru.uu.data_sources.local.dao.UserDAO;
import trelico.ru.uu.data_sources.local.repositories.LoginRepo;
import trelico.ru.uu.data_sources.local.repositories.LoginRepoAPI;
import trelico.ru.uu.data_sources.remote.BackendlessAPI;
import trelico.ru.uu.di.scopes.LoginScope;
import trelico.ru.uu.di.scopes.PerFeature;
import trelico.ru.uu.features.login.LoginInteractor;
import trelico.ru.uu.features.login.LoginInteractorAPI;
import trelico.ru.uu.screens.login.LoginPresenter;

@Module
public class LoginModule{

    @Provides
    @PerFeature
    LoginPresenter provideLoginPresenter(LoginInteractorAPI loginInteractorAPI){
        return new LoginPresenter(loginInteractorAPI);
    }

    @Provides
    @PerFeature
    LoginInteractorAPI provideLoginInteractor(LoginRepoAPI loginRepoAPI){
        return new LoginInteractor(loginRepoAPI);
    }

    @Provides
    @PerFeature
    LoginRepoAPI provideLoginRepoAPI(UserDAO userDAO, BackendlessAPI backendlessAPI){
        return new LoginRepo(userDAO, backendlessAPI);
    }

}
