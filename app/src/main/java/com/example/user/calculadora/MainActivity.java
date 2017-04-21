package com.example.user.calculadora;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private TextView edit;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button bMas;
    private Button bMenos;
    private Button bMultiplicar;
    private Button bDividir;
    private Button bIgual;
    private Button bCE;
    private Button raiz;
    private Button porcentaje;

    private int valor;
    private double valord;
    private int operacion;

    private boolean nuevoValor = true;

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().hide();
            setContentView(R.layout.activity_main);
            valord = 0.0;
            valor = 0;

            edit = (TextView) findViewById(R.id.resultado);
            b0 = (Button) findViewById(R.id.btn0);
            b1 = (Button) findViewById(R.id.btn1);
            b2 = (Button) findViewById(R.id.btn2);
            b3 = (Button) findViewById(R.id.btn3);
            b4 = (Button) findViewById(R.id.btn4);
            b5 = (Button) findViewById(R.id.btn5);
            b6 = (Button) findViewById(R.id.btn6);
            b7 = (Button) findViewById(R.id.btn7);
            b8 = (Button) findViewById(R.id.btn8);
            b9 = (Button) findViewById(R.id.btn9);
            bMas = (Button) findViewById(R.id.btnmas);
            bMenos = (Button) findViewById(R.id.btnmenos);
            bMultiplicar = (Button) findViewById(R.id.btnpor);
            bDividir = (Button) findViewById(R.id.btndivision);
            bIgual = (Button) findViewById(R.id.btnigual);
            bCE = (Button) findViewById(R.id.btnCE);
            raiz = (Button) findViewById(R.id.btnRaiz);
            porcentaje = (Button) findViewById(R.id.btn7porcentaje);


            edit.setText("0");

            View.OnClickListener lsBoton = new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    edit.setTextColor(Color.BLACK);
                    cambiaValor();
                    edit.setText(edit.getText() + ((Button) arg0).getText().toString());
                }
            };

            View.OnClickListener lsBotonOperacion = new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    opera();
                    operacion = 0;
                    nuevoValor = true;
                    String text = ((Button) arg0).getText().toString();
                    if (text.equals("+")) operacion = 0;
                    if (text.equals("-")) operacion = 1;
                    if (text.equals("*")) operacion = 2;
                    if (text.equals("/")) operacion = 3;
                    if (text.equals("=")) operacion = -1;
                    if (text.equals("r")) operacion = 4;
                    if (text.equals("%")) operacion = 5;
                }
            };

            b1.setOnClickListener(lsBoton);
            b2.setOnClickListener(lsBoton);
            b3.setOnClickListener(lsBoton);
            b4.setOnClickListener(lsBoton);
            b5.setOnClickListener(lsBoton);
            b6.setOnClickListener(lsBoton);
            b7.setOnClickListener(lsBoton);
            b8.setOnClickListener(lsBoton);
            b9.setOnClickListener(lsBoton);
            b0.setOnClickListener(lsBoton);

            bMas.setOnClickListener(lsBotonOperacion);
            bMenos.setOnClickListener(lsBotonOperacion);
            bMultiplicar.setOnClickListener(lsBotonOperacion);
            bDividir.setOnClickListener(lsBotonOperacion);
            bIgual.setOnClickListener(lsBotonOperacion);
            raiz.setOnClickListener(lsBotonOperacion);
            porcentaje.setOnClickListener(lsBotonOperacion);

            bCE.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    edit.setText("0");
                    nuevoValor = true;
                    operacion = -1;
                }
            });

        }

        private void cambiaValor() {
            if (nuevoValor == true) {
                edit.setText("");
                nuevoValor = false;
            }
        }

        private void opera() {
            switch (operacion) {
                case -1:
                    valor = Integer.parseInt(edit.getText().toString());
                    break;
                case 0:    // suma
                    try {
                        valor = valor + Integer.parseInt(edit.getText().toString());
                        edit.setText(String.valueOf(valor));
                    } catch (Exception e) {

                    }
                    break;

                case 1:    // resta
                    try {
                        valor = valor - Integer.parseInt(edit.getText().toString());
                        edit.setText(String.valueOf(valor));
                    } catch (Exception e) {

                    }
                    break;
                case 2:    // multiplicar
                    try {
                        valor = valor * Integer.parseInt(edit.getText().toString());
                        edit.setText(String.valueOf(valor));
                    } catch (Exception e) {

                    }
                    break;

                case 3:    // dividir
                    try {
                        valor = valor / Integer.parseInt(edit.getText().toString());
                        edit.setText(String.valueOf(valor));
                    } catch (Exception e) {
                        edit.setTextColor(Color.RED);
                        edit.setText("Error");
                    }
                    break;

                case 4:    // raiz
                    try {
                        valord = Math.sqrt(Integer.parseInt(edit.getText().toString())); ;
                        edit.setText(String.valueOf(valord));
                    } catch (Exception e) {
                        edit.setTextColor(Color.RED);
                        edit.setText("Err");
                    }
                    break;

                case 5:    // porcentaje
                    try {
                        valord =  Integer.parseInt(edit.getText().toString())/ 100;
                        edit.setText(String.valueOf(valord));
                    } catch (Exception e) {
                        edit.setTextColor(Color.RED);
                        edit.setText("Err");
                    }
                    break;
            }

        }
    }
