package com.example.mc.androiddemo

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.RemoteViews

import com.example.mc.androiddemo.viewdraggerhelpper.ShellCommandExecutor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val notificationId = 3333
        val remoteView = RemoteViews(packageName, R.layout.remoteview_notify)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = Notification.Builder(this)
                .setContentTitle("我是标题")
                .setContentText("我是内容")
                .setSmallIcon(R.drawable.abc_ic_menu_paste_mtrl_am_alpha)
                .setContent(remoteView)
                .build()
        val editText = EditText(this)




        notificationManager.notify(notificationId, notification)


        // Example of a call to a native method
        //  sample_text.text = stringFromJNI()
    }


}
