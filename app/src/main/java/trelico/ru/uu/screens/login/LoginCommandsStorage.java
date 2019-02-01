package trelico.ru.uu.screens.login;

import androidx.lifecycle.LifecycleObserver;
import trelico.ru.uu.utils.view_presenter.Command;
import trelico.ru.uu.utils.view_presenter.IPresenter;
import trelico.ru.uu.utils.view_presenter.IView;
import trelico.ru.uu.utils.view_presenter.Strategy;

public class LoginCommandsStorage{

    public static class StartLoading extends Command<ILoginFragment>{

        public StartLoading(IPresenter presenter){
            setPresenter(presenter);
            setStrategy(Strategy.EVERY_CREATION);
        }

        @Override
        public void use(){
            getView().startLoading();
        }
    }


}
