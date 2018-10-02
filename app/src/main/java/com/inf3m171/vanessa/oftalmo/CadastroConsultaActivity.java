package com.inf3m171.vanessa.oftalmo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inf3m171.vanessa.oftalmo.model.Consultas;

public class CadastroConsultaActivity extends AppCompatActivity {
    private EditText etData;
    private Spinner spMedico, spHora;
    private Button btnAgendarConsulta;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_consulta);


        etData = (EditText) findViewById(R.id.etData);
        spMedico = (Spinner) findViewById(R.id.spMedico);
        spHora = (Spinner) findViewById(R.id.spHora);
        btnAgendarConsulta = (Button) findViewById(R.id.btnAgendar);


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        btnAgendarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarConsulta();
            }
        });
    }


    private void cadastrarConsulta() {
        Consultas consulta = new Consultas();


        String medico = spMedico.getSelectedItem().toString();
        String hora = spHora.getSelectedItem().toString();
        String data = etData.getText().toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        consulta.setMedico(medico);
        consulta.setData(data);
       // consulta.setIdPaciente(user.getUid());
        consulta.setHora(hora);


        reference.child("consultas").push().setValue(consulta);
        Toast.makeText(this, "Consulta salva com sucesso!", Toast.LENGTH_LONG);

        etData.setText("");
        spHora.setSelection(0);
        spMedico.setSelection(0);

    }
}

