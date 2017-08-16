package com.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by User on 7/17/2017.
 */

public class CommonUtils {


    /*Check internet connection*/
    public static boolean isNetworkAvailable(Context mContext) {

		/* getting systems Service connectivity manager */
        ConnectivityManager mConnectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (mConnectivityManager != null) {
            NetworkInfo[] mNetworkInfos = mConnectivityManager
                    .getAllNetworkInfo();
            if (mNetworkInfos != null) {
                for (int i = 0; i < mNetworkInfos.length; i++) {
                    if (mNetworkInfos[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    /* Show Simple Toast*/
    public static void showToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }



    /* Close/Hide Keyboard */

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(INPUT_METHOD_SERVICE);
        View v = activity.getCurrentFocus();
        if (v == null)
            return;
        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /* Show/Open Keyboard */
    public static void openKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity
                .getSystemService(INPUT_METHOD_SERVICE);
        View v = activity.getCurrentFocus();
        if (v == null)
            return;
        inputManager.showSoftInput(activity.getCurrentFocus(), InputMethodManager.SHOW_FORCED);
    }


    /* Mobile Screen Width in Pixel*/
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /* Mobile Screen Width in Pixel*/
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /* Conver DP to Pixel*/
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /* Conver Pixel to DP*/
    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    /* Show Dialog */
    public static AlertDialog getDialog(Context context, String message) {

        return new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.app_name))
                .setMessage(message).show();

    }


}
