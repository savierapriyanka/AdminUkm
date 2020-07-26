package com.example.adminukm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//Deklarasi komponen

public class FormDaftar extends AppCompatActivity {
    private EditText namadepan,namabelakang,telepon,email,alamat,ukm,alasan;
    private Button btnview;
    DatabaseReference reference;
    Request req = new Request();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_form_daftar);
            //memanggil id komponen
            namadepan = (EditText) findViewById(R.id.namadepan);
            namabelakang = (EditText) findViewById(R.id.namabelakang);
            telepon = (EditText) findViewById(R.id.telepon);
            email = (EditText) findViewById(R.id.email);
            alamat = (EditText) findViewById(R.id.alamat);
            ukm = (EditText) findViewById(R.id.ukm);
            alasan = (EditText) findViewById(R.id.alasan);
            btnview = (Button) findViewById(R.id.btnview);
            final Button submit = (Button) findViewById(R.id.submit);
            btnview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FormDaftar.this, DisplayActivity.class);
                    startActivity(intent);
                }
            });
            submit.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                String sNamadepan = namadepan.getText().toString();
                String sNamabelakang = namabelakang.getText().toString();
                String stelepon = telepon.getText().toString();
                String sEmail = email.getText().toString();
                String sAlamat = alamat.getText().toString();
                String sUkm = ukm.getText().toString();
                String sAlasan = alasan.getText().toString();

                reference = FirebaseDatabase.getInstance().getReference().child("Request"); getValue();
                if (sNamadepan.equals("") || sNamabelakang.equals("")  || stelepon.equals("") || sEmail.equals("") || sAlamat.equals("") || sUkm.equals("") || sAlasan.equals("")) {
                    Toast.makeText(FormDaftar.this, "Data Tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
                else
                {
                    reference.child("RequestData").push().setValue(req);
                    namadepan.setText("");
                    namabelakang.setText("");
                    telepon.setText("");
                    email.setText("");
                    alamat.setText("");
                    ukm.setText("");
                    alasan.setText("");

                    Toast.makeText(FormDaftar.this,"Data Tersimpan",Toast.LENGTH_LONG).show(); }
                } });
            }
            private void getValue() {
                req.setNamadepan(namadepan.getText().toString());
                req.setNamabelakang(namabelakang.getText().toString());
                req.setTelepon(telepon.getText().toString());
                req.setEmail(email.getText().toString());
                req.setAlamat(alamat.getText().toString());
                req.setUkm(ukm.getText().toString());
                req.setAlasan(alasan.getText().toString());
        }
        }

