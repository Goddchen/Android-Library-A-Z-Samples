package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;
import de.greenrobot.event.EventBus;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class EventBusFragment extends SampleFragment {

    private TextView mTextView;

    public static EventBusFragment newInstance(Sample sample) {
        EventBusFragment fragment = new EventBusFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_eventbus;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = (TextView) view.findViewById(R.id.text);
        view.findViewById(R.id.action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new ClickEvent());
            }
        });
    }

    @SuppressWarnings("unused")
    public void onEventMainThread(ClickEvent event) {
        mTextView.setText(R.string.you_did_it);
    }

    public static class ClickEvent {

    }
}
