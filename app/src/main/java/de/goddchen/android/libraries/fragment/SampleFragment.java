package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public abstract class SampleFragment extends Fragment {

    protected Sample getSample() {
        return (Sample) getArguments().getSerializable("sample");
    }

    protected void setSample(Sample sample) {
        Bundle args = getArguments();
        if (args == null) {
            args = new Bundle();
        }
        args.putSerializable("sample", sample);
        setArguments(args);
    }

    public abstract
    @LayoutRes
    int getLayoutRes();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Sample sample = getSample();
        ((TextView) view.findViewById(R.id.name)).setText(sample.getName());
        ((TextView) view.findViewById(R.id.url)).setText(sample.getUrl());
        ((TextView) view.findViewById(R.id.short_description))
                .setText(sample.getShortDescription());
        LayoutInflater.from(getContext())
                .inflate(getLayoutRes(), (ViewGroup) view.findViewById(R.id.sample_layout), true);
    }
}
