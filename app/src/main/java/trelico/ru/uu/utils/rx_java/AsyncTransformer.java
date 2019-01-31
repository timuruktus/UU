package trelico.ru.uu.utils.rx_java;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AsyncTransformer implements ObservableTransformer{
    @Override
    public ObservableSource apply(Observable upstream){
//        Observable.just(1).compose(this::apply);- JUST AN EXAMPLE

        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
