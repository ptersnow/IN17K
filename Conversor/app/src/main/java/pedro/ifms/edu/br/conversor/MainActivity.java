package pedro.ifms.edu.br.conversor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextConverter;
    private Spinner spinnerUnidade;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextConverter = (EditText) findViewById(R.id.editTextConverter);
        spinnerUnidade = (Spinner) findViewById(R.id.spinnerUnidade);
        textViewResultado = (TextView) findViewById(R.id.textViewResultado);

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("K");
        stringArrayList.add("F");

        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stringArrayList);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerUnidade.setAdapter(stringArrayAdapter);
        spinnerUnidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Double temperatura = 0.0;

                if (!editTextConverter.getText().toString().equals("")) {
                    temperatura = Double.parseDouble(editTextConverter.
                            getText().toString());
                }

                switch (position) {
                    case 0:
                        temperatura = temperatura + 273.15;
                        textViewResultado.setText(temperatura.toString());
                        break;

                    case 1:
                        temperatura = 1.8 * temperatura + 32;
                        textViewResultado.setText(temperatura.toString());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
