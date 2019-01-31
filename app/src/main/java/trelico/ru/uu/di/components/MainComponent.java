package trelico.ru.uu.di.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import trelico.ru.uu.di.modules.MainModule;
import trelico.ru.uu.screens.main.MainActivity;

@Subcomponent(modules = MainModule.class)
public interface MainComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
