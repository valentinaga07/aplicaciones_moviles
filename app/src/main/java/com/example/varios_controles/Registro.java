package com.example.varios_controles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registro extends AppCompatActivity {

    private EditText eT_nombre_m;
    private RadioButton rb_perro, rb_gato;
    private Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eT_nombre_m = (EditText) findViewById(R.id.eT_nombre_m);
        rb_perro = (RadioButton) findViewById(R.id.rB_perro);
        rb_gato = (RadioButton) findViewById(R.id.rB_gato);
    }

    public void total_pago(View v) {
        String nombre = eT_nombre_m.getText().toString();
        String tipo_m;

        if (rb_perro.isChecked()==true) {
            tipo_m = "perro";
        } else {
            tipo_m = "gato";
        }

        Mascota m1 = new Mascota(nombre, tipo_m);
        double pago = m1.pago();

        Intent resultado_pago = new Intent(this, Pago.class);
        resultado_pago.putExtra("pago", pago);
        startActivity(resultado_pago);
    }
}