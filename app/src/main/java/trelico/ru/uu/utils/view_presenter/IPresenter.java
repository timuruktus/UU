package trelico.ru.uu.utils.view_presenter;


/**
 * All presenters are singletons and should be created via Dagger
 */
public interface IPresenter{


    void putViewInterface(IView view);

}
