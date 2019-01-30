package trelico.ru.uu.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.di.scopes.LoginFeature;
import trelico.ru.uu.screens.login.LoginPresenter;

@Module
public abstract class LoginModule{

    @Binds
    @LoginFeature
    abstract LoginPresenter provideLoginPresenter();
}
