package com.example.estudoswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private Switch   seletor;
    private Button   botao;
    private Button   botaoDec;
    private Button   botaoSomar;
    private TextView textonum;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.textView);
        seletor = findViewById(R.id.switch1);
        botao = findViewById(R.id.button);
        textonum = findViewById(R.id.TextNum);
        botaoSomar = findViewById(R.id.buttonImp);
        botaoDec = findViewById(R.id.buttonDec);


        seletor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                texto.setText(converterParaTexto(isChecked));
            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, converterParaTexto(seletor.isChecked()), Toast.LENGTH_SHORT).show();
            }
        });

        botaoSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textonum.setText(String.valueOf(count));
                Toast.makeText(MainActivity.this, ""+count, Toast.LENGTH_LONG).show();
            }
        });

        botaoDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                textonum.setText(String.valueOf(count));
                Toast.makeText(MainActivity.this, ""+count, Toast.LENGTH_LONG).show();
            }
        });


    }

    private String converterParaTexto(boolean isChecked) {
        String textoExibir = "";
        if(isChecked) {
            textoExibir = "Ligado";
        } else {
            textoExibir = "Desligado";
        }

        return textoExibir;
    }
}
