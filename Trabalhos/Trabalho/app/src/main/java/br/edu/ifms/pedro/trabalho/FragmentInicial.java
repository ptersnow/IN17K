package br.edu.ifms.pedro.trabalho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Pedro on 10/06/2016.
 */
public class FragmentInicial extends Fragment {

    private Button btnTenho;
    private Button btnPreciso;

    public static FragmentInicial newInstance() {
        return new FragmentInicial();
    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, FragmentCadastro.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vInflate = inflater.inflate(R.layout.tela_inicial, container, false);

        btnTenho = (Button) vInflate.findViewById(R.id.btnTenho);
        btnPreciso = (Button) vInflate.findViewById(R.id.btnPreciso);

        btnTenho.setOnClickListener(btnClick);
        btnPreciso.setOnClickListener(btnClick);

        return vInflate;
    }
}
