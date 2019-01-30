package trelico.ru.uu.screens.login;

import javax.inject.Inject;

import trelico.ru.uu.di.scopes.LoginFeature;
import trelico.ru.uu.features.login.LoginInteractorAPI;
import trelico.ru.uu.utils.ViewPresenter.IPresenter;
import trelico.ru.uu.utils.ViewPresenter.IView;

@LoginFeature
public class LoginPresenter implements IPresenter{

    ILoginFragment loginFragment;
    private LoginInteractorAPI loginInteractorAPI;

    @Override
    public void putViewInterface(IView view){
        loginFragment = (ILoginFragment) view;
    }

    @Inject
    public LoginPresenter(LoginInteractorAPI loginInteractorAPI){
        this.loginInteractorAPI = loginInteractorAPI;
    }
}
