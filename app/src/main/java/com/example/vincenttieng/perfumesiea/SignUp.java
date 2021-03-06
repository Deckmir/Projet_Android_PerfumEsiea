package com.example.vincenttieng.perfumesiea;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vincenttieng.perfumesiea.Model.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtFirstName, edtName,edtPassword, edtPseudo;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName = (MaterialEditText)findViewById(R.id.edtName);
        edtFirstName = (MaterialEditText)findViewById(R.id.edtPrenom);
        edtPseudo = (MaterialEditText)findViewById(R.id.edtPseudo);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtPseudo.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "The Pseudo already exist, please choose another one", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();
                            Client nouveauClient = new Client(edtName.getText().toString(), edtFirstName.getText().toString(), edtPassword.getText().toString());
                            table_user.child(edtPseudo.getText().toString()).setValue(nouveauClient);
                            Toast.makeText(SignUp.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                            finish();
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
