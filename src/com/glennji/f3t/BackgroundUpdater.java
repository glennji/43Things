package com.glennji.f3t;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BackgroundUpdater extends Service {
    
    @Override
    public void onCreate() {
        // TODO: Actions to perform when service is created.
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see android.app.Service#onStart(android.content.Intent, int)
     */
    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
    }

}
