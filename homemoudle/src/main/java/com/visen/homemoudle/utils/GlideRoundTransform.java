package com.visen.homemoudle.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.Util;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2017/11/15.
 */

public class GlideRoundTransform extends BitmapTransformation {
    private final String TAG = getClass().getName() + Math.round(radius);
    private static float radius = 6f;

    public GlideRoundTransform() {
        this(6);
    }

    public GlideRoundTransform(int dp) {
        super();
        this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }

    private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        return result;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool, toTransform);
    }


    @Override
    public int hashCode() {
        return Util.hashCode(TAG.hashCode());
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(TAG.getBytes(CHARSET));
    }
}