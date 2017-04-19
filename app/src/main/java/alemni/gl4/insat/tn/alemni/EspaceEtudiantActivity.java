package alemni.gl4.insat.tn.alemni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import alemni.gl4.insat.tn.alemni.model.Student;

public class EspaceEtudiantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_etudiant);
        Intent intent3 =getIntent();
        final Student eetudacceuil =(Student)intent3.getSerializableExtra("etudacceuil");
        final     String nometu=eetudacceuil.getNom();
        Toast.makeText(getApplicationContext(), nometu, Toast.LENGTH_SHORT).show();

    }
}
