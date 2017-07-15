package com.example.android.bluetooth_nasa;

/**
 * Created by David Lie-Tjauw on 7/15/2017.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Created by David Lie-Tjauw on 7/14/2017.
 */
import java.util.HashMap;
import java.util.Map;

public class BeaconContentCache implements BeaconContentFactory {

    private BeaconContentFactory beaconContentFactory;

    private Map<BeaconID, Object> cachedContent = new HashMap<>();

    public BeaconContentCache(BeaconContentFactory beaconContentFactory) {
        this.beaconContentFactory = beaconContentFactory;
    }

    @Override
    public void getContent(final BeaconID beaconID, final Callback callback) {
        if (cachedContent.containsKey(beaconID)) {
            callback.onContentReady(cachedContent.get(beaconID));
        } else {
            beaconContentFactory.getContent(beaconID, new Callback() {
                @Override
                public void onContentReady(Object content) {
                    cachedContent.put(beaconID, content);
                    callback.onContentReady(content);
                }
            });
        }
    }
}
