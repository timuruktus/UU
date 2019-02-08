package trelico.ru.uu.screens.login;

import com.arellomobile.mvp.MvpView;


public interface ILoginFragment extends MvpView{


    void startLoading();
    void stopLoading();

}
