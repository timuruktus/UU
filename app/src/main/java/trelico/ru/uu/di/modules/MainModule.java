package trelico.ru.uu.di.modules;

import dagger.Module;
import dagger.Provides;
import trelico.ru.uu.di.scopes.MainScope;
import trelico.ru.uu.screens.main.IMainActivity;
import trelico.ru.uu.screens.main.MainPresenter;

@Module
public class MainModule{

    @Provides
    @MainScope
    MainPresenter provideMainPresenter(){
        return new MainPresenter();
    }
}
