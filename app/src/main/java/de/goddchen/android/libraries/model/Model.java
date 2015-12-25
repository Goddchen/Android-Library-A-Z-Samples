package de.goddchen.android.libraries.model;

import java.util.ArrayList;
import java.util.List;

import de.goddchen.android.libraries.model.sample.ACRASample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class Model {

    public static List<Sample> getSamples() {
        List<Sample> samples = new ArrayList<>();
        samples.add(new ACRASample());
        return samples;
    }

}
