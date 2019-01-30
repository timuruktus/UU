package trelico.ru.uu.di.components;

import dagger.Component;
import dagger.Subcomponent;
import trelico.ru.uu.di.modules.LoginModule;
import trelico.ru.uu.di.scopes.LoginFeature;
import trelico.ru.uu.screens.login.LoginFragment;

@Subcomponent(modules = {LoginModule.class})
@LoginFeature
public interface LoginComponent{

    void inject(LoginFragment loginFragment);
}
