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

    public Command<T> setPresenter(IPresenter presenter){
        this.presenter = presenter;
        return this;
    }

    @Nullable
    public T getView(){
        return view;
    }

    public Command<T> setView(@Nullable T view){
        this.view = view;
        return this;
    }

    public Strategy getStrategy(){
        return strategy;
    }

    public Command<T> setStrategy(Strategy strategy){
        this.strategy = strategy;
        return this;
    }


}
