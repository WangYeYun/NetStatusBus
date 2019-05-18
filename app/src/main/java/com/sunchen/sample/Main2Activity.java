package com.sunchen.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.sunchen.netbus.NetStatusBus;
import com.sunchen.netbus.annotation.NetSubscribe;
import com.sunchen.netbus.type.NetType;
import com.sunchen.netbus.utils.Constrants;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NetStatusBus.getInstance().register(this);
    }

    @NetSubscribe(netType = NetType.WIFI)
    public void doNet(NetType netType) {
        Log.e(Constrants.LOG_TAG, netType.name() + "<<<<<<<<<<activity2");
    }

    @NetSubscribe(netType = NetType.AUTO)
    public void netStatus(NetType netType) {
        Toast.makeText(this, "mainActivity2" + netType.name(), Toast.LENGTH_SHORT).show();
        Log.d(Constrants.LOG_TAG, netType.name() + "<<<<<<<<<<activity2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        NetStatusBus.getInstance().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}