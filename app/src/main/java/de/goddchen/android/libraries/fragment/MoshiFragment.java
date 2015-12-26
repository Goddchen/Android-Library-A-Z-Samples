package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class MoshiFragment extends SampleFragment {

    public static MoshiFragment newInstance(Sample sample) {
        MoshiFragment fragment = new MoshiFragment();
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
        try {
            JsonAdapter<ReadSampleClass> moshiAdapter =
                    new Moshi.Builder().build().adapter(ReadSampleClass.class);
            ReadSampleClass readSampleClass =
                    moshiAdapter.fromJson("{\"name\":\"Sample\",\"age\":23}");
            ((TextView) view.findViewById(R.id.text))
                    .setText(moshiAdapter.toJson(readSampleClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static class ReadSampleClass {
        public String name;
        public int age;
    }
}
