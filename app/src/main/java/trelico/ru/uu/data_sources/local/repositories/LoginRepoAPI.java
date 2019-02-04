package trelico.ru.uu.data_sources.local.repositories;

import io.reactivex.Observable;
import trelico.ru.uu.models.CurrentUser;
import trelico.ru.uu.models.UserRegistration;

public interface LoginRepoAPI{


    boolean isUserLoggedIn();
    Observable<CurrentUser> loginUser(String login, String password);
    void logoutUser();
    void registerUser(UserRegistration userRegistration);

}
