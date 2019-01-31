package trelico.ru.uu.di.login;

import dagger.Component;
import trelico.ru.uu.di.scopes.PerFeature;
import trelico.ru.uu.di.user.UserAPI;
import trelico.ru.uu.screens.login.LoginFragment;

@Component(modules = {LoginModule.class}
        , dependencies = LoginDependencies.class)
@PerFeature
public abstract class LoginComponent implements LoginAPI{

    private static LoginComponent loginComponent;

    public static LoginAPI initAndGet(
            LoginDependencies loginDependencies){
        if(loginComponent == null){
            loginComponent = DaggerScannerComponent.builder()
                    .loginDependencies(loginDependencies)
                    .build();
        }
        return loginComponent;
    }

    public static LoginComponent get() {
        if (loginComponent == null) {
            throw new RuntimeException(
                    "You must call 'initAndGet(ScannerFeatureDependenciesComponent"
                            + " scannerFeatureDependenciesComponent)' method"
            );
        }
        return loginComponent;
    }

    public abstract void inject(LoginFragment loginFragment);

    @Component(dependencies = {
            UserAPI.class,
    })
    @PerFeature
    interface LoginDependenciesComponent extends LoginDependencies{}


}
