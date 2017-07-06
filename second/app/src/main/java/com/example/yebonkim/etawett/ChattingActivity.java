package com.example.yebonkim.etawett;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.yebonkim.etawett.model.Chat;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChattingActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.button)
    Button button;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference db;

    ChattingAdapter adapter;

    List<Chat> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        ButterKnife.bind(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        db = firebaseDatabase.getReference();

        data = new ArrayList<>();

        adapter = new ChattingAdapter(this, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        db.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Chat c = (Chat)dataSnapshot.getValue(Chat.class);
                adapter.addData(c);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @OnClick(R.id.button)
    public void send() {
        String msg = editText.getText().toString();
        String userId = "User1";

        Chat data = new Chat(userId, msg);

        db.child("message").push().setValue(data);
    }




}
