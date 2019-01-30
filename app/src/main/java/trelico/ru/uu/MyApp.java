package trelico.ru.uu;

import android.app.Application;

import androidx.navigation.NavController;
import trelico.ru.uu.di.ComponentsInjector;
import trelico.ru.uu.di.components.AppComponent;
import trelico.ru.uu.di.components.DaggerAppComponent;
import trelico.ru.uu.di.modules.AppModule;

public class MyApp extends Application{

    public static final String TAG = "debug_tag";
    private AppComponent appComponent;
    public static MyApp INSTANCE;
    private NavController navController;
    private ComponentsInjector componentsInjector;


    @Override
    public void onCreate(){
        super.onCreate();
        INSTANCE = this;
        componentsInjector = new ComponentsInjector(this);
    }

    private void buildAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }


    public void setNavigationHost(NavController navController){
        this.navController = navController;
        navController.addOnDestinationChangedListener(componentsInjector);
    }

    public NavController getNavigationHost(){
        return navController;
    }

}
