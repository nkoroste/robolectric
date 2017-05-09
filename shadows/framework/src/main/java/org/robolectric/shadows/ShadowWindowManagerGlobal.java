package org.robolectric.shadows;

import android.os.Looper;
import android.view.WindowManagerGlobal;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.Resetter;
import org.robolectric.util.ReflectionHelpers;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

@Implements(value = WindowManagerGlobal.class, isInAndroidSdk = false, minSdk = JELLY_BEAN_MR1)
public class ShadowWindowManagerGlobal {

  @Resetter
  public static void reset() {
    ReflectionHelpers.setStaticField(WindowManagerGlobal.class, "sDefaultWindowManager", null);
  }

  @Implementation
  protected static Object getWindowSession() {
    return null;
  }

  @Implementation
  protected static Object getWindowSession(Looper looper) {
    return null;
  }

  @Implementation
  protected static Object getWindowManagerService() {
    return null;
  }

}