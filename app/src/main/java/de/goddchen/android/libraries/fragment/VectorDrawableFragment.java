package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.Sample;

/**
 * Created by Goddchen on 26.12.2015.
 */
public class VectorDrawableFragment extends SampleFragment {

    public static VectorDrawableFragment newInstance(Sample sample) {
        VectorDrawableFragment fragment = new VectorDrawableFragment();
        fragment.setSample(sample);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_vector_drawable;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*Drawable drawable = VectorDrawableCompat.create(getResources(),
                R.drawable.svg_android, getActivity().getTheme());
        ((ImageView)view.findViewById(R.id.image))
                .setImageDrawable(drawable);*/
        ((ImageView) view.findViewById(R.id.image))
                .setImageResource(R.drawable.svg_android);
    }
}
