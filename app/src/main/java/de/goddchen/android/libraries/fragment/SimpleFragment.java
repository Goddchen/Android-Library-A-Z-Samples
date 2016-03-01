package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class SimpleFragment extends SampleFragment {

    public static SimpleFragment newInstance(Sample sample) {
        SimpleFragment fragment = new SimpleFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_simple;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            String xml = "<person><name>Sample</name><age>23</age></person>";
            Serializer serializer = new Persister();
            ReadSampleClass readSampleClass = serializer.read(ReadSampleClass.class, xml);
            StringWriter stringWriter = new StringWriter();
            serializer.write(readSampleClass, stringWriter);
            ((TextView) view.findViewById(R.id.text))
                    .setText(stringWriter.toString());
        } catch (Exception e) {
            Log.e("SimpleXML", "Error parsing xml: " +
                    (e.getMessage() != null ? e.getMessage() : ""));
        }
    }

    @SuppressWarnings("unused")
    @Root(name = "person")
    public static class ReadSampleClass {
        @Element
        public String name;

        @Element
        public int age;
    }
}
