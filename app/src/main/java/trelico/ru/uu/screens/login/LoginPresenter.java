package trelico.ru.uu.screens.login;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import trelico.ru.uu.MyApp;
import trelico.ru.uu.data_sources.local.repositories.LoginRepoAPI;
import trelico.ru.uu.di.scopes.LoginScope;

@LoginScope
@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginFragment>{

    @Inject
    ILoginFragment loginFragment;
    @Inject
    private LoginRepoAPI loginRepoAPI;


    @Override
    protected void onFirstViewAttach(){
        super.onFirstViewAttach();
        MyApp.INSTANCE.getComponentsInjector().getLoginComponent().inject(this);
        getViewState().startLoading();
    }

    @Override
    public void onDestroy(){
        //Maybe we should move code to another method cause we don't know when onDestroy executes
        super.onDestroy();
        MyApp.INSTANCE.getComponentsInjector().clearLoginComponent();
    }

    void onJoinButtonClicked(){

    }


}
