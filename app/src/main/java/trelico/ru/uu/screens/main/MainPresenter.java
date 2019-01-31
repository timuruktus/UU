package trelico.ru.uu.screens.main;

import javax.inject.Inject;

import trelico.ru.uu.utils.view_presenter.IPresenter;
import trelico.ru.uu.utils.view_presenter.IView;

public class MainPresenter implements IPresenter{

    IMainActivity mainActivity;

    @Override
    public void putViewInterface(IView view){
        mainActivity = (IMainActivity) view;
    }

    @Inject
    public MainPresenter(){
    }
}
