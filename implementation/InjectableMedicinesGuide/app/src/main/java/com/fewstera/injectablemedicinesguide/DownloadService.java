package com.fewstera.injectablemedicinesguide;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.binary.InFileBitmapObjectPersister;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.string.InFileStringObjectPersister;

/**
 * Created by fewstera on 23/03/2014.
 */
public class DownloadService  extends SpiceService {

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager cacheManager = new CacheManager();

        InFileStringObjectPersister inFileStringObjectPersister = new InFileStringObjectPersister(application);

        cacheManager.addPersister(inFileStringObjectPersister);
        return cacheManager;
    }

    @Override
    public int getThreadCount() {
        return 3;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.v("SampleSpiceService", "Starting service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("SampleSpiceService","Starting service");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("SampleSpiceService","Stopping service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v("SampleSpiceService","Bound service");
        return super.onBind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v("SampleSpiceService","Rebound service");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v("SampleSpiceService","Unbound service");
        return super.onUnbind(intent);
    }

}