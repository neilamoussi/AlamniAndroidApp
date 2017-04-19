package alemni.gl4.insat.tn.alemni;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import alemni.gl4.insat.tn.alemni.model.Student;

import static alemni.gl4.insat.tn.alemni.R.id.edt_name;

public class SignupEtudActivity extends AppCompatActivity {
    Button btn_signup;
    EditText edt_grp;
    EditText edt_mat;
    EditText edt_loc;
    EditText edt_loginprof;
    Firebase ref;
    ProgressDialog PD;

    //  final boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_etud);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        String a="";
        edt_grp = (EditText) findViewById(R.id.edt_grp);
        edt_loc = (EditText) findViewById(R.id.edt_loc);
        edt_mat = (EditText) findViewById(R.id.edt_mat);
        edt_loginprof = (EditText) findViewById(R.id.edt_loginprof);

        final Firebase refetud=ref.child("etudiants").push();
        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();
                final String grp = edt_grp.getText().toString();
                final String loc = edt_loc.getText().toString();
                final String mat = edt_mat.getText().toString();
                final String loginprof= edt_loginprof.getText().toString();

                Intent intent = getIntent();
                final Student etu = (Student) intent.getSerializableExtra("etud");
                final String nometu = etu.getNom();


                // Toast.makeText(getApplicationContext(), keygrp, Toast.LENGTH_SHORT).show();

                if (grp.isEmpty()) {
                    edt_grp.setError("Veuilez entrer un groupe");
                }
                if (loc.isEmpty()) {
                    edt_loc.setError("Veuilez entrer une localite");
                }
                if (mat.isEmpty()) {
                    edt_mat.setError("Veuilez entrer une matiere");
                }
                if (loginprof.isEmpty()) {
                    edt_loginprof.setError("Veuilez entrer un login  valide du professeur ");
                }

                if (!grp.isEmpty() && !loc.isEmpty() && !mat.isEmpty() && !loginprof.isEmpty()) {
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        /***********************
                         *
                         *if (name.equals(dataSnapshot.child("professeurs").child(name).child("login").getValue())
                         && pass.equals(dataSnapshot.child("professeurs").child(name).child("password").getValue())) {
                         */
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Boolean b = false;
                            Boolean mt = false;
                            Boolean mtgrp=false;
                            String keymat = "";
                            String keygroupe = "";
                            DataSnapshot d = null;
                            //verifier que la combonaison de nom groupr et localite existe
                            for (DataSnapshot data : dataSnapshot.child("groupes").getChildren()) {
                                // keygroupee = data.getKey();
                                //  String keygrp = data.child("matieres").getValue().toString();


                                if (b == false) {
                                    if (data.child("nom").getValue().toString().equals(grp) && data.child("localite").getValue().toString().equals(loc)) {
                                        //keygroupee = data.getKey();
                                        d = data;
                                        keygroupe = data.getKey();
                                        b = true;
                                    }
                                }

                                if (b == true)

                                { break;}
                            }

                            if (b == false) {
                                Toast.makeText(getApplicationContext(), "Groupe Saisit n'existe pas  ", Toast.LENGTH_SHORT).show();
                            } else

                            {
                                for (DataSnapshot datamat : dataSnapshot.child("matiere").getChildren()) {


                                    if (mt == false) {
                                        if (datamat.child("nom").getValue().toString().equals(mat)) {

                                            mt = true;
                                            keymat = datamat.getKey();
                                        }
                                    }
                                    if (mt == true)

                                    {  break;}

                                }


                                if (mt == false) {
                                    Toast.makeText(getApplicationContext(), "matiere n'existe pas", Toast.LENGTH_SHORT).show();
                                } else {
                              // String a=  ref.child("matiere").child(keymat).child("groupes")..toString();
//                             //       Toast.makeText(getApplicationContext(), keymat, Toast.LENGTH_SHORT).show();
//
                                //   Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();

                                    for (DataSnapshot datamatgrp : dataSnapshot.child("matiere").child(keymat).child("groupes").getChildren()){


                                      if (mtgrp == false) {
                                       if (datamatgrp.getKey().equals(keygroupe)) {
                                        mtgrp = true;
                                          }
                                         }
                                        if (mtgrp == true)
//
                                        {  break;}

                                      }
                                    if (mtgrp == true)
                                    {  Toast.makeText(getApplicationContext(), "Registration:\"veillez attender que votre professeur accepte votre demande \" ", Toast.LENGTH_SHORT).show();
                                        if (loginprof.equals(dataSnapshot.child("professeurs").child(loginprof).child("login").getValue()))
                                        {   Toast.makeText(getApplicationContext(),dataSnapshot.child("professeurs").child(loginprof).child("login").getValue().toString() , Toast.LENGTH_SHORT).show();

                                            Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                                            startActivity(intent2);

                                            ref.child("etudiants").child(etu.getLogin()).setValue(etu);

                                        }

                                     //   ref.child("etudiants").child(etu.getLogin()).child("groupes").setValue(keygroupe);


                                    }
                                   // if(mtgrp==true)
                                    /*{
                                        ref.child("etudiants").child(etu.getLogin()).child("groupes").child(keygroupe).setValue(true);
                                        PD.dismiss();
                                        Toast.makeText(getApplicationContext(), "veillez attender que votre professeur accepte votre demande " + nometu + "",
                                                Toast.LENGTH_SHORT).show();*/

                                   // }

                                        if (mtgrp == false)
                                         {  Toast.makeText(getApplicationContext(), "sorry", Toast.LENGTH_SHORT).show();
                                       }



                                    /*String o = ref.child("groupes").child(keygroupe).child("matieres").child(keymat).toString();
                                    Toast.makeText(getApplicationContext(),o, Toast.LENGTH_SHORT).show();

                                    if (!o.equals(null) ) {
                                        // Toast.makeText(getApplicationContext(), "olalaaaa it's " + nometu + "", Toast.LENGTH_SHORT).show();

                                        ref.child("etudiants").child(etu.getLogin()).setValue(etu);

                                        ref.child("etudiants").child(etu.getLogin()).child("groupes").child(keygroupe).setValue
                                                (true, new Firebase.CompletionListener() {
                                                    @Override
                                                    public void onComplete(FirebaseError error, Firebase firebase) {
                                                        if (error != null) {
                                                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                                                        }
                                                        PD.dismiss();
                                                    }

                                                });
                                        PD.dismiss();
                                        Toast.makeText(getApplicationContext(), "veillez attender que votre professeur accepte votre demande " + nometu + "",
                                                Toast.LENGTH_SHORT).show();

                                        Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent2);

                                    } else {
                                        Toast.makeText(getApplicationContext(), "la matiére n'existe pas dans cette groupe ", Toast.LENGTH_LONG).show();

                                    }

                                    PD.dismiss();*/
                                }

                            }



                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }
            }









        });
    }}