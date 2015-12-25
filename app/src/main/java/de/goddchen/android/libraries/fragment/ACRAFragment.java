package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class ACRAFragment extends SampleFragment {

    public static ACRAFragment newInstance(Sample sample) {
        ACRAFragment fragment = new ACRAFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_acra;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.crash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Object evilNPE = null;
                //noinspection ConstantConditions,ResultOfMethodCallIgnored
                evilNPE.toString();
            }
        });
    }
}
