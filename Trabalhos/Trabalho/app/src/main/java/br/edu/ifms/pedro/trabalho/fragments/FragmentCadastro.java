package br.edu.ifms.pedro.trabalho.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import br.edu.ifms.pedro.trabalho.R;

public class FragmentCadastro extends Fragment {

    private Button btnEnviarCadastro;

    private String uf = "";

    private Spinner spinnerUF;
    private EditText editTextNome;
    private EditText editTextEndereco;
    private EditText editTextEmail;
    private EditText editTextTelefone;

    private AdapterView.OnItemSelectedListener spinnerSelect = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                uf = "";
            } else {
                uf = parent.getItemAtPosition(position).toString();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public static FragmentCadastro newInstance() {
        return new FragmentCadastro();
    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String texto = "";
            String textNome = editTextNome.getText().toString();
            String textEndereco = editTextEndereco.getText().toString();
            String textEmail = editTextEmail.getText().toString();
            String textTelefone = editTextTelefone.getText().toString();

            if (uf.equals("")) {
                texto = " -Selecione a uf\n";
            }

            if (textNome.equals("")) {
                texto += " -Informe o seu nome\n";
            }

            if (textEndereco.equals("")) {
                texto += " -Informe o seu endereço\n";
            }

            if (textEmail.equals("")) {
                texto += " -Informe o seu e-mail\n";
            }

            if (textTelefone.equals("")) {
                texto += " -Informe o seu telefone\n";
            }

            if (texto.equals("")) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, FragmentTroco.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            else {
                Toast.makeText(getActivity(), texto, Toast.LENGTH_LONG).show();
            }
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

        String[] stringArrayList = getActivity().getResources().getStringArray(R.array.uf_list);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, stringArrayList);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUF.setAdapter(stringArrayAdapter);

        spinnerUF.setOnItemSelectedListener(spinnerSelect);

        return vInflate;
    }
}
