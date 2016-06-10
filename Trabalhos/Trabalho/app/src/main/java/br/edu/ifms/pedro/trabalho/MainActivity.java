package br.edu.ifms.pedro.trabalho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTenho;
    private Button btnPreciso;

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentCadastro, FragmentCadastro.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTenho = (Button) findViewById(R.id.btnTenho);
        btnPreciso = (Button) findViewById(R.id.btnPreciso);

        btnTenho.setOnClickListener(btnClick);
        btnPreciso.setOnClickListener(btnClick);
    }
}
