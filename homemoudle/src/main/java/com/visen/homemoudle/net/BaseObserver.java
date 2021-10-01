package com.visen.homemoudle.net;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;


import com.visen.homemoudle.utils.Loger;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    private final int SUCCESS_CODE = 0;
    private Context mContext;
    private Dialog mDialog;
    private Disposable mDisposable;
    private Activity activity;

    public BaseObserver(Context context, Dialog dialog) {
        mContext = context;
        activity = (Activity) context;
        mDialog = dialog;

        if (mDialog != null && !isDestroy(activity)) {
            mDialog.show();

            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    mDisposable.dispose();
                }
            });
        }

    }

    public static boolean isDestroy(Activity activity) {
        if (activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(T value) {
        onHandleSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        Loger.e((Exception) e);
        if (mDialog != null && mDialog.isShowing() && !isDestroy(activity)) {
            mDialog.dismiss();
        }
        onHandleError(e);
    }

    @Override
    public void onComplete() {
        if (mDialog != null && mDialog.isShowing() && !isDestroy(activity)) {
            mDialog.dismiss();
        }
    }

    protected abstract void onHandleSuccess(T t);

    protected void onHandleError(Throwable e) {
    }


}
