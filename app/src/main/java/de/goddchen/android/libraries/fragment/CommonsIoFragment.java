package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class CommonsIoFragment extends SampleFragment {

    public static CommonsIoFragment newInstance(Sample sample) {
        CommonsIoFragment fragment = new CommonsIoFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_commons_io;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ((TextView) view.findViewById(R.id.text))
                    .setText(IOUtils.toString(getResources().openRawResource(R.raw.commonsio)));
        } catch (IOException e) {
            Log.d("Commons IO Sample", "Error reading file to String", e);
            Toast.makeText(getContext(), "Error reading file to String", Toast.LENGTH_SHORT).show();
        }
    }
}
