package com.example.contactsapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailsActivity extends AppCompatActivity {

    private ImageView ivAvatar;
    private TextView tvName, tvPhone, tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        ivAvatar = findViewById(R.id.imageView);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvDescription = findViewById(R.id.tvDescription);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        if (contact != null) {
            tvName.setText(contact.getName());
            tvPhone.setText(contact.getPhone());
            tvDescription.setText(contact.getDescription());
            ivAvatar.setImageResource(R.drawable.ic_person);
        }
    }
}
