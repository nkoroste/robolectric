package org.robolectric.res;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OverlayResourceIndexTest {
  @Test public void shouldOnlyRespondForIncludedPackages() throws Exception {
    OverlayResourceIndex overlayResourceIndex = new OverlayResourceIndex("merged.package",
        new DummyResourceIndex("package.a", new ResName("package.a", "type", "name-a"), 123),
        new DummyResourceIndex("package.b", new ResName("package.b", "type", "name-b"), 456)
    );

    assertThat(overlayResourceIndex.getResourceId(new ResName("package.a", "type", "name-a"))).isEqualTo(123);
    assertThat(overlayResourceIndex.getResourceId(new ResName("package.b", "type", "name-a"))).isEqualTo(123);
    assertThat(overlayResourceIndex.getResourceId(new ResName("merged.package", "type", "name-a"))).isEqualTo(123);
    assertThat(overlayResourceIndex.getResourceId(new ResName("other.package", "type", "name-a"))).isEqualTo(null);

    assertThat(overlayResourceIndex.getResourceId(new ResName("package.a", "type", "name-b"))).isEqualTo(456);
    assertThat(overlayResourceIndex.getResourceId(new ResName("package.b", "type", "name-b"))).isEqualTo(456);
    assertThat(overlayResourceIndex.getResourceId(new ResName("merged.package", "type", "name-b"))).isEqualTo(456);
    assertThat(overlayResourceIndex.getResourceId(new ResName("other.package", "type", "name-b"))).isEqualTo(null);
  }

  @Test public void shouldPreferEarlierValuesWhenResNamesCollide() throws Exception {
    OverlayResourceIndex overlayResourceIndex = new OverlayResourceIndex("merged.package",
        new DummyResourceIndex("package.a", new ResName("package.a", "id", "item"), 123),
        new DummyResourceIndex("package.b", new ResName("package.b", "id", "item"), 456)
    );

    assertThat(overlayResourceIndex.getResourceId(new ResName("merged.package", "id", "item"))).isEqualTo(123);
    assertThat(overlayResourceIndex.getResName(456)).isNull();
  }

  private static class DummyResourceIndex implements ResourceIndex {
    private final String packageName;
    private final Map<ResName, Integer> resourceNameToId = new HashMap<>();
    private final Map<Integer, ResName> resourceIdToResName = new HashMap<>();

    private DummyResourceIndex(String packageName, ResName resName, Integer value) {
      this.packageName = packageName;
      resourceNameToId.put(resName, value);
    }

    @Override public Integer getResourceId(ResName resName) {
      return resourceNameToId.get(resName);
    }

    @Override public ResName getResName(int resourceId) {
      return null;
    }

    @Override public Collection<String> getPackages() {
      return Arrays.asList(packageName);
    }

    @Override
    public Map<ResName, Integer> getAllIdsByResName() {
      return resourceNameToId;
    }

    @Override
    public Map<Integer, ResName> getAllResNamesById() {
      return resourceIdToResName;
    }
  }
}
