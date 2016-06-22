package br.edu.ifms.pedro.trabalho.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import br.edu.ifms.pedro.trabalho.R;

public class DialogFragmentResposta extends DialogFragment implements DialogInterface.OnDismissListener {

    boolean ok;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vInflate = inflater.inflate(R.layout.dialog_resposta, container, false);

        Button buttonDialogOK = (Button) vInflate.findViewById(R.id.buttonDialogOK);
        Button buttonDialogCancelar = (Button) vInflate.findViewById(R.id.buttonDialogCancelar);

        buttonDialogOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok = true;
                dismiss();
            }
        });

        buttonDialogCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok = false;
                dismiss();
            }
        });

        return vInflate;
    }
}
