package xyz.merkmod.metalbrowser.ui

import android.content.SharedPreferences
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import xyz.merkmod.metalbrowser.R
import xyz.merkmod.metalbrowser.activities.SplashActivity

/**
 * Created by thepunkprogrammer on 12/7/17.
 */
class SplashScreenUI : AnkoComponent<SplashActivity> {
    override fun createView(ui: AnkoContext<SplashActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(context, R.color.colorPrimary)
            lparams {
                width = matchParent
                height = matchParent
            }
            relativeLayout {
                background=null
                imageView {
                    scaleType = ImageView.ScaleType.CENTER
                    image = ContextCompat.getDrawable(context, R.mipmap.ic_launcher)
                }.lparams {
                    centerInParent()
                    width = wrapContent
                    height = wrapContent
                }
            }.lparams {
                width = matchParent
                height = matchParent
            }
        }
    }
}