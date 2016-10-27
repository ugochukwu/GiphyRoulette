package com.onwordiesquire.mobile.giphyroulette.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by michelonwordi on 10/25/16.
 */

public final class DialogFactory {


    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        return progressDialog;
    }
}
