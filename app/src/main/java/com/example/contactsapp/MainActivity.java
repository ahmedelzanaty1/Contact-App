package com.example.contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPhone, etDescription;
    private ContactsAdapter contactsAdapter;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etDescription = findViewById(R.id.etDescription);
        Button btnSave = findViewById(R.id.btnSave);
        RecyclerView rvContacts = findViewById(R.id.rvContacts);

        contactList = new ArrayList<>();
        contactsAdapter = new ContactsAdapter(contactList, this::onContactClick);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        rvContacts.setAdapter(contactsAdapter);

        btnSave.setOnClickListener(view -> saveContact());
    }

    private void saveContact() {
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        if (TextUtils.isEmpty(name) || name.length() < 3) {
            etName.setError("Name must be at least 3 characters");
            return;
        }
        if (TextUtils.isEmpty(phone) || phone.length() != 11) {
            etPhone.setError("Phone number must be 11 digits");
            return;
        }

        Contact contact = new Contact(name, phone, description);
        contactList.add(contact);
        contactsAdapter.notifyDataSetChanged();

        etName.setText("");
        etPhone.setText("");
        etDescription.setText("");

        Toast.makeText(this, "Contact saved", Toast.LENGTH_SHORT).show();
    }

    private void onContactClick(Contact contact) {
        Intent intent = new Intent(this, ContactDetailsActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }
}
