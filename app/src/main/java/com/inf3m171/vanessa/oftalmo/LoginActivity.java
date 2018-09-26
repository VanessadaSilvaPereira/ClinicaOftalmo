package com.inf3m171.vanessa.oftalmo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private String tipo;
    private EditText etLogin, etSenha;
    private Button btnEntrar, btnCadastro;
    private FirebaseAuth autenticação;
    private FirebaseAuth.AuthStateListener stateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);

        autenticação = FirebaseAuth.getInstance();


        tipo = getIntent().getStringExtra("tipo");

        Button btnCadastro = (Button) findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
                it.putExtra("tipo", tipo);
                startActivity(it);
                entrar();
            }
        });



        }


    private void entrar(){
        String email = etLogin.getText().toString();
        String senha = etSenha.getText().toString();
        if(!email.isEmpty())
            autenticação.signInWithEmailAndPassword(email,senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
    }

}







