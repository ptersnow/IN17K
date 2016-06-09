package pedro.ifms.edu.br.fragmentview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import pedro.ifms.edu.br.fragmentview.R;

public class ChangeFragment extends Fragment{

    public static ChangeFragment newInstance() {
        ChangeFragment fragment = new ChangeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vInflater = inflater.inflate(R.layout.fragment, container);

        TextView textViewFragment = (TextView) vInflater.findViewById(R.id.textViewFragment);
        textViewFragment.setText("TextView do Fragment");

        return vInflater;
    }
}
