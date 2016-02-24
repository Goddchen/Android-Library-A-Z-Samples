package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.sample.TimberSample;
import timber.log.Timber;

/**
 * Created by goddc on 20.01.2016.
 */
public class TimberFragment extends SampleFragment {

    public static TimberFragment newInstance() {
        TimberFragment fragment = new TimberFragment();
        fragment.setSample(new TimberSample());
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_timber;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timber.d("Button clicked :D");
            }
        });
    }
}
