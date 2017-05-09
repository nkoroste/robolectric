package org.robolectric.shadows.maps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.maps.MapActivity;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowActivity;

@Implements(MapActivity.class)
public class ShadowMapActivity extends ShadowActivity {
  private ConnectivityBroadcastReceiver connectivityBroadcastReceiver = new ConnectivityBroadcastReceiver();

  @Override @Implementation
  protected void __constructor__() {
  }

  @Implementation
  protected void onCreate(Bundle bundle) {
  }

  @Implementation
  protected void onResume() {
    realActivity.registerReceiver(connectivityBroadcastReceiver, new IntentFilter());
  }

  @Implementation
  protected void onPause() {
    realActivity.unregisterReceiver(connectivityBroadcastReceiver);
  }

  @Implementation
  protected void onDestroy() {
  }

  @Implementation
  protected boolean isRouteDisplayed() {
    return false;
  }

  private static class ConnectivityBroadcastReceiver extends BroadcastReceiver {
    @Override public void onReceive(Context context, Intent intent) {
    }
  }
}
