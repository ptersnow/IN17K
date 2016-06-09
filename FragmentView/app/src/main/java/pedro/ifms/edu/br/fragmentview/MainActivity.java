package pedro.ifms.edu.br.fragmentview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import pedro.ifms.edu.br.fragmentview.fragment.ChangeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnFragment;
    private Spinner spinnerView;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment = (Button) findViewById(R.id.btnFragment);
        spinnerView = (Spinner) findViewById(R.id.spinnerView);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("VISIBLE");
        stringArrayList.add("INVISIBLE");
        stringArrayList.add("GONE");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArrayList);

        spinnerView.setAdapter(stringArrayAdapter);
        spinnerView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        relativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        relativeLayout.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        relativeLayout.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeFragment changeFragment = ChangeFragment.newInstance();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container, changeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
