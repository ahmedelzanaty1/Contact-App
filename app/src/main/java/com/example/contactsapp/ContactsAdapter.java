package com.example.contactsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private List<Contact> contactList;
    private OnContactClickListener onContactClickListener;

    public ContactsAdapter(List<Contact> contactList, OnContactClickListener onContactClickListener) {
        this.contactList = contactList;
        this.onContactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.tvContactName.setText(contact.getName());
        holder.tvContactPhone.setText(contact.getPhone());
        holder.ivAvatar.setImageResource(R.drawable.ic_person);

        holder.itemView.setOnClickListener(v -> onContactClickListener.onContactClick(contact));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public interface OnContactClickListener {
        void onContactClick(Contact contact);
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvContactName, tvContactPhone;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvContactName = itemView.findViewById(R.id.tvContactName);
            tvContactPhone = itemView.findViewById(R.id.tvContactPhone);
        }
    }
}
