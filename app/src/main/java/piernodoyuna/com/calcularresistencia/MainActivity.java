package piernodoyuna.com.calcularresistencia;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1,textView2, textView3, textView7;
    TextView textView4,textView5, textView6, textView8;
    EditText editTextResistencia, editTextTolerancia;
    Spinner spinner1, spinner2, spinner3, spinner4;
    String[] posiciones1, posiciones2, posiciones3, posiciones4;

    double multiplicador, tolerancia;

    String[] CodiColors1y2 = {"#000000", "#937036", "#ff0404","#f5ff5500","#ffe900","#2eff00","#1000ff","#ee00ff","#656266","#ffffff" };
    String[] CodiColors3 = {"#000000","#937036","#ff0404","#f5ff5500","#ffe900","#2eff00","#1000ff","#ee00ff","#ffd700","#b7b5b7"};
    String[] CodiColors4 ={"#ff0404","#937036","#2eff00","#1000ff","#ee00ff","#656266","#ffd700","#b7b5b7"};

    String [] valores1y2 = { "0","1","2","3","4","5","6","7","8","9"};
    String [] multiplicadorbanda3 = { "1.0","10.0","100.0","1000.0","10000.0","100000.0","1000000.0","10000000.0","0.1","0.01"};
    String [] Tolerancia = {"1","2","0.5","0.25","0.10","0.05","5","10"};

    double banda1, banda2,banda3, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 = new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Colorbanda1y2));
        spinner1.setAdapter(adapter1);

        final String[] posiciones1 = getResources().getStringArray(R.array.Colorbanda1y2);
        textView4 = (TextView) this.findViewById(R.id.textView4);


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Colorbanda1y2));
        spinner2.setAdapter(adapter2);

        final String[] posiciones2 = getResources().getStringArray(R.array.Colorbanda1y2);
        textView5 = (TextView) this.findViewById(R.id.textView5);


        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Colorbanda3));
        spinner3.setAdapter(adapter3);

        final String[] posiciones3 = getResources().getStringArray(R.array.Colorbanda3);
        textView6 = (TextView) this.findViewById(R.id.textView6);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4 = new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Colorbanda4));
        spinner4.setAdapter(adapter4);

        final String[] posiciones4 = getResources().getStringArray(R.array.Colorbanda4);
        textView8 = (TextView) this.findViewById(R.id.textView8);

        editTextResistencia = (EditText) this.findViewById(R.id.editTextResistencia);
        editTextTolerancia = (EditText) this.findViewById(R.id.editTextTolerancia);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){

                textView4.setText(posiciones1[position]);
                textView4.setBackgroundColor(Color.parseColor(CodiColors1y2[position]));
                banda1 = Double.parseDouble(valores1y2[position]);
                resultado = ((banda1 * 10) + (banda2)) * (multiplicador);
                editTextResistencia.setText(Double.toString(resultado) + " Ω");

            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                textView5.setText(posiciones2[position]);
                textView5.setBackgroundColor(Color.parseColor(CodiColors1y2[position]));

                banda2 = Double.parseDouble(valores1y2[position]);
                resultado = ((banda1 * 10) + (banda2)) * (multiplicador);
                editTextResistencia.setText(Double.toString(resultado) + " Ω");
            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                textView6.setText(posiciones3[position]); //Fem que aparegui el text del color seleccionat
                textView6.setBackgroundColor(Color.parseColor(CodiColors3[position]));

                multiplicador = Double.parseDouble(multiplicadorbanda3[position]);
                resultado = ((banda1 * 10) + (banda2)) * (multiplicador);
                editTextResistencia.setText(Double.toString(resultado) + " Ω");
            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                textView8.setText(posiciones4[position]); //Fem que aparegui el text del color seleccionat
                textView8.setBackgroundColor(Color.parseColor(CodiColors4[position]));

                tolerancia = Double.parseDouble(Tolerancia[position]);
                editTextTolerancia.setText("± " + Double.toString(tolerancia));
            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

    }

}

