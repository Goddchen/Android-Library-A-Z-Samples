package de.goddchen.android.libraries.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import de.goddchen.android.libraries.R;
import de.goddchen.android.libraries.model.sample.KSoap2Sample;

/**
 * Created by goddc on 19.01.2016.
 */
public class KSoap2Fragment extends SampleFragment {

    public static KSoap2Fragment newInstance() {
        KSoap2Fragment fragment = new KSoap2Fragment();
        fragment.setSample(new KSoap2Sample());
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_ksoap2;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpTransportSE httpTransport = new HttpTransportSE("http://www.webservicex.net/periodictable.asmx");
                try {
                    SoapObject soapObject = new SoapObject("http://www.webserviceX.NET", "GetElementSymbol");
                    soapObject.addProperty("http://www.webserviceX.NET", "ElementName", "Gold");
                    final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    envelope.setOutputSoapObject(soapObject);
                    httpTransport.debug = true;
                    httpTransport.call("http://www.webserviceX.NET/GetElementSymbol", envelope);
                    Log.d("KSoap2", "Request: " + httpTransport.requestDump);
                    Log.d("KSoap2", "Response: " + httpTransport.responseDump);
                    final SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView) view.findViewById(R.id.text)).setText(
                                    String.format("Element name for gold. Response:\n%s",
                                            response.getValue()));
                        }
                    });
                } catch (Exception e) {
                    Log.e("KSoap2", "Error making request: " + (e.getMessage() == null ? "" : e.getMessage()));
                    Log.d("KSoap2", "Request: " + httpTransport.requestDump);
                }
            }
        }).start();
    }
}
