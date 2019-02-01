package trelico.ru.uu.di;

import android.content.Context;

import trelico.ru.uu.di.components.AppComponent;
import trelico.ru.uu.di.components.DaggerAppComponent;
import trelico.ru.uu.di.components.LoginComponent;
import trelico.ru.uu.di.modules.AppModule;
import trelico.ru.uu.di.modules.LoginModule;

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

    public LoginComponent getLoginComponent(){
        if(loginComponent == null){
            loginComponent = appComponent.plusLoginComponent(new LoginModule());
        }
        return loginComponent;
    }

    public void clearLoginComponent(){
        loginComponent = null;
    }
}
