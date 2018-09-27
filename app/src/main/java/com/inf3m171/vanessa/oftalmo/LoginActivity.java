package com.inf3m171.vanessa.oftalmo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private String tipo;
    private EditText etLogin, etSenha;
    private Button btnEntrar, btnCadastro;
    private FirebaseAuth autenticacao;
    private FirebaseAuth.AuthStateListener stateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);

        autenticacao = FirebaseAuth.getInstance();


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

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
        entrar();


        }


    //@Override
   // protected void onStart() {
       // super.onStart();
       // autenticacao.addAuthStateListener(stateListener);
  //  }

   // @Override
   // protected void onStop() {
       // super.onStop();
       // if (stateListener != null){
            //autenticacao.removeAuthStateListener(stateListener);
        //}
   // }


    private void entrar(){
        String email = etLogin.getText().toString();
        String senha = etSenha.getText().toString();
        if(!email.isEmpty())
            autenticacao.signInWithEmailAndPassword(email,senha)
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







