package com.somo.test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

/**
 * Created by yebonkim on 2016. 12. 1..
 */

public class LoadingDialog extends AsyncTask<Void, Void, Void> {

    Activity context;
    ProgressDialog pd;
    LoadingTask loadingTask;

    public LoadingDialog(Activity context, LoadingTask loadingTask) {
        this.context = context;
        this.loadingTask = loadingTask;
    }

    @Override
    protected Void doInBackground(Void... params) {
        loadingTask.task();
        return null;
    }

    @Override
    protected void onPreExecute(){
        pd = ProgressDialog.show(context, "Loading", "wait...", true);
    }


    @Override
    protected void onPostExecute(Void result) {
        pd.dismiss();
    }
}
