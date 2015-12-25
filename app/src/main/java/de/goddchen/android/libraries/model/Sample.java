package de.goddchen.android.libraries.model;

import android.support.v4.app.FragmentActivity;

import java.io.Serializable;

/**
 * Created by Goddchen on 25.12.2015.
 */
public abstract class Sample implements Serializable {

    private String name;

    private String url;

    private String shortDescription;

    public Sample(String name, String url, String shortDescription) {
        this.name = name;
        this.url = url;
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public abstract void launchFragment(FragmentActivity activity);
}
