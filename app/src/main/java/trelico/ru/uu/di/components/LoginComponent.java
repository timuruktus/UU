package trelico.ru.uu.di.components;

import dagger.Subcomponent;
import trelico.ru.uu.di.modules.LoginModule;
import trelico.ru.uu.di.scopes.LoginScope;
import trelico.ru.uu.screens.login.LoginFragment;

@Subcomponent(modules = {LoginModule.class})
@LoginScope
public interface LoginComponent{

    void inject(LoginFragment loginFragment);
}
