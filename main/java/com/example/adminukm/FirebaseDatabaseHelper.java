package com.example.adminukm;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private DatabaseReference mReferenceRequests;
    private FirebaseDatabase mDatabase;
    private List<Request> requests = new ArrayList<>();

    public void update(String key, Request requests, DataStatus data_update) {
    }

    public void delete(String key, DataStatus data_delete) {
    }

    public interface DataStatus {
        void dataIsLoad(List<Request> requests, List<String> keys);

        void dataIsUpdate();

        void dataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceRequests = mDatabase.getReference("RequestData");
    }

    public void readRequests(final DataStatus dataStatus) {
        mReferenceRequests.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                requests.clear();
                ArrayList<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Request request = keyNode.getValue(Request.class);
                    requests.add(request);
                }
                dataStatus.dataIsLoad(requests, keys);
            }
            public void updateAnggota(String key,Request Data, final DataStatus dataStatus)
            {
                mReferenceRequests.child(key).setValue(requests)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                        public void onSuccess(Void aVoid) { dataStatus.dataIsUpdate();
                            } });
            }
            public void deleteAnggota(String key,final DataStatus dataStatus) {
                mReferenceRequests.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) { dataStatus.dataIsDeleted();
                    } });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}