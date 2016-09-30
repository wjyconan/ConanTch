package com.conan.conantch.config;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * 封装ProgressBar
 * @param <T>
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener{

    private SubscriberOnNextListener<T> subscriberOnNextListener;
    private ProgressDialogHandler handler;

    private Context context;

    public ProgressSubscriber(SubscriberOnNextListener<T> subscriberOnNextListener, Context context) {
        this.subscriberOnNextListener = subscriberOnNextListener;
        this.context = context;

        handler = new ProgressDialogHandler(this,true,context);
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(T t) {
        subscriberOnNextListener.onNext(t);
    }

    @Override
    public void onCancelProgress() {
        if(!this.isUnsubscribed()){
            this.unsubscribe();
        }
    }

    /**
     * 显示网络请求的ProgressBar
     */
    private void showProgressDialog(){
        if (handler!=null){
            handler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    /**
     * 关闭ProgressBar
     */
    private void dismissProgressDialog(){
        if (handler != null) {
            handler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            handler = null;
        }
    }
}

