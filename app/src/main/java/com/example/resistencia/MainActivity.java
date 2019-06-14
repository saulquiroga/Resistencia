package com.example.resistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner banda1,banda2,multiplicador,tolerancia;
    public EditText pant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banda1=(Spinner) findViewById(R.id.banda1);
        banda2=(Spinner) findViewById(R.id.banda2);
        multiplicador=(Spinner) findViewById(R.id.multiplicador);
        tolerancia=(Spinner) findViewById(R.id.tolerancia);
        Button calcular=findViewById(R.id.button2);
        pant=(EditText)findViewById(R.id.resultado);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.banda1,android.R.layout.simple_spinner_item);
        banda1.setAdapter(adapter);
        banda2.setAdapter(adapter);
        multiplicador.setAdapter(adapter);
        ArrayAdapter<CharSequence> adptoler= ArrayAdapter.createFromResource(this,R.array.tolerancia,android.R.layout.simple_spinner_item);
        tolerancia.setAdapter(adptoler);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bd1= banda1.getSelectedItem().toString();
                String bd2=banda2.getSelectedItem().toString();
                String mlt=multiplicador.getSelectedItem().toString();
                String tol=tolerancia.getSelectedItem().toString();
                String pan="";
                pant.setText(pan+=resistencia(bd1));
                pant.setText(pan+=resistencia(bd2));
                if(mlt.equals("negro")){ pan=(1*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("cafe")){ pan=(10*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("rojo")){ pan=(100*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("naranja")){ pan=(1000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("amarillo")){ pan=(10000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("verde")){ pan=(100000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("azul")){ pan=(1000000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("violeta")){ pan=(10000000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("gris")){ pan=(100000000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(mlt.equals("blanco")){ pan=(1000000000*Double.parseDouble(pan))+""; pant.setText(pan);};
                if(tol.equals("dorado")){pant.setText(pan+" Ω ±5%");}
                if(tol.equals("rojo")){pant.setText(pan+" Ω ±2%");}
                if(tol.equals("plata")){pant.setText(pan+" Ω ±10%");}
            }
        });
    }

    public String resistencia(String dato){
        if(dato.equals("negro")){
            dato="0";
        }
        if(dato.equals("cafe")){
            dato="1";
        }
        if(dato.equals("rojo")){
            dato="2";
        }
        if(dato.equals("naranja")){
            dato="3";
        }
        if(dato.equals("amarillo")){
            dato="4";
        }
        if(dato.equals("verde")){
            dato="5";
        }
        if(dato.equals("azul")){
            dato="6";
        }
        if(dato.equals("violeta")){
            dato="7";
        }
        if(dato.equals("gris")){
            dato="8";
        }
        if(dato.equals("blanco")){
            dato="9";
        }
        return dato;
    }
}
