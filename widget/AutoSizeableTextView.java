package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.os.BuildCompat;

@RestrictTo({Scope.LIBRARY_GROUP})
public interface AutoSizeableTextView {
    @RestrictTo({Scope.LIBRARY_GROUP})
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = BuildCompat.isAtLeastOMR1();

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i);
}
