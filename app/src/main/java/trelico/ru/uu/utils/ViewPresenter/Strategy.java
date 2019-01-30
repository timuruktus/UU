package trelico.ru.uu.utils.ViewPresenter;

public enum Strategy{

    /**
     * When CommandExecutor should destroy command
     */
    SINGLE, //after execution
    EVERY_CREATION //never until this view will be completely destroyed
}
