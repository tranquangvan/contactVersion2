package com.example.contactversion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.contactversion2.Database.Data;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etNumberPhone;
    private Data data;
    private Button button;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new Data(this);
        imageButton =findViewById(R.id.button);
        etName =  findViewById(R.id.etName);
        etNumberPhone =  findViewById(R.id.etNumberPhone);
    }
    public void Back(View view) {
        Intent intent = new Intent(MainActivity.this,ListContact.class);
        startActivity(intent);
    }
    public void Add(View view) {
        data.addContact(etName.getText().toString(), etNumberPhone.getText().toString());
        etName.setText("");
        etNumberPhone.setText("");
        Toast.makeText(MainActivity.this, "Successfully!", Toast.LENGTH_SHORT).show();
    }


}
