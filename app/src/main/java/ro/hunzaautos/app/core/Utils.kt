package ro.hunzaautos.app.core

import android.util.Log
import ro.hunzaautos.app.core.Constants.TAG

class Utils {
    companion object {
        fun printError(message: String) {
            Log.d(TAG, message)
        }
    }
}