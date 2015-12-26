package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class Dagger2Fragment extends SampleFragment {

    public static Dagger2Fragment newInstance(Sample sample) {
        Dagger2Fragment fragment = new Dagger2Fragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_dagger2;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = DaggerDagger2Fragment_MyStringWriterComponent.create()
                .stringWriter().writeString();
        ((TextView) view.findViewById(R.id.text)).setText(text);

    }

    public interface StringWriter {
        String writeString();
    }

    @Component(modules = AwesomeStringWriterModule.class)
    public interface MyStringWriterComponent {
        StringWriter stringWriter();
    }

    public static class AwesomeStringWriter implements StringWriter {

        @Override
        public String writeString() {
            return "What an awesome String!";
        }
    }

    @Module
    public static class AwesomeStringWriterModule {
        @Provides
        public StringWriter provideStringWriter() {
            return new AwesomeStringWriter();
        }
    }
}
