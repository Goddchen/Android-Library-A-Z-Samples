package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.wire.Wire;

import java.io.IOException;
import java.util.Locale;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;
import de.goddchen.android.libraries.proto.Person;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class WireFragment extends SampleFragment {

    public static WireFragment newInstance(Sample sample) {
        WireFragment fragment = new WireFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_wire;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            Person person = new Person.Builder()
                    .age(23)
                    .name("Andy")
                    .build();
            byte[] buffer = Person.ADAPTER.encode(person);
            person = Person.ADAPTER.decode(buffer);
            ((TextView) view.findViewById(R.id.text))
                    .setText(String.format(Locale.getDefault(), "%s is %d",
                            Wire.get(person.name, ""),
                            Wire.get(person.age, 0)));
        } catch (IOException e) {
            Log.e("Wire", "Error decoding buffer: " + (e.getMessage() != null ? e.getMessage() : ""));
        }
    }

    @SuppressWarnings("unused")
    public static class ReadSampleClass {
        public String name;
        public int age;
    }
}
