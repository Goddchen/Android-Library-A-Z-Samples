package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.RetrofitFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 07.01.2016.
 */
public class RetrofitSample extends Sample {
    public RetrofitSample() {
        super("Retrofit 2.0", "http://square.github.io/retrofit/", "A type-safe HTTP client for Android and Java");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, RetrofitFragment.newInstance(new RetrofitSample()),
                        "rertofit")
                .addToBackStack("retrofit")
                .commit();
    }
}
