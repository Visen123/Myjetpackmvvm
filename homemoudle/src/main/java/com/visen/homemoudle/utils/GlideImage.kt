package com.visen.homemoudle.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.visen.homemoudle.R
import java.util.concurrent.ExecutionException

/**
 * Created by Administrator on 2016/11/12.
 */
class GlideImage : ImageEngine {
    override fun loadThumbnail(
        context: Context,
        resize: Int,
        placeholder: Drawable,
        imageView: ImageView,
        uri: Uri
    ) {
        Glide.with(context)
            .asBitmap() // some .jpeg files are actually gif
            .load(uri)
            .apply(
                RequestOptions()
                    .override(resize, resize)
                    .placeholder(placeholder)
                    .centerCrop()
            )
            .into(imageView)
    }

    override fun loadGifThumbnail(
        context: Context, resize: Int, placeholder: Drawable, imageView: ImageView,
        uri: Uri
    ) {
        Glide.with(context)
            .asBitmap() // some .jpeg files are actually gif
            .load(uri)
            .apply(
                RequestOptions()
                    .override(resize, resize)
                    .placeholder(placeholder)
                    .centerCrop()
            )
            .into(imageView)
    }

    override fun loadImage(
        context: Context,
        resizeX: Int,
        resizeY: Int,
        imageView: ImageView,
        uri: Uri
    ) {
        Glide.with(context)
            .load(uri)
            .apply(
                RequestOptions()
                    .override(resizeX, resizeY)
                    .priority(Priority.HIGH)
                    .fitCenter()
            )
            .into(imageView)
    }

    override fun loadGifImage(
        context: Context,
        resizeX: Int,
        resizeY: Int,
        imageView: ImageView,
        uri: Uri
    ) {
        Glide.with(context)
            .asGif()
            .load(uri)
            .apply(
                RequestOptions()
                    .override(resizeX, resizeY)
                    .priority(Priority.HIGH)
                    .fitCenter()
            )
            .into(imageView)
    }

    override fun supportAnimatedGif(): Boolean {
        return true
    }

    companion object {
        /**
         * 网络加载图片，含头像默认图片
         *
         * @param mContext
         * @param url
         * @param view
         */
        fun LoaderNetHead(mContext: Context?, url: String?, view: ImageView?) {
            Glide.with(mContext!!).load(url).transform(GlideCircleTransform())
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(view!!)
        }

        /**
         * 本地加载图片成圆形
         *
         * @param mContext
         * @param b
         * @param view
         */
        fun LoaderCircle(mContext: Context?, b: Int, view: ImageView?) {
            Glide.with(mContext!!).load(b).transform(GlideCircleTransform())
                .into(view!!)
        }

        /**
         * 网络加载图片，含头像默认图片
         *
         * @param mContext
         * @param url
         * @param imageView
         */
        fun LoaderRound(mContext: Context?, url: String?, imageView: ImageView?, radius: Int) {
            val transform = GlideRoundTransform(radius)
            Glide.with(mContext!!)
                .load(url)
                .apply(
                    RequestOptions().transform(transform).placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                )
                .into(imageView!!)
        }

        /**
         * 网络加载图片，含默认图片
         *
         * @param mContext
         * @param url
         * @param view
         */
        fun LoaderNet(mContext: Context?, url: String?, view: ImageView?, width: Int, height: Int) {
            Glide.with(mContext!!).load(url).override(width, height)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher).into(
                    view!!
                )
        }

        /**
         * 网络加载图片，含默认图片
         *
         * @param url
         * @param imageView
         */
        fun LoadImge(mContext: Context?, imageView: ImageView?, url: String?) {
            Glide.with(mContext!!)
                .load(url)
                .apply(
                    RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                )
                .into(imageView!!)
        }

        /**
         * 网络加载图片，含默认图片
         * .placeholder(R.mipmap.ico_loading)
         *
         * @param url
         * @param view
         */
        fun LoaderNet(mContext: Context?, url: String?, view: ImageView?) {
            Glide.with(mContext!!).load(url)
                .apply(
                    RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                )
                .listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any,
                        target: Target<Drawable?>,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any,
                        target: Target<Drawable?>,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .into(view!!)
        }

        fun loadImage(mContext: Context?, imageView: ImageView?, uri: Uri?) {
            Glide.with(mContext!!)
                .load(uri)
                .apply(
                    RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                )
                .into(imageView!!)
        }

        fun loadImage(mContext: Context?, imageView: ImageView?, url: String?) {
            Glide.with(mContext!!)
                .load(url)
                .apply(
                    RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                )
                .into(imageView!!)
        }

        fun loadCornerImage(
            mContext: Context?,
            imageView: ImageView?,
            filePath: String?,
            radius: Float
        ) {
            val transform = CornerTransform(mContext, radius)
            val drawable = ColorDrawable(Color.GRAY)
            val options = RequestOptions()
                .centerCrop()
                .placeholder(drawable)
                .transform(transform)
            Glide.with(mContext!!)
                .load(filePath)
                .apply(options)
                .into(imageView!!)
        }


        fun loadProfileImage(
            mContext: Context?,
            imageView: ImageView?,
            filePath: String?
        ) {
            Glide.with(mContext!!)
                .load(filePath)
                .apply(RequestOptions().error(R.mipmap.ic_launcher))
                .into(imageView!!)
        }

        fun clear(mContext: Context?, imageView: ImageView?) {
            Glide.with(mContext!!).clear(imageView!!)
        }

        @Throws(InterruptedException::class, ExecutionException::class)
        fun loadBitmap(mContext: Context?, imageUrl: Any?, targetImageSize: Int): Bitmap? {
            return if (imageUrl == null) {
                null
            } else {
                Glide.with(mContext!!).asBitmap()
                    .load(imageUrl)
                    .apply(RequestOptions().error(R.mipmap.ic_launcher))
                    .into(targetImageSize, targetImageSize)
                    .get()
            }
        }
    }
}