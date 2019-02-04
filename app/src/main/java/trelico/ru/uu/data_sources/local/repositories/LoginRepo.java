package trelico.ru.uu.data_sources.local.repositories;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import trelico.ru.uu.data_sources.local.Settings;
import trelico.ru.uu.data_sources.local.dao.UserDAO;
import trelico.ru.uu.data_sources.remote.BackendlessAPI;
import trelico.ru.uu.models.CurrentUser;
import trelico.ru.uu.models.UserRegistration;

public class LoginRepo implements LoginRepoAPI{

    private UserDAO userDAO;
    private BackendlessAPI backendlessAPI;
    private Settings settings;

    @Inject
    public LoginRepo(UserDAO userDAO, BackendlessAPI backendlessAPI, Settings settings){
        this.userDAO = userDAO;
        this.backendlessAPI = backendlessAPI;
        this.settings = settings;
    }


    @Override
    public boolean isUserLoggedIn(){
        return settings.isUserLoggedIn();
    }

    @Override
    public Observable<CurrentUser> loginUser(String login, String password){
        return backendlessAPI.loginUser(login, password)
                .subscribeOn(Schedulers.io())
                .map(currentUser -> {
                    settings.setUserToken(currentUser.getUserToken());
                    return currentUser;
                });
    }

    @Override
    public void logoutUser(){
        settings.setUserToken("");
    }

    @Override
    public void registerUser(UserRegistration userRegistration){

    }
}
