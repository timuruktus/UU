package trelico.ru.uu.screens.register;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class RegisterPresenter  extends MvpPresenter<IRegisterFragment>{

    private String login, password, firstName, secondName, email;

    @Override
    protected void onFirstViewAttach(){
        super.onFirstViewAttach();
    }

    void setLoginAndPassword(String login, String password){
        this.login = login;
        this.password = password;
    }

    void onRegisterButtonClicked(String firstName, String secondName, String email){
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    String getLogin(){
        return login;
    }

    String getPassword(){
        return password;
    }

}
