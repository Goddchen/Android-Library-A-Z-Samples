package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
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
public class ACRAFragment extends Fragment {

    public static ACRAFragment newInstance(Sample sample) {
        ACRAFragment fragment = new ACRAFragment();
        Bundle args = new Bundle();
        args.putSerializable("sample", sample);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acra, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Sample sample = (Sample) getArguments().getSerializable("sample");
        if (sample != null) {
            ((TextView) view.findViewById(R.id.name)).setText(sample.getName());
            ((TextView) view.findViewById(R.id.url)).setText(sample.getUrl());
            ((TextView) view.findViewById(R.id.short_description))
                    .setText(sample.getShortDescription());
        }
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
