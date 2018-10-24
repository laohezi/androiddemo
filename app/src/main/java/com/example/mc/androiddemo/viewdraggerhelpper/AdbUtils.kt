package com.example.mc.androiddemo.viewdraggerhelpper

import android.text.TextUtils
import android.util.Log
import java.io.DataOutputStream
import java.io.IOException


/**
 * Android shell 命令执行器，支持无限个命令串型执行（需要有root权限！！）
 *
 *
 *
 *
 * HOW TO USE?
 * Example:修改开机启动动画。把/sdcard/Download目录下的bootanimation.zip文件拷贝到
 * /system/media目录下并修改bootanimation.zip的权限为777。
 *
 *
 * <pre>
 * int result = new ShellCommandExecutor()
 * .addCommand("mount -o remount,rw /system")
 * .addCommand("cp /sdcard/Download/bootanimation.zip /system/media")
 * .addCommand("cd /system/media")
 * .addCommand("chmod 777 bootanimation.zip")
 * .execute();
 * <pre></pre>
 *
 * @author AveryZhong.
</pre> */

class ShellCommandExecutor {

    private val mCommands: StringBuilder

    init {
        mCommands = StringBuilder()
    }

    fun execute(): Int {
        return execute(mCommands.toString())
    }

    fun addCommand(cmd: String): ShellCommandExecutor {
        if (TextUtils.isEmpty(cmd)) {
            throw IllegalArgumentException("command can not be null.")
        }
        mCommands.append(cmd)
        mCommands.append("\n")
        return this
    }

    companion object {
        private val TAG = "ShellCommandExecutor"

        fun execute(command: String): Int {
            var result = -1
            var dos: DataOutputStream? = null
            try {
                val p = Runtime.getRuntime().exec("su")
                dos = DataOutputStream(p.outputStream)
                Log.i(TAG, command)
                dos!!.writeBytes(command + "\n")
                dos!!.flush()
                dos!!.writeBytes("exit\n")
                dos!!.flush()
                p.waitFor()
                result = p.exitValue()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (dos != null) {
                    try {
                        dos!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
            return result
        }
    }


}

