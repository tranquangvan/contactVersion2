package com.example.contactversion2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.contactversion2.Database.Controller;
import com.example.contactversion2.Database.Data;
import java.util.ArrayList;

public class ListContact extends AppCompatActivity {
    private ArrayList<Contact> listContact;
    private Controller controller;
    private ListView listView;
    private Data data;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_list_contact);
        listView =  findViewById(R.id.lv);
        data= new Data(this);
        listContact = data.getAllContacts();
        controller = new Controller(this,listContact);
        listView.setAdapter(controller);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListContact.this,CrudActivity.class);
                intent.putExtra("contact",listContact.get(position));
                startActivity(intent);
            }
        });
    }
    public void Add(View view) {
        Intent intent= new Intent(ListContact.this, MainActivity.class);
        startActivity(intent);
    }
}
