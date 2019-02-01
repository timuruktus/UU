package trelico.ru.uu.utils.view_presenter;

import androidx.annotation.Nullable;

public abstract class Command<T extends IView>{

    @Nullable
    private T view;
    private IPresenter presenter;
    private Strategy strategy;

    public abstract void use();

    public IPresenter getPresenter(){
        return presenter;
    }

    public void setPresenter(IPresenter presenter){
        this.presenter = presenter;
    }

    @Nullable
    public T getView(){
        return view;
    }

    public void setView(@Nullable T view){
        this.view = view;
    }

    public Strategy getStrategy(){
        return strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}
