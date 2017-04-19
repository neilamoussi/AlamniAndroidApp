package alemni.gl4.insat.tn.alemni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

import alemni.gl4.insat.tn.alemni.model.Quiz;
import android.widget.ListView;

public class AddQuizActivity extends AppCompatActivity {

    EditText edt_datel,edt_heure,edt_nom;
    Button btn_add,btn_reset;
    Firebase ref;
    Spinner spinnerg,spinnerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz);

        Firebase.setAndroidContext(this);

        ref = new Firebase("https://myproject-bf8ad.firebaseio.com/");


        String format = "dd/MM/yy ";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        final java.util.Date date = new java.util.Date();

        edt_datel = (EditText)findViewById(R.id.edt_datel);
        edt_heure = (EditText)findViewById(R.id.edt_heure);
        edt_nom = (EditText)findViewById(R.id.edt_nom);

        spinnerg = (Spinner) findViewById(R.id.spinner);

        List exempleList = new ArrayList();
        exempleList.add("Assinie");
        exempleList.add("Bassam");
        exempleList.add("Abidjan");


        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleList
        );



        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerg.setAdapter(adapter);

        spinnerm = (Spinner) findViewById(R.id.spinner1);

        List exempleList1 = new ArrayList();
        exempleList.add("Assinie");
        exempleList.add("Bassam");
        exempleList.add("Abidjan");


        ArrayAdapter adapter1 = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                exempleList
        );



        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerm.setAdapter(adapter);

        final  Firebase reff = ref.child("quizs").push();

       /* btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nom = edt_nom.getText().toString();

                final String datel = edt_datel.getText().toString();
                final String heure = edt_heure.getText().toString();
                final String matiere = edt_matiere.getText().toString();
                final String groupe = edt_groupe.getText().toString();

               // Quiz u = new Quiz(nom, 0, date, "oui", heure, 0);
            }
                });*/


            }
}
