package alemni.gl4.insat.tn.alemni;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import alemni.gl4.insat.tn.alemni.model.Professor;
import alemni.gl4.insat.tn.alemni.model.Student;

import static alemni.gl4.insat.tn.alemni.R.id.edt_name;


public class MainActivity extends AppCompatActivity {

    EditText edt_nom,edt_mail,edt_pass,edt_prenom,edt_login;
    Button btn_suiv;
    Firebase ref;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");

        edt_nom = (EditText)findViewById(R.id.edt_nom);
        edt_mail = (EditText)findViewById(R.id.edt_mail);
        edt_pass = (EditText)findViewById(R.id.edt_pass);
        edt_prenom = (EditText)findViewById(R.id.edt_pre);

        edt_login = (EditText)findViewById(edt_name);
        btn_suiv = (Button)findViewById(R.id.btn_suiv);


        btn_suiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();
                final String nom = edt_nom.getText().toString();
                final String prenom = edt_prenom.getText().toString();
                final String login = edt_login.getText().toString();
                final String email = edt_mail.getText().toString();
                final String pass = edt_pass.getText().toString();


                String s = getIntent().getStringExtra("cle");
                /*Student e =(Student) getIntent().getSerializableExtra("etud");
                Toast.makeText(getApplicationContext(), e.getNom(), Toast.LENGTH_SHORT).show();*/

                if (s.equals("1"))

                {

                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Boolean b = false;

                            if (nom.isEmpty() || nom.length() < 3) {
                                edt_nom.setError(" au moins 3 caractÃ©res");
                            }
                            if (prenom.isEmpty() || prenom.length() < 3) {
                                edt_prenom.setError("au moins 3 caractÃ©res");
                            }

                            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                edt_mail.setError("veuillez entrer un email valide");
                            }
                            if (pass.isEmpty() || pass.length() < 4 || pass.length() > 10) {
                                edt_pass.setError("entre 4 et 10 caractÃ©res alphanumÃ©riques");
                            }

                            if (login.isEmpty() || login.length() < 3) {
                                edt_login.setError("au moins 3 caractÃ©res");
                            } else if (!login.isEmpty()&& !nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !pass.isEmpty()) {
                                for (DataSnapshot data : dataSnapshot.child("etudiants").getChildren()) {

                                    if (b == false) {
                                        if (data.child("login").getValue().toString().equals(login)) {

                                            b = true;
                                        }
                                    }
                                    if (b == true)
                                    {  break;}

                                }
                                if (b==true)
                                {edt_login.setError("Login existe dÃ©ja");}
                                if (b == false) {
                                    Student st = new Student(email, login, nom, prenom, pass, "non");
                                    Intent intent = new Intent(getApplicationContext(), SignupEtudActivity.class);
                                    intent.putExtra("etud", st);
                                    startActivity(intent);
                                }


                            }
                            PD.dismiss();
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });


                } else {
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Boolean b = false;

                            if (nom.isEmpty() || nom.length() < 3) {
                                edt_nom.setError("au moins 3 caractÃ©res");
                            }
                            if (prenom.isEmpty() || prenom.length() < 3) {
                                edt_prenom.setError("au moins 3 caractÃ©res");
                            }


                            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                edt_mail.setError("veuillez entrer un email valide");
                            }
                            if (pass.isEmpty() || pass.length() < 4 || pass.length() > 10) {
                                edt_pass.setError("entre 4 et 10 caractÃ©res alphanumÃ©riques");
                            }

                            if (login.isEmpty() || login.length() < 3) {
                                edt_login.setError("au moins 3 caractÃ©res");
                            } else if (!login.isEmpty() && !nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !pass.isEmpty()) {
                                for (DataSnapshot data : dataSnapshot.child("professeurs").getChildren()) {

                                    if (b == false) {
                                        if (data.child("login").getValue().toString().equals(login)) {

                                            b = true;
                                        }
                                    }
                                    if (b == true)
                                        break;
                                }
                                if (b == false) {
                                    Professor p = new Professor(prenom, nom, email, login, pass);
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("prof", p);
                                    startActivity(intent);
                                }


                            }
                            PD.dismiss();
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });


                }





            }
        });
    }
}






