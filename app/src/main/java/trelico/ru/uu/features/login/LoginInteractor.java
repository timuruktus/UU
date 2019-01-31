package trelico.ru.uu.features.login;

import javax.inject.Inject;

import trelico.ru.uu.data_sources.local.repositories.LoginRepoAPI;

public class LoginInteractor implements LoginInteractorAPI{


    private LoginRepoAPI loginRepoAPI;

    @Inject
    public LoginInteractor(LoginRepoAPI loginRepoAPI){
        this.loginRepoAPI = loginRepoAPI;
    }
}
