package trelico.ru.uu.di;

import android.content.Context;

import trelico.ru.uu.di.components.AppComponent;
import trelico.ru.uu.di.components.DaggerAppComponent;
import trelico.ru.uu.di.login.LoginComponent;
import trelico.ru.uu.di.modules.AppModule;

public class ComponentsInjector{

    //МОЖНО НЕ ОТСЛЕЖИВТЬ НАВИГАЦИЮ, МОЖНО ОТСЛЕЖИВАТЬ ЗАПРОСЫ НА СОЗДАНИЕ КОМПОНЕНТ
    //МОЖНО ПРОСТО УНИЧТЖАТЬ НЕНУЖНЫЕ СКОУПЫ КОГДА НАМ ЭТО НАДО ПРЯМО ИЗ ФРАГМЕНТОВ


    private AppComponent appComponent;
    private LoginComponent loginComponent;

    public ComponentsInjector(Context appContext){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();

    }
}
