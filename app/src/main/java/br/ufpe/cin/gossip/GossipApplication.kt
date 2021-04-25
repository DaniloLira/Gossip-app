package br.ufpe.cin.gossip

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.p2p.WifiP2pManager
import android.os.Build
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class GossipApplication : Application () {

    companion object {
        var userName: String = ""

        var permissionsNeeded: Array<String> = arrayOf(
            android.Manifest.permission.ACCESS_WIFI_STATE,
            android.Manifest.permission.CHANGE_WIFI_STATE,
            android.Manifest.permission.ACCESS_NETWORK_STATE,
            android.Manifest.permission.CHANGE_NETWORK_STATE,
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        lateinit var p2pManager: WifiP2pManager
        lateinit var p2pChannel: WifiP2pManager.Channel
        lateinit var broadcastReceiver: WifiDirectBroadcastReceiver
        lateinit var p2pIntentFilter: IntentFilter

    }

    private var PERMISSIONS_ALL = 1

    override fun onCreate() {
        super.onCreate()
        p2pManager = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
        p2pChannel = p2pManager.initialize(applicationContext, Looper.getMainLooper(), null)
        broadcastReceiver = WifiDirectBroadcastReceiver()

        p2pIntentFilter = IntentFilter()
        p2pIntentFilter.apply {
            addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
            addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)
        }

    }
}