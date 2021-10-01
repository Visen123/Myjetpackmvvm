package com.visen.homemoudle.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

/**
 * 屏幕适配
 *
 * @author yy
 */
public final class ScreenUtils {

    // 获取屏幕宽度
    public static int getScreenWidth(Context context) {
        WindowManager windowmanager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = windowmanager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    // 得到屏幕高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        return height;
    }

    /**
     * 基于屏幕宽度，传入上下文和对应的view及view所需设置的宽高对比屏幕宽度的比例
     */

    public static LayoutParams getParmsFromWidth(Context context, View v, float width,
                                                 float height) {
        LayoutParams params = v.getLayoutParams();
        params.width = (int) (getScreenWidth(context) * width);
        params.height = (int) (getScreenWidth(context) * height);
        return params;
    }

    /**
     * 基于屏幕宽高，传入上下文和对应的view及view所需设置的宽高对比屏幕宽高的比例
     */

    public static LayoutParams getParms(Context context, View v, float width,
                                        float height) {
        LayoutParams params = v.getLayoutParams();
        params.width = (int) (getScreenWidth(context) * width);
        params.height = (int) (getScreenHeight(context) * height);
        return params;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;

    }

    // 获得像素密度
    public static float getPxdensity(Context context) {
        WindowManager win = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dis = new DisplayMetrics();
        win.getDefaultDisplay().getMetrics(dis);
        return dis.density;
    }

    /**
     * convert sp to its equivalent px
     * <p>
     * 将sp转换为px
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


    /**
     * 设置头部状态栏
     */
    public static void setHead(Activity context, View view, int color, int tag) {
        //5.0及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = context.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            context.getWindow().setStatusBarColor(context.getResources().getColor(color));
            //tag为1时头部是正常的白色标题栏头部；tag为2时头部是图片
            if (tag == 1) {
                view.getLayoutParams().height = getBarHeight(context) + 5;
                view.setLayoutParams(view.getLayoutParams());
                view.setBackgroundColor(context.getResources().getColor(color));
            } else if (tag == 2) {
                //设置距离顶部margin值
                setMargins(view, 0, getBarHeight(context), 0, 0);
            }
        }
    }

    /**
     * 设置头部margin值
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
                p.setMargins(l, t, r, b);
                v.requestLayout();
            }
        }
    }

    public static int getMultiBarHeight(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getBarHeight(context);
        }
        return 0;
    }

    /**
     * 获取状态栏高度
     */
    public static int getBarHeight(Context context) {
        int statusBarHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * Android 6.0以上适配
     *
     * @param activity
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static void setStatusBarLightMode(Activity activity) {
        if (activity.getWindow().getDecorView().getSystemUiVisibility() != (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 设置状态栏字体颜色变白
     *
     * @param activity
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void setStatusBarDarkMode(Activity activity) {
        if (activity.getWindow().getDecorView().getSystemUiVisibility() != (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

    }

    public static int getBottomNavHeight(Context context) {
        return getHasVirtualKey(context) - getNoHasVirtualKey(context);
    }

    private static int getNoHasVirtualKey(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.
                WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    private static int getHasVirtualKey(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.
                WINDOW_SERVICE);
        final Display display = windowManager.getDefaultDisplay();
        Point outPoint = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            // 可能有虚拟按键的情况
            display.getRealSize(outPoint);
        } else {
            // 不可能有虚拟按键
            display.getSize(outPoint);
        }
        return outPoint.y;
    }

    public static boolean isSupportImmersive() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }


}
