package de.goddchen.android.libraries;

import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

import timber.log.Timber;

/**
 * Created by Goddchen on 25.12.2015.
 */
@ReportsCrashes(mode = ReportingInteractionMode.DIALOG,
        resDialogText = R.string.acra_dialog_message,
        resDialogTitle = R.string.acra_dialog_title)
public class Application extends android.app.Application {

    public Object leakObject = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
        initACRA();
        initTimber();
        initLeakCanary();
    }

    private void initLeakCanary() {
        LeakCanary.install(this);
    }

    private void initTimber() {
        Timber.plant(new Timber.DebugTree());
    }

    private void initACRA() {
        ACRA.init(this);
        ACRA.getErrorReporter().setReportSender(new ReportSender() {
            @Override
            public void send(Context context, CrashReportData errorContent)
                    throws ReportSenderException {
                // We don't actually send anything in this sample...
            }
        });
    }
}
