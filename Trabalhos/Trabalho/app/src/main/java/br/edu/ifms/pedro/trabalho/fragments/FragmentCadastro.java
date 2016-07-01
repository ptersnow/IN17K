package br.edu.ifms.pedro.trabalho.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import br.edu.ifms.pedro.trabalho.R;
import br.edu.ifms.pedro.trabalho.dao.UsuarioDAO;
import br.edu.ifms.pedro.trabalho.model.Usuario;

import java.util.List;

public class FragmentCadastro extends Fragment {

    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    private Button btnEnviarCadastro;

    private String uf = "";

    private View vInflate;
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

                if (usuario == null) {
                    usuario = new Usuario();
                    usuario.setNome(textNome);
                    usuario.setEndereco(textEndereco);
                    usuario.setEmail(textEmail);
                    usuario.setTelefone(textTelefone);

                    usuario.setUf(uf);

                    Long id = usuarioDAO.createUsuario(usuario);
                    usuario.setId(id);
                }

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, FragmentTroco.newInstance())
                        .addToBackStack(null)
                        .commit();
            } else {
                Toast.makeText(getActivity(), texto, Toast.LENGTH_LONG).show();
            }
        }
    };

    public static FragmentCadastro newInstance() {
        return new FragmentCadastro();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioDAO = new UsuarioDAO(getActivity());
        usuarioDAO.open();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vInflate = inflater.inflate(R.layout.cadastro, container, false);

        inicializarElementos();
        preencherElementos();
        popularElementos();

        return vInflate;
    }

    @Override
    public void onResume() {
        usuarioDAO.open();
        super.onResume();
    }

    @Override
    public void onPause() {
        usuarioDAO.close();
        super.onPause();
    }

    private void popularElementos() {
        List<Usuario> usuarioList = usuarioDAO.getUsuarioList();

        usuario = null;
        if (!usuarioList.isEmpty()) {
            usuario = usuarioList.get(0);

            editTextNome.setText(usuario.getNome());
            editTextEndereco.setText(usuario.getEndereco());
            editTextEmail.setText(usuario.getEmail());
            editTextTelefone.setText(usuario.getTelefone());

            for (int i = 0; i < spinnerUF.getCount(); i++) {
                if (usuario.getUf().equals(spinnerUF.getItemAtPosition(i))) {
                    spinnerUF.setSelection(i);
                    break;
                }
            }
        }
    }

    private void preencherElementos() {
        btnEnviarCadastro.setOnClickListener(btnClick);

        String[] stringArrayList = getActivity().getResources().getStringArray(R.array.uf_list);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, stringArrayList);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUF.setAdapter(stringArrayAdapter);

        spinnerUF.setOnItemSelectedListener(spinnerSelect);
    }

    private void inicializarElementos() {
        spinnerUF = (Spinner) vInflate.findViewById(R.id.spinnerUF);
        editTextNome = (EditText) vInflate.findViewById(R.id.editTextNome);
        editTextEndereco = (EditText) vInflate.findViewById(R.id.editTextEndereco);
        editTextEmail = (EditText) vInflate.findViewById(R.id.editTextEmail);
        editTextTelefone = (EditText) vInflate.findViewById(R.id.editTextTelefone);

        btnEnviarCadastro = (Button) vInflate.findViewById(R.id.btnEnviarCadastro);
    }
}
