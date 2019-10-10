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

public class CrudActivity extends AppCompatActivity {

    private Button btnUpdate;
    private Button btnDelete;
    private ImageButton imageButton;
    private Contact contact;
    private EditText etName, etNumberPhone;
    private Data data;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crud);
        Intent intent = getIntent();
        contact = (Contact) intent.getSerializableExtra("contact");
        data = new Data(this);
        etName =  findViewById(R.id.etName);
        etNumberPhone =  findViewById(R.id.etNumberPhone);
        etName.setText(contact.getName());
        etNumberPhone.setText(contact.getNumberPhone());
    }
    public void Delete(View view) {
        data.deleteContact(contact.getId());
        Toast.makeText(CrudActivity.this, "Delete Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CrudActivity.this,ListContact.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
    public void Edit(View view) {
        data.updateContact(contact.getId(), etName.getText().toString(), etNumberPhone.getText().toString());
        Toast.makeText(CrudActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CrudActivity.this,ListContact.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
