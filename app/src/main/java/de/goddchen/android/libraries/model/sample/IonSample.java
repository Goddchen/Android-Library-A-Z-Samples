package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.IonFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by goddc on 19.01.2016.
 */
public class IonSample extends Sample {
    public IonSample() {
        super("Ion", "https://github.com/koush/ion", "Android Asynchronous Networking and Image Loading");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, IonFragment.newInstance(), "ion")
                .addToBackStack("ion")
                .commit();
    }
}
