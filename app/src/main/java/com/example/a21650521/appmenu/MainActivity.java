package com.example.a21650521.appmenu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout clCont;
    Button botonPulsame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clCont = (ConstraintLayout)findViewById(R.id.idContenedor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            Toast.makeText(this, "Se ha pulsado el botón settings del menú", Toast.LENGTH_LONG).show();
            crearDialogo("Cristobal es una putilla").show();
        clCont.setBackgroundColor(Color.WHITE);
        }
        else if(item.getItemId() == R.id.menu_green){
            clCont.setBackgroundColor(Color.GREEN);
            crearDialogo("Se ha seleccionado el menu verde").show();
        }
        else if(item.getItemId() == R.id.menu_rojo){
            clCont.setBackgroundColor(Color.RED);
            crearDialogo("Se ha seleccionado el menu rojo").show();
        }
        else if(item.getItemId() == R.id.menu_salir){
            clCont.setBackgroundColor(Color.RED);
            crearDialogo().show();
        }
        return(true);
    }

    private Dialog crearDialogo(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(msg);

        return builder.create();
    }
    private Dialog crearDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setMessage("¿Desea reiniciar el contador?");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}
