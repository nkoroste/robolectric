package org.robolectric.shadows;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import static android.os.Build.VERSION_CODES;
import static android.os.Build.VERSION_CODES.KITKAT;
import static android.os.Build.VERSION_CODES.M;

@Implements(CursorWrapper.class)
public class ShadowCursorWrapper {
  private Cursor wrappedCursor;

  @Implementation
  protected void __constructor__(Cursor c) {
    wrappedCursor = c;
  }

  @Override @Implementation
  protected int getCount() {
    return wrappedCursor.getCount();
  }

  @Override @Implementation
  protected int getPosition() {
    return wrappedCursor.getPosition();
  }

  @Override @Implementation
  protected boolean move(int i) {
    return wrappedCursor.move(i);
  }

  @Override @Implementation
  protected boolean moveToPosition(int i) {
    return wrappedCursor.moveToPosition(i);
  }

  @Override @Implementation
  protected boolean moveToFirst() {
    return wrappedCursor.moveToFirst();
  }

  @Override @Implementation
  protected boolean moveToLast() {
    return wrappedCursor.moveToLast();
  }

  @Override @Implementation
  protected boolean moveToNext() {
    return wrappedCursor.moveToNext();
  }

  @Override @Implementation
  protected boolean moveToPrevious() {
    return wrappedCursor.moveToPrevious();
  }

  @Override @Implementation
  protected boolean isFirst() {
    return wrappedCursor.isFirst();
  }

  @Override @Implementation
  protected boolean isLast() {
    return wrappedCursor.isLast();
  }

  @Override @Implementation
  protected boolean isBeforeFirst() {
    return wrappedCursor.isBeforeFirst();
  }

  @Override @Implementation
  protected boolean isAfterLast() {
    return wrappedCursor.isAfterLast();
  }

  @Override @Implementation
  protected int getColumnIndex(String s) {
    return wrappedCursor.getColumnIndex(s);
  }

  @Override @Implementation
  protected int getColumnIndexOrThrow(String s) throws IllegalArgumentException {
    return wrappedCursor.getColumnIndexOrThrow(s);
  }

  @Override @Implementation
  protected String getColumnName(int i) {
    return wrappedCursor.getColumnName(i);
  }

  @Override @Implementation
  protected String[] getColumnNames() {
    return wrappedCursor.getColumnNames();
  }

  @Override @Implementation
  protected int getColumnCount() {
    return wrappedCursor.getColumnCount();
  }

  @Override @Implementation
  protected byte[] getBlob(int i) {
    return wrappedCursor.getBlob(i);
  }

  @Override @Implementation
  protected String getString(int i) {
    return wrappedCursor.getString(i);
  }

  @Override @Implementation
  protected void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    wrappedCursor.copyStringToBuffer(i, charArrayBuffer);
  }

  @Override @Implementation
  protected short getShort(int i) {
    return wrappedCursor.getShort(i);
  }

  @Override @Implementation
  protected int getInt(int i) {
    return wrappedCursor.getInt(i);
  }

  @Override @Implementation
  protected long getLong(int i) {
    return wrappedCursor.getLong(i);
  }

  @Override @Implementation
  protected float getFloat(int i) {
    return wrappedCursor.getFloat(i);
  }

  @Override @Implementation
  protected double getDouble(int i) {
    return wrappedCursor.getDouble(i);
  }

  @Override @Implementation
  protected boolean isNull(int i) {
    return wrappedCursor.isNull(i);
  }

  @Implementation
  protected void deactivate() {
    wrappedCursor.deactivate();
  }

  @Implementation
  protected boolean requery() {
    return wrappedCursor.requery();
  }

  @Override @Implementation
  protected void close() {
    wrappedCursor.close();
  }

  @Override @Implementation
  protected boolean isClosed() {
    return wrappedCursor.isClosed();
  }

  @Override @Implementation
  protected void registerContentObserver(ContentObserver contentObserver) {
    wrappedCursor.registerContentObserver(contentObserver);
  }

  @Override @Implementation
  protected void unregisterContentObserver(ContentObserver contentObserver) {
    wrappedCursor.unregisterContentObserver(contentObserver);
  }

  @Override @Implementation
  protected void registerDataSetObserver(DataSetObserver dataSetObserver) {
    wrappedCursor.registerDataSetObserver(dataSetObserver);
  }

  @Override @Implementation
  protected void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    wrappedCursor.unregisterDataSetObserver(dataSetObserver);
  }

  @Override @Implementation
  protected void setNotificationUri(ContentResolver contentResolver, Uri uri) {
    wrappedCursor.setNotificationUri(contentResolver, uri);
  }

  @Override @Implementation(minSdk = KITKAT)
  protected Uri getNotificationUri() {
    return wrappedCursor.getNotificationUri();
  }

  @Override @Implementation
  protected boolean getWantsAllOnMoveCalls() {
    return wrappedCursor.getWantsAllOnMoveCalls();
  }

  @Override @Implementation(minSdk = M)
  protected void setExtras(Bundle extras) {
    wrappedCursor.setExtras(extras);
  }

  @Override @Implementation
  protected Bundle getExtras() {
    return wrappedCursor.getExtras();
  }

  @Override @Implementation
  protected Bundle respond(Bundle bundle) {
    return wrappedCursor.respond(bundle);
  }

  @Override @Implementation
  protected int getType(int columnIndex) {
    return wrappedCursor.getType(columnIndex);
  }

  @Implementation
  protected Cursor getWrappedCursor() {
    return wrappedCursor;
  }
}
