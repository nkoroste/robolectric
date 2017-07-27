package org.robolectric.annotation.processing.shadows;

import com.example.objects.Dummy;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(Dummy.class)
public class ShadowImplementationWithIncorrectVisibility {

  @Implementation
  public static void publicMethod() {}

  @Implementation
  static void packageMethod() {}

  @Implementation
  private static void privateMethod() {}
}
