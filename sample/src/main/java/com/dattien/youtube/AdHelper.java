package com.dattien.youtube;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.thefinestartist.ytpa.sample.R;

public class AdHelper {

    private static final Object lock = new Object();
    private static InterstitialAd interstitial = null;

    private AdHelper() {
    }

    private static InterstitialAd getInstance(final Context context) {
        synchronized (lock) {
            if (interstitial != null)
                return interstitial;

            if (context != null) {
                interstitial = new InterstitialAd(context);
                interstitial.setAdUnitId(context.getString(R.string.interstitial_ad_unit_id));
            }

            return interstitial;
        }
    }

    public static void popUpAd(Context context) {
        final InterstitialAd interstitialAd = getInstance(context);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("BE5D7D1E701EF21AB93369A353CAA3ED")
                .addTestDevice("921DF5A672991967B9FFE364D0FF8498")
                .addTestDevice("A642C45F5DD4C0E09AA896DDABD36789")
                .addTestDevice("5270E2092AA1F46AC51964363699AB9E")
                .build();
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }
        });
    }
}