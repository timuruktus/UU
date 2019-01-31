package trelico.ru.uu.di.login;

import trelico.ru.uu.data_sources.local.repositories.LoginRepoAPI;
import trelico.ru.uu.features.login.LoginInteractor;
import trelico.ru.uu.features.login.LoginInteractorAPI;
import trelico.ru.uu.screens.login.LoginPresenter;

public interface LoginAPI{

    LoginPresenter LoginPresenter();
    LoginInteractorAPI loginInteractorAPI();
    LoginRepoAPI loginRepoAPI();

}
