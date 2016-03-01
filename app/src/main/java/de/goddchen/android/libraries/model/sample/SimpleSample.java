package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.SimpleFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class SimpleSample extends Sample {


    public SimpleSample() {
        super("Simple (XML)", "http://simple.sourceforge.net/", "Simple is a high performance XML serialization and configuration framework for Java.");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SimpleFragment.newInstance(this), "simple")
                .addToBackStack("simple")
                .commit();
    }
}
