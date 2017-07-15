package com.example.android.bluetooth_nasa;

/**
 * Created by David Lie-Tjauw on 7/15/2017.
 */

public interface BeaconContentFactory {

    void getContent(BeaconID beaconID, Callback callback);

    interface Callback {
        void onContentReady(Object content);
    }
}