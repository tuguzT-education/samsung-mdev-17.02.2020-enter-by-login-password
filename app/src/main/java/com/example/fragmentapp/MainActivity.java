package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("login", editText1.getText().toString());
                bundle.putString("password", editText2.getText().toString());

                MyDialog myDialog = new MyDialog();
                myDialog.setArguments(bundle);
                myDialog.show(getSupportFragmentManager(),"custom");
            }
        });
    }
}
