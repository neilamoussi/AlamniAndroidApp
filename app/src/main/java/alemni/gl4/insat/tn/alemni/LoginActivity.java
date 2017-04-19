package alemni.gl4.insat.tn.alemni;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import android.content.Intent;

import alemni.gl4.insat.tn.alemni.model.Student;

public class LoginActivity extends AppCompatActivity {

    EditText edt_name,edt_pass;
    TextView linke,linkp;
    Button btn_signin;
    Firebase ref;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");

        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_pass = (EditText)findViewById(R.id.edt_pass);
        btn_signin = (Button)findViewById(R.id.btn_reg);

        linke = (TextView)findViewById(R.id.link_Etudiant);
        linkp = (TextView)findViewById(R.id.link_prof);
        linke.setPaintFlags(linke.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        linke.setText("Compte Etudiant");
        linke.setTypeface(null, Typeface.BOLD);
        linkp.setPaintFlags(linkp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        linkp.setText("Compte Professeur");
        linkp.setTypeface(null, Typeface.BOLD);




        linke.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("cle", "1");
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


        linkp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("cle", "2");
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();
                final String name = edt_name.getText().toString();
                final String pass = edt_pass.getText().toString();

        if (pass.isEmpty() ) { edt_pass.setError("Vous devez entrer un mot de passe valide");  }
                if (name.isEmpty() ) { edt_name.setError("Vous devez entrer un login valide");  }
                if (name.isEmpty() && pass.isEmpty() ) { edt_name.setError("Vous devez entrer un login  valide");edt_pass.setError("Vous devez entrer un mot de passe valide");  }

                PD.dismiss();
            if (!name.isEmpty() && !pass.isEmpty() ) {
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        if (name.equals(dataSnapshot.child("professeurs").child(name).child("login").getValue())
                                && pass.equals(dataSnapshot.child("professeurs").child(name).child("password").getValue())) {
                            // String cle=(String) dataSnapshot.child("users").child(name).getKey();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            // Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

                            //   ref.child("users").child(name).removeValue();

                            // ref.child("users").child(cle).child("email").setValue("gdf@gmail.com");

                        } else if (name.equals(dataSnapshot.child("etudiants").child(name).child("login").getValue())
                                && pass.equals(dataSnapshot.child("etudiants").child(name).child("password").getValue())
                                && dataSnapshot.child("etudiants").child(name).child("accepte").getValue().equals("oui")) {
                                  Student etu0 = new Student("", name, "", "", pass, "oui");
                            Intent intent0 = new Intent(getApplicationContext(), AcceuilEtudActivity.class);
                            intent0.putExtra("etu0", etu0);
                            startActivity(intent0);

                        } else if (name.equals(dataSnapshot.child("etudiants").child(name).child("login").getValue())
                                && pass.equals(dataSnapshot.child("etudiants").child(name).child("password").getValue())
                                && dataSnapshot.child("etudiants").child(name).child("accepte").getValue().equals("non")) {

                            AlertDialog.Builder builder = new AlertDialog.Builder(
                                    LoginActivity.this);
            builder.setTitle("Sample Alert");
                            builder.setMessage("Non accepté");
                            builder.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                          //  Toast.makeText(getApplicationContext(),"Yes success",Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        }
                                    });
                            builder.show();
                           // Toast.makeText(getApplicationContext(), "Pas encore accepté", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getApplicationContext(), "Données incorrectes", Toast.LENGTH_SHORT).show();
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