package serviceUtil;

import rx.Subscriber;

/**
 * Created by fanhengbiao on 16-8-23.
 */

public abstract class HttpResultSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        LogUtil.printE("failed",""+e.getMessage());
        _Error(e);
    }

    @Override
    public void onNext(T t) {
        LogUtil.printE("_success","11"+t.toString());
        _onSuccess(t);

    }
    public abstract void _onSuccess(T t);
    public abstract void  _Error(Throwable t);
}
