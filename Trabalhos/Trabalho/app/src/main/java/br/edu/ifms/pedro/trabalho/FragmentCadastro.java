package br.edu.ifms.pedro.trabalho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Pedro on 10/06/2016.
 */
public class FragmentCadastro extends Fragment {

    private Button btnEnviarCadastro;

    private Spinner spinnerUF;
    private EditText editTextNome;
    private EditText editTextEndereco;
    private EditText editTextEmail;
    private EditText editTextTelefone;

    public static FragmentCadastro newInstance() {
        return new FragmentCadastro();
    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Fazer validação

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, FragmentTroco.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vInflate = inflater.inflate(R.layout.cadastro, container, false);

        spinnerUF = (Spinner) vInflate.findViewById(R.id.spinnerUF);
        editTextNome = (EditText) vInflate.findViewById(R.id.editTextNome);
        editTextEndereco = (EditText) vInflate.findViewById(R.id.editTextEndereco);
        editTextEmail = (EditText) vInflate.findViewById(R.id.editTextEmail);
        editTextTelefone = (EditText) vInflate.findViewById(R.id.editTextTelefone);

        btnEnviarCadastro = (Button) vInflate.findViewById(R.id.btnEnviarCadastro);
        btnEnviarCadastro.setOnClickListener(btnClick);

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("MG");
        stringArrayList.add("MS");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, stringArrayList);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUF.setAdapter(stringArrayAdapter);

        return vInflate;
    }
}
