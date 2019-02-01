package trelico.ru.uu.screens.login;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import trelico.ru.uu.R;
import trelico.ru.uu.utils.view_presenter.VPStorage;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements ILoginFragment{

    @Inject
    LoginPresenter loginPresenter;

    public LoginFragment getInstance(){
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        //injection
        VPStorage.addPresenterToView(loginPresenter, this);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
