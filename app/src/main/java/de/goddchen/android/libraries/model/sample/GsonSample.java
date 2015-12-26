package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.GsonFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class GsonSample extends Sample {


    public GsonSample() {
        super("Gson", "https://github.com/google/gson", "A Java serialization library that can convert Java Objects into JSON and back");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, GsonFragment.newInstance(this), "gson")
                .addToBackStack("gson")
                .commit();
    }
}
