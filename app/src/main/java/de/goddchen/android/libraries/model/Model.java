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
import de.goddchen.android.libraries.model.sample.IonSample;
import de.goddchen.android.libraries.model.sample.KSoap2Sample;
import de.goddchen.android.libraries.model.sample.LeakCanarySample;
import de.goddchen.android.libraries.model.sample.MoshiSample;
import de.goddchen.android.libraries.model.sample.OttoSample;
import de.goddchen.android.libraries.model.sample.PicassoSample;
import de.goddchen.android.libraries.model.sample.QRGenSample;
import de.goddchen.android.libraries.model.sample.RetrofitSample;
import de.goddchen.android.libraries.model.sample.SimpleSample;
import de.goddchen.android.libraries.model.sample.TimberSample;
import de.goddchen.android.libraries.model.sample.UniversalImageLoaderSample;
import de.goddchen.android.libraries.model.sample.VectorDrawableSample;
import de.goddchen.android.libraries.model.sample.WireSample;
import de.goddchen.android.libraries.model.sample.ZXingSample;

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
        samples.add(new MoshiSample());
        samples.add(new OttoSample());
        samples.add(new RetrofitSample());
        samples.add(new IonSample());
        samples.add(new TimberSample());
        samples.add(new LeakCanarySample());
        samples.add(new KSoap2Sample());
        samples.add(new QRGenSample());
        samples.add(new SimpleSample());
        samples.add(new UniversalImageLoaderSample());
        samples.add(new VectorDrawableSample());
        samples.add(new WireSample());
        samples.add(new ZXingSample());

        Collections.sort(samples, new Comparator<Sample>() {
            @Override
            public int compare(Sample sample1, Sample sample2) {
                return sample1.getName().compareToIgnoreCase(sample2.getName());
            }
        });
        return samples;
    }

}
