package trelico.ru.uu.di.components;

import javax.inject.Singleton;

import dagger.Component;
import trelico.ru.uu.MyApp;
import trelico.ru.uu.di.modules.AppModule;
import trelico.ru.uu.di.modules.LoginModule;
import trelico.ru.uu.screens.main.MainActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent{

    LoginComponent plusLoginComponent(LoginModule loginModule);

    void inject(MainActivity activity);
    void inject(MyApp app);
}
