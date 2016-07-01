package br.edu.ifms.pedro.trabalho.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import br.edu.ifms.pedro.trabalho.R;

public class FragmentTroco extends Fragment {

    private EditText editText005;
    private EditText editText010;
    private EditText editText025;
    private EditText editText050;
    private EditText editText100;

    private EditText editText200;
    private EditText editText500;
    private EditText editText1000;


    private View.OnClickListener enviarTroco = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final DialogFragmentResposta dialogFragmentResposta = new DialogFragmentResposta() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    if (this.ok) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout, FragmentInicial.newInstance())
                                .addToBackStack(null)
                                .commit();
                    }
                }
            };

            dialogFragmentResposta.show(getActivity().getSupportFragmentManager(), "dialog_fragment");
        }
    };
    ;

    public static FragmentTroco newInstance() {
        return new FragmentTroco();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vInflate = inflater.inflate(R.layout.troco, container, false);

        Button btnM005 = (Button) vInflate.findViewById(R.id.btnM005);
        Button btnM010 = (Button) vInflate.findViewById(R.id.btnM010);
        Button btnM025 = (Button) vInflate.findViewById(R.id.btnM025);
        Button btnM050 = (Button) vInflate.findViewById(R.id.btnM050);
        Button btnM100 = (Button) vInflate.findViewById(R.id.btnM100);

        Button btnM200 = (Button) vInflate.findViewById(R.id.btnM200);
        Button btnM500 = (Button) vInflate.findViewById(R.id.btnM500);
        Button btnM1000 = (Button) vInflate.findViewById(R.id.btnM1000);

        editText005 = (EditText) vInflate.findViewById(R.id.editText005);
        editText010 = (EditText) vInflate.findViewById(R.id.editText010);
        editText025 = (EditText) vInflate.findViewById(R.id.editText025);
        editText050 = (EditText) vInflate.findViewById(R.id.editText050);
        editText100 = (EditText) vInflate.findViewById(R.id.editText100);

        editText200 = (EditText) vInflate.findViewById(R.id.editText200);
        editText500 = (EditText) vInflate.findViewById(R.id.editText500);
        editText1000 = (EditText) vInflate.findViewById(R.id.editText1000);

        Button btnP005 = (Button) vInflate.findViewById(R.id.btnP005);
        Button btnP010 = (Button) vInflate.findViewById(R.id.btnP010);
        Button btnP025 = (Button) vInflate.findViewById(R.id.btnP025);
        Button btnP050 = (Button) vInflate.findViewById(R.id.btnP050);
        Button btnP100 = (Button) vInflate.findViewById(R.id.btnP100);

        Button btnP200 = (Button) vInflate.findViewById(R.id.btnP200);
        Button btnP500 = (Button) vInflate.findViewById(R.id.btnP500);
        Button btnP1000 = (Button) vInflate.findViewById(R.id.btnP1000);


        btnM005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText005.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText005.setText(String.valueOf(i));
            }
        });

        btnP005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText005.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText005.setText(String.valueOf(++i));
            }
        });

        btnM010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText010.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText010.setText(String.valueOf(i));
            }
        });

        btnP010.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText010.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText010.setText(String.valueOf(++i));
            }
        });

        btnM025.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText025.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText025.setText(String.valueOf(i));
            }
        });

        btnP025.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText025.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText025.setText(String.valueOf(++i));
            }
        });

        btnM050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText050.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText050.setText(String.valueOf(i));
            }
        });

        btnP050.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText050.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText050.setText(String.valueOf(++i));
            }
        });

        btnM100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText100.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText100.setText(String.valueOf(i));
            }
        });

        btnP100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText100.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText100.setText(String.valueOf(++i));
            }
        });

        btnM200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText200.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText200.setText(String.valueOf(i));
            }
        });

        btnP200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText200.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText200.setText(String.valueOf(++i));
            }
        });

        btnM500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText500.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText500.setText(String.valueOf(i));
            }
        });

        btnP500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText500.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText500.setText(String.valueOf(++i));
            }
        });

        btnM1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText1000.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                if (i > 0) {
                    i--;
                }

                editText1000.setText(String.valueOf(i));
            }
        });

        btnP1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;
                String valor = editText1000.getText().toString();
                if (!valor.equals("")) {
                    i = Integer.parseInt(valor);
                }

                editText1000.setText(String.valueOf(++i));
            }
        });

        Button buttonTrocoEnviar = (Button) vInflate.findViewById(R.id.buttonTrocoEnviar);
        buttonTrocoEnviar.setOnClickListener(enviarTroco);
        return vInflate;
    }
}
