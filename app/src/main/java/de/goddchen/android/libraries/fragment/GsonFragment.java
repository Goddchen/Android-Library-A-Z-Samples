package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class GsonFragment extends SampleFragment {

    public static GsonFragment newInstance(Sample sample) {
        GsonFragment fragment = new GsonFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_gson;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ReadSampleClass readSampleClass = new Gson().fromJson("{\"name\":\"Sample\",\"age\":23}",
                ReadSampleClass.class);
        ((TextView) view.findViewById(R.id.text))
                .setText(new Gson().toJson(readSampleClass));
    }

    @SuppressWarnings("unused")
    public static class ReadSampleClass {
        public String name;
        public int age;
    }
}
