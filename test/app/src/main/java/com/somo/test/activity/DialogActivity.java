package com.somo.test.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.somo.test.R;
import com.somo.test.adapter.MyRecyclerViewAdapter;
import com.somo.test.model.Data;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
        ButterKnife.bind(this);

        showCustomDialog();

    }

    protected void showSimpleDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("앱이름")
                .setMessage("asdfasda")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    protected void showCustomDialog() {
        View view = getLayoutInflater().inflate(R.layout.dialog_test, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.btn_green_highlight));
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(false)
                .create();
        dialog.show();
    }

}
