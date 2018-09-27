package com.inf3m171.vanessa.oftalmo;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.inf3m171.vanessa.oftalmo.model.Paciente;

public class CadastroActivity extends AppCompatActivity {


    private EditText etNome, etEmail, etSenha, etConfirma;
    private Button btnSalvar;
    private FirebaseAuth autenticacao;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private String erro = "";
    private String tipo;
    private EditText etSenhaAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        etNome = (EditText) findViewById(R.id.etNome);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etConfirma=(EditText) findViewById(R.id.etConfirmaSenha);
        btnSalvar = (Button) findViewById(R.id.btnSalvar2);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipo.equals("p")) {
                    criarPaciente();

                }else{
                    criarMedico();
                }

            }
        });

       etSenhaAdmin = (EditText) findViewById(R.id.etSenhaAdmin);
        tipo = getIntent().getStringExtra("tipo");

        if (tipo.equals("p")) {
            etSenhaAdmin.setVisibility(View.INVISIBLE);

        }
    }
    private void criarPaciente() {
        String senha = etSenha.getText().toString();
        String confirma = etConfirma.getText().toString();
        final String email = etEmail.getText().toString();

        if (!senha.isEmpty() && senha.equals(confirma) && !email.isEmpty()) {
            autenticacao = FirebaseAuth.getInstance();

            autenticacao.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                database = FirebaseDatabase.getInstance();
                                String id = autenticacao.getCurrentUser().getUid();
                                reference = database.getReference("usuarios").child(id);
                                reference.child("nome").setValue(etNome.getText().toString());
                                reference.child("email").setValue(email);
                                reference.child("admin").setValue(false);

                            } else {
                                erro = "Não foi possível criar usuário!";
                            }
                        }
                    });
        } else {
            erro = "O campo e-mail deve ser preenchido e os campos de senha devem ser iguais!";
        }
        if (!erro.isEmpty()) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Atenção");
            alerta.setMessage(erro);
            alerta.setNeutralButton("ok", null);
        } else {
            finish();
        }
    }

    private void criarMedico(){
        String senha = etSenha.getText().toString();
        String confirma = etConfirma.getText().toString();
        final String email = etEmail.getText().toString();
        String senhaAdmin = etSenhaAdmin.getText().toString();

        if(!senha.isEmpty()&& senha.equals(confirma) && !email.isEmpty() && senhaAdmin.equals("123456")){
            autenticacao = FirebaseAuth.getInstance();

            autenticacao.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                database = FirebaseDatabase.getInstance();
                                String id = autenticacao.getCurrentUser().getUid();
                                reference = database.getReference("usuarios").child(id);
                                reference.child("nome").setValue(etNome.getText().toString());
                                reference.child("email").setValue(email);
                                reference.child("admin").setValue(true);

                            } else {
                                erro = "Não foi possível criar usuário!";
                            }
                        }
                    });

        }else{
            erro = "O campo e-mail deve ser preenchido e os campos de senha devem ser iguais!";
        }
        if(!erro.isEmpty()){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Atenção");
            alerta.setMessage(erro);
            alerta.setNeutralButton("ok", null);
        }else{
            finish();
        }
    }
    }



