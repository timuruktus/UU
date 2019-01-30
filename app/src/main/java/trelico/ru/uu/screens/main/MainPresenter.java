package trelico.ru.uu.screens.main;

import trelico.ru.uu.utils.ViewPresenter.IPresenter;
import trelico.ru.uu.utils.ViewPresenter.IView;

public class MainPresenter implements IPresenter{

    IMainActivity mainActivity;

    @Override
    public void putViewInterface(IView view){
        mainActivity = (IMainActivity) view;
    }
}
