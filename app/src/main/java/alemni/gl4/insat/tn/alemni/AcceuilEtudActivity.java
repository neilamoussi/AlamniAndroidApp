package alemni.gl4.insat.tn.alemni;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

import alemni.gl4.insat.tn.alemni.model.Student;

public class AcceuilEtudActivity extends AppCompatActivity {
    Button btn_ajpub;
    Firebase ref;
    ProgressDialog PD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_etud);
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        btn_ajpub = (Button) findViewById(R.id.btn_ajpub);
        btn_ajpub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();
                Intent intent2 =getIntent();
                final Student eetudacceuil =(Student)intent2.getSerializableExtra("etudacceuil");
                final     String nometu=eetudacceuil.getNom();

           Toast.makeText(getApplicationContext(), nometu, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getApplicationContext(), EspaceEtudiantActivity.class);
                intent3.putExtra("etudacceuil", eetudacceuil);
                startActivity(intent3);


            }
    });
}}
