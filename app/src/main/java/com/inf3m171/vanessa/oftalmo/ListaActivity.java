package com.inf3m171.vanessa.oftalmo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.inf3m171.vanessa.oftalmo.model.Consultas;
import com.inf3m171.vanessa.oftalmo.model.Medico;
import com.inf3m171.vanessa.oftalmo.model.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaActivity extends AppCompatActivity {
    private ListView lvconsultas;
    private List<Consultas> listadeConsultas;
    private ArrayAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private Query queryRef;
    private ChildEventListener childEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);




        lvconsultas= (ListView)findViewById(R.id.lvConsultas);
        listadeConsultas = new ArrayList<>();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listadeConsultas);
        lvconsultas.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();




    }


    @Override
    protected void onStart() {
        super.onStart();
        queryRef = reference.child("consultas").orderByChild("nome");
        listadeConsultas.clear();





        childEventListener = new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Consultas consulta = new Consultas();
                consulta.setId(dataSnapshot.getKey());
                consulta.setPaciente(dataSnapshot.child("paciente").getValue(String.class));
                consulta.setData(dataSnapshot.child("data").getValue(String.class));
                consulta.setHora(dataSnapshot.child("hora").getValue(String.class));
                consulta.setMedico(dataSnapshot.child("medico").getValue(String.class));

                listadeConsultas.add(consulta);




                adapter.notifyDataSetChanged();





            }




            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        queryRef.addChildEventListener(childEventListener);



    }

    @Override
    protected void onStop() {
        super.onStop();

        queryRef.removeEventListener(childEventListener);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Sair");
        menu.add("Cadastrar Consulta");

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if ( item.toString().equals("Sair")){
            FirebaseAuth.getInstance().signOut();
            finish();
        }if(item.toString().equals("Cadastrar Consulta")){
            Intent i = new Intent(ListaActivity.this, CadastroConsultaActivity.class);
             startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
