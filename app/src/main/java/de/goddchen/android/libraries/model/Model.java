package de.goddchen.android.libraries.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.goddchen.android.libraries.model.sample.ACRASample;
import de.goddchen.android.libraries.model.sample.ButterknifeSample;
import de.goddchen.android.libraries.model.sample.CommonsIoSample;
import de.goddchen.android.libraries.model.sample.Dagger2Sample;
import de.goddchen.android.libraries.model.sample.EventBusSample;
import de.goddchen.android.libraries.model.sample.GsonSample;
import de.goddchen.android.libraries.model.sample.PicassoSample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class Model {

    public static List<Sample> getSamples() {
        List<Sample> samples = new ArrayList<>();
        samples.add(new ACRASample());
        samples.add(new ButterknifeSample());
        samples.add(new CommonsIoSample());
        samples.add(new Dagger2Sample());
        samples.add(new EventBusSample());
        samples.add(new GsonSample());
        samples.add(new PicassoSample());

        Collections.sort(samples, new Comparator<Sample>() {
            @Override
            public int compare(Sample sample1, Sample sample2) {
                return sample1.getName().compareTo(sample2.getName());
            }
        });
        return samples;
    }

}
