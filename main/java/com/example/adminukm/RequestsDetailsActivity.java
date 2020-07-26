package com.example.adminukm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
public class RequestsDetailsActivity extends AppCompatActivity {
    private EditText mNamadepan_edit;
    private EditText mNamabelakang_edit;
    private EditText mTelepon_edit;
    private EditText mEmail_edit;
    private EditText mAlamat_edit;
    private EditText mUkm_edit;
    private EditText mAlasan_edit;
    private Button update;
    private Button delete;
    private String key;
    private String namadepan;
    private String namabelakang;
    private String telepon;
    private String email;
    private String alamat;
    private String ukm;
    private String alasan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_details);
        key = getIntent().getStringExtra("key");
        namadepan = getIntent().getStringExtra("namadepan");
        namabelakang = getIntent().getStringExtra("namabelakang");
        telepon = getIntent().getStringExtra("telepon");
        email = getIntent().getStringExtra("email");
        alamat = getIntent().getStringExtra("alamat");
        ukm = getIntent().getStringExtra("ukm");
        alasan = getIntent().getStringExtra("alasan");
        mNamadepan_edit = (EditText) findViewById(R.id.txnamadepan);
        mNamadepan_edit.setText(namadepan);
        mNamabelakang_edit = (EditText) FindViewbyId(R.id.txnamabelakang);
        mNamabelakang_edit.setText(namabelakang);
        mTelepon_edit = (EditText) findViewById(R.id.txtelepon);
        mTelepon_edit.setText(telepon);
        mEmail_edit = (EditText) findViewById(R.id.txemail);
        mEmail_edit.setText(email);
        mAlamat_edit = (EditText) findViewById(R.id.txalamat);
        mAlamat_edit.setText(alamat);
        mUkm_edit = (EditText) findViewById(R.id.txukm);
        mUkm_edit.setText(ukm);
        mAlasan_edit = (EditText) findViewById(R.id.txalasan);
        mAlasan_edit.setText(alasan);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request requests = new Request();
                requests.setNamadepan(mNamadepan_edit.getText().toString());
                requests.setNamabelakang(mNamabelakang_edit.getText().toString());
                requests.setNamabelakang(mTelepon_edit.getText().toString());
                requests.setNamabelakang(mEmail_edit.getText().toString());
                requests.setNamabelakang(mAlamat_edit.getText().toString());
                requests.setNamabelakang(mUkm_edit.getText().toString());
                requests.setNamabelakang(mAlasan_edit.getText().toString());
                new FirebaseDatabaseHelper().update(key, requests, new
                        FirebaseDatabaseHelper.DataStatus() {
                            @Override
                            public void dataIsLoad(List<Request> requests, List<String> keys) {
                            }

                            @Override
                            public void dataIsUpdate() {
                                Toast.makeText(RequestsDetailsActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                                mNamadepan_edit.setText("");
                                mNamabelakang_edit.setText("");
                                mTelepon_edit.setText("");
                                mEmail_edit.setText("");
                                mAlamat_edit.setText("");
                                mUkm_edit.setText("");
                                mAlasan_edit.setText("");
                            }

                            @Override
                            public void dataIsDeleted() {
                            }
                        });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RequestsDetailsActivity.this, "Data Delete", Toast.LENGTH_LONG).show();
                        new FirebaseDatabaseHelper().delete(key, new FirebaseDatabaseHelper.DataStatus() {
                            @Override
                            public void dataIsLoad(List<Request> requests, List<String> keys) {
                            }

                            @Override
                            public void dataIsUpdate() {
                            }

                            @Override
                            public void dataIsDeleted() {
                                Toast.makeText(RequestsDetailsActivity.this, "Data Delete", Toast.LENGTH_LONG).show();
                                finish();
                                return;
                            }
                        });
                    }
                });
            }
        });
    }

    private Object FindViewbyId(int txnamabelakang) {return txnamabelakang;
    }
}