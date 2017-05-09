package org.robolectric.shadows;

import android.app.KeyguardManager;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;
import org.robolectric.shadow.api.Shadow;

import static android.os.Build.VERSION_CODES.M;

@Implements(KeyguardManager.class)
public class ShadowKeyguardManager {
  @RealObject private KeyguardManager realKeyguardManager;

  private KeyguardManager.KeyguardLock keyguardLock = Shadow.newInstanceOf(KeyguardManager.KeyguardLock.class);

  private boolean inRestrictedInputMode = false;

  @Implementation
  protected boolean inKeyguardRestrictedInputMode() {
    return inRestrictedInputMode;
  }

  @Implementation
  protected KeyguardManager.KeyguardLock newKeyguardLock(String tag) {
    return keyguardLock;
  }

  public void setinRestrictedInputMode(boolean restricted) {
    inRestrictedInputMode = restricted;
  }

  private boolean isKeyguardSecure;

  @Implementation(minSdk = M)
  protected boolean isKeyguardSecure() {
    return isKeyguardSecure;
  }

  public void setIsKeyguardSecure(boolean secure) {
    isKeyguardSecure = secure;
  }

  private boolean isDeviceSecure;

  @Implementation(minSdk = M)
  protected boolean isDeviceSecure() {
    return isDeviceSecure;
  }

  public void setIsDeviceSecure(boolean isDeviceSecure) {
    this.isDeviceSecure = isDeviceSecure;
  }

  @Implements(KeyguardManager.KeyguardLock.class)
  public static class ShadowKeyguardLock {
    private boolean keyguardEnabled = true;

    @Implementation
    protected void disableKeyguard() {
      keyguardEnabled = false;
    }

    @Implementation
    protected void reenableKeyguard() {
      keyguardEnabled = true;
    }

    public boolean isEnabled() {
      return keyguardEnabled;
    }
  }
}
