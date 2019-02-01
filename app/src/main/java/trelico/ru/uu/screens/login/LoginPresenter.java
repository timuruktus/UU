package trelico.ru.uu.screens.login;

import javax.inject.Inject;

import trelico.ru.uu.data_sources.local.repositories.LoginRepoAPI;
import trelico.ru.uu.di.scopes.LoginScope;
import trelico.ru.uu.utils.view_presenter.Command;
import trelico.ru.uu.utils.view_presenter.CommandExecutor;
import trelico.ru.uu.utils.view_presenter.IPresenter;
import trelico.ru.uu.utils.view_presenter.IView;
import trelico.ru.uu.utils.view_presenter.Strategy;

@LoginScope
public class LoginPresenter implements IPresenter{

    ILoginFragment loginFragment;
    private LoginRepoAPI loginRepoAPI;

    @Override
    public void putViewInterface(IView view){
        loginFragment = (ILoginFragment) view;
    }

    @Inject
    public LoginPresenter(LoginRepoAPI loginRepoAPI){
        this.loginRepoAPI = loginRepoAPI;
        CommandExecutor.sendCommand(new LoginCommandsStorage.StartLoading(this));
    }
}
