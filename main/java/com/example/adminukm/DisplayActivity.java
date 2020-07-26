package com.example.adminukm;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "DisplayActivity";

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private ListView mListView;
    private String RequestID;
    private FirebaseAuth RequestData;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        mListView = (ListView) findViewById(R.id.listview);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Request uInfo = new Request();
            uInfo.setNamadepan(ds.child(RequestID).getValue(Request.class).getNamadepan()); //set the name
            uInfo.setNamabelakang(ds.child(RequestID).getValue(Request.class).getNamabelakang()); //set the name
            uInfo.setTelepon(ds.child(RequestID).getValue(Request.class).getTelepon()); //set the name
            uInfo.setEmail(ds.child(RequestID).getValue(Request.class).getEmail()); //set the email
            uInfo.setAlamat(ds.child(RequestID).getValue(Request.class).getAlamat()); //set the phone_num
            uInfo.setUkm(ds.child(RequestID).getValue(Request.class).getUkm()); //set the name
            uInfo.setAlasan(ds.child(RequestID).getValue(Request.class).getAlasan());

            //display all the information
            Log.d(TAG, "showData: namadepan: " + uInfo.getNamadepan());
            Log.d(TAG, "showData: namabelakang: " + uInfo.getNamabelakang());
            Log.d(TAG, "showData: telepon: " + uInfo.getTelepon());
            Log.d(TAG, "showData: email: " + uInfo.getEmail());
            Log.d(TAG, "showData: alamat: " + uInfo.getAlamat());
            Log.d(TAG, "showData: ukm: " + uInfo.getUkm());
            Log.d(TAG, "showData: alasan: " + uInfo.getAlasan());

            ArrayList<String> array  = new ArrayList<>();
            array.add(uInfo.getNamadepan());
            array.add(uInfo.getNamabelakang());
            array.add(uInfo.getTelepon());
            array.add(uInfo.getEmail());
            array.add(uInfo.getAlamat());
            array.add(uInfo.getUkm());
            array.add(uInfo.getAlasan());
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);
        }
    }


    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}









