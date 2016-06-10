package br.edu.ifms.pedro.trabalho;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Pedro on 10/06/2016.
 */
public class FragmentTroco extends Fragment {

    public static FragmentTroco newInstance() {
        return new FragmentTroco();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vInflate = inflater.inflate(R.layout.troco, container, false);

        return vInflate;
    }
}
