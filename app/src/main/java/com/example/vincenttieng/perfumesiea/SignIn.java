package com.example.vincenttieng.perfumesiea;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vincenttieng.perfumesiea.Model.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import io.paperdb.Paper;

public class SignIn extends AppCompatActivity {

    EditText edtPseudo, edtPassword;
    Button btnSignIn;
    CheckBox ckbRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtPseudo =(MaterialEditText)findViewById(R.id.edtPseudo);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        ckbRemember =(CheckBox)findViewById(R.id.ckbRemember);

        Paper.init(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(edtPseudo.getText().toString()).exists()){
                            mDialog.dismiss();
                            Client client = dataSnapshot.child(edtPseudo.getText().toString()).getValue(Client.class);
                            if (client.getPassword().equals(edtPassword)){
                                Intent homeIntent = new Intent(SignIn.this, MainActivity.class);
                                Common.currentUser = client;
                                startActivity(homeIntent);
                                finish();
                            }
                        }else {
                            Toast.makeText(SignIn.this, "Pseudo didn't found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
