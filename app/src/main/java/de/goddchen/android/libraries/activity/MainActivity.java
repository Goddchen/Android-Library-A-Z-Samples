package de.goddchen.android.libraries.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.fragment.SampleListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, SampleListFragment.newInstance(), "samples")
                    .commit();
        }
    }
}
