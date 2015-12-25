package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 25.12.2015.
 */
public class ButterknifeFragment extends SampleFragment {

    //This automatically binds the view with id R.id.timestamp to mTimestampTextView when
    //Butterknife.bind(...) is called.
    @Bind(R.id.timestamp)
    public TextView mTimestampTextView;

    private DateFormat mDateFormat = DateFormat.getDateTimeInstance();

    private Timer mTimer;

    public static ButterknifeFragment newInstance(Sample sample) {
        ButterknifeFragment fragment = new ButterknifeFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_butterknife;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        mTimer = new Timer("timestamp");
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mTimestampTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        mTimestampTextView.setText(mDateFormat.format(System.currentTimeMillis()));
                    }
                });
            }
        }, 0, 1000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mTimer.cancel();
        mTimer.purge();
        mTimer = null;
    }
}
