package com.example.abedc.projektraining;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    EditText title;
    EditText link;
    EditText desc;
    EditText creator;
    Button publish;

    public static List<AppModel> appList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference("apps");


        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tinggal ganti valuenya
                databaseReference.push().setValue(new AppModel("name", "desc", "link", "creator")).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // hilangkan progress
                        if (!task.isSuccessful()) {
                            task.getException().printStackTrace();
                        } else finish();
                    }
                });
            }
        });

    }

    public void init() {
        title = (EditText) findViewById(R.id.etInputTittle_AddActivity);
        link = (EditText) findViewById(R.id.etInputLink_AddActivity);
        desc = (EditText) findViewById(R.id.etInputDescription_AddActivity);
        creator = (EditText) findViewById(R.id.etInputCreator_AddActivity);
        publish = (Button) findViewById(R.id.btnPublis_AddActivity);
    }
}
