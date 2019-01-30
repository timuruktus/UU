package trelico.ru.uu.di.modules;

import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.dataSources.local.AppDatabase;
import trelico.ru.uu.dataSources.local.dao.UserDAO;
import trelico.ru.uu.dataSources.local.repositories.LoginRepo;
import trelico.ru.uu.dataSources.local.repositories.LoginRepoAPI;
import trelico.ru.uu.dataSources.remote.BackendlessAPI;
import trelico.ru.uu.di.scopes.LoginFeature;
import trelico.ru.uu.features.login.LoginInteractor;
import trelico.ru.uu.features.login.LoginInteractorAPI;
import trelico.ru.uu.screens.login.LoginPresenter;

@Module
public class LoginModule{

    @Provides
    @LoginFeature
    LoginPresenter provideLoginPresenter(LoginInteractorAPI loginInteractorAPI){
        return new LoginPresenter(loginInteractorAPI);
    }

    @Provides
    @LoginFeature
    LoginInteractorAPI provideLoginInteractor(LoginRepoAPI loginRepoAPI){
        return new LoginInteractor(loginRepoAPI);
    }

    @Provides
    @LoginFeature
    LoginRepoAPI provideLoginRepoAPI(UserDAO userDAO, BackendlessAPI backendlessAPI){
        return new LoginRepo(userDAO, backendlessAPI);
    }

    @Provides
    @LoginFeature
    UserDAO provideUserDAO(AppDatabase appDatabase){
        return appDatabase.userDAO();
    }
}
