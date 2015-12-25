package de.goddchen.android.libraries.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.goddchen.android.libraries.model.sample.ACRASample;
import de.goddchen.android.libraries.model.sample.ButterknifeSample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class Model {

    public static List<Sample> getSamples() {
        List<Sample> samples = new ArrayList<>();
        samples.add(new ACRASample());
        samples.add(new ButterknifeSample());
        Collections.sort(samples, new Comparator<Sample>() {
            @Override
            public int compare(Sample sample1, Sample sample2) {
                return sample1.getName().compareTo(sample2.getName());
            }
        });
        return samples;
    }

}
