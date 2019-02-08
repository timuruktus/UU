package trelico.ru.uu.screens.login;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import trelico.ru.uu.MyApp;
import trelico.ru.uu.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends MvpAppCompatFragment implements ILoginFragment{

    @InjectPresenter
    LoginPresenter loginPresenter;
    @BindView(R.id.personalCabinet)
    AppCompatTextView personalCabinet;
    @BindView(R.id.loginEditText)
    AppCompatEditText loginEditText;
    @BindView(R.id.passwordEditText)
    AppCompatEditText passwordEditText;
    @BindView(R.id.joinButton)
    Button joinButton;
    @BindView(R.id.registerButton)
    Button registerButton;

    public LoginFragment getInstance(){
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
//        VPStorage.addPresenterToView(loginPresenter, this);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void startLoading(){

    }

    @Override
    public void stopLoading(){

    }

    @OnClick(R.id.joinButton)
    public void onJoinButtonClicked(){
        loginPresenter.onJoinButtonClicked();
    }

    @OnClick(R.id.registerButton)
    public void onRegisterButtonClicked(){
        MyApp.INSTANCE.getNavigationHost().navigate(R.id.action_loginFragment_to_registerFragment);
    }
}
