package de.goddchen.android.libraries.model.sample;

import android.support.v4.app.FragmentActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.EventBusFragment;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class EventBusSample extends Sample {
    public EventBusSample() {
        super("EventBus", "https://github.com/greenrobot/EventBus", "Event bus that simplifies communication between components");
    }

    @Override
    public void launchFragment(FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, EventBusFragment.newInstance(this), "eventbus")
                .addToBackStack("eventbus")
                .commit();
    }
}
