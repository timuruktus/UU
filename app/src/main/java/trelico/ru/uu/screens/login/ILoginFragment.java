package trelico.ru.uu.screens.login;

import trelico.ru.uu.utils.view_presenter.Command;
import trelico.ru.uu.utils.view_presenter.IView;

public interface ILoginFragment extends IView{


    void startLoading();
    void stopLoading();

}
