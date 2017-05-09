package org.robolectric.shadows;

import android.os.Debug;

import com.google.common.collect.ImmutableMap;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.util.Map;

import static android.os.Build.VERSION_CODES;
import static android.os.Build.VERSION_CODES.M;

@Implements(Debug.class)
public class ShadowDebug {
  @Implementation
  protected static void __staticInitializer__() {
    // Avoid calling Environment.getLegacyExternalStorageDirectory()
  }

  @Implementation
  protected static long getNativeHeapAllocatedSize() {
    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
  }

  @Implementation(minSdk = M)
  protected static Map<String, String> getRuntimeStats() {
    return ImmutableMap.<String, String>builder().build();
  }
}
