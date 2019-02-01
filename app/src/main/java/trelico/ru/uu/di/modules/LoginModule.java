package trelico.ru.uu.di.modules;

import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.data_sources.local.AppDatabase;
import trelico.ru.uu.data_sources.local.dao.UserDAO;
import trelico.ru.uu.data_sources.local.repositories.LoginRepo;
import trelico.ru.uu.data_sources.local.repositories.LoginRepoAPI;
import trelico.ru.uu.data_sources.remote.BackendlessAPI;
import trelico.ru.uu.di.scopes.LoginScope;
import trelico.ru.uu.screens.login.LoginPresenter;

@Module
public class LoginModule{

    @Provides
    @LoginScope
    LoginPresenter provideLoginPresenter(LoginRepoAPI loginRepoAPI){
        return new LoginPresenter(loginRepoAPI);
    }


    @Provides
    @LoginScope
    LoginRepoAPI provideLoginRepoAPI(UserDAO userDAO, BackendlessAPI backendlessAPI){
        return new LoginRepo(userDAO, backendlessAPI);
    }

    @Provides
    @LoginScope
    UserDAO provideUserDAO(AppDatabase appDatabase){
        return appDatabase.userDAO();
    }
}
