package trelico.ru.uu.di.user;


import dagger.Component;
import trelico.ru.uu.di.scopes.PerFeature;

@Component(modules = {UserModule.class}
        , dependencies = UserDependencies.class)
@PerFeature
public abstract class UserComponent implements UserAPI{

    private static UserComponent userComponent;

    public static UserAPI initAndGet(
            UserDependencies userDependencies){
        if(userComponent == null){
            userComponent = DaggerScannerComponent.builder()
                    .userDependencies(userDependencies)
                    .build();
        }
        return userComponent;
    }

    public static UserComponent get() {
        if (userComponent == null) {
            throw new RuntimeException(
                    "You must call 'initAndGet(ScannerFeatureDependenciesComponent"
                            + " scannerFeatureDependenciesComponent)' method"
            );
        }
        return userComponent;
    }

//    public abstract void inject(LoginFragment loginFragment);

    @Component(dependencies = {

    })
    @PerFeature
    interface LoginDependenciesComponent extends UserDependencies{}

}
