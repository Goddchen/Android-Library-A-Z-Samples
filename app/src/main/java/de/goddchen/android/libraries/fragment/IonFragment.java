package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.sample.IonSample;

/**
 * Created by goddc on 19.01.2016.
 */
public class IonFragment extends SampleFragment {

    public static IonFragment newInstance() {
        IonFragment fragment = new IonFragment();
        fragment.setSample(new IonSample());
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_ion;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Ion.with((ImageView) view.findViewById(R.id.image))
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_close_clear_cancel)
                .load("http://www.pablopicasso.org/images/paintings/the-weeping-woman.jpg");
        Ion.with(getContext())
                .load("http://quotes.rest/qod.json")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {
                            if (e != null) {
                                Log.e("IonSample", "Error loading sample quote", e);
                            } else {
                                String quote = result.getAsJsonObject("contents")
                                        .getAsJsonArray("quotes")
                                        .get(0)
                                        .getAsJsonObject()
                                        .get("quote")
                                        .getAsString();
                                ((TextView) view.findViewById(R.id.text))
                                        .setText(quote);
                            }
                        } catch (Exception e1) {
                            Log.e("IonSample", "Error loading sample quote", e1);
                        }
                    }
                });
    }
}
