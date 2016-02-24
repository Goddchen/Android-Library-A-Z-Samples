package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import de.goddchen.android.libraries.Application;
import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.sample.LeakCanarySample;

/**
 * Created by goddc on 22.01.2016.
 */
public class LeakCanaryFragment extends SampleFragment {

    public static LeakCanaryFragment newInstance() {
        LeakCanaryFragment fragment = new LeakCanaryFragment();
        fragment.setSample(new LeakCanarySample());
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_leakcanary;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.leak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Application) getActivity().getApplication()).leakObject = getActivity();
                Log.d("Leak Sample",
                        ((Application) getActivity().getApplication()).leakObject.toString());
            }
        });
    }
}
