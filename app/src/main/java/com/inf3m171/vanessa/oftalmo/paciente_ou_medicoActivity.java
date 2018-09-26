package com.inf3m171.vanessa.oftalmo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paciente_ou_medicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_ou_medico);

        Button BotaoPaciente = (Button) findViewById(R.id.btnPaciente);

        BotaoPaciente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(paciente_ou_medicoActivity.this, LoginActivity.class);
                it.putExtra("tipo", "p");
                startActivity(it);
            }
        });



        Button BotaoMedico = (Button) findViewById(R.id.btnMedico);

        BotaoMedico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(paciente_ou_medicoActivity.this, LoginActivity.class);
                it.putExtra("tipo", "m");
                startActivity(it);
            }
        });
    }
}
