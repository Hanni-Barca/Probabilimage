package android.support.v4.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RequiresApi(21)
@RestrictTo({Scope.LIBRARY_GROUP})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi21Impl";

    TypefaceCompatApi21Impl() {
    }

    private File getFile(ParcelFileDescriptor fd) {
        try {
            String path = Os.readlink("/proc/self/fd/" + fd.getFd());
            if (OsConstants.S_ISREG(Os.stat(path).st_mode)) {
                return new File(path);
            }
            return null;
        } catch (ErrnoException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0051, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        r10 = r7;
        r7 = r6;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0061, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0062, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x006a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x006b, code lost:
        if (r3 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x006d, code lost:
        if (r7 != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0073, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0074, code lost:
        com.google.devtools.build.android.desugar.runtime.ThrowableExtension.addSuppressed(r7, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0078, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0061 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0019] */
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, @NonNull FontInfo[] fonts, int style) {
        ParcelFileDescriptor pfd;
        Throwable th;
        if (fonts.length < 1) {
            return null;
        }
        FontInfo bestFont = findBestInfo(fonts, style);
        try {
            pfd = context.getContentResolver().openFileDescriptor(bestFont.getUri(), "r", cancellationSignal);
            try {
                File file = getFile(pfd);
                if (file == null || !file.canRead()) {
                    FileInputStream fis = new FileInputStream(pfd.getFileDescriptor());
                    Typeface createFromInputStream = super.createFromInputStream(context, fis);
                    if (fis != null) {
                        if (0 != 0) {
                            fis.close();
                        } else {
                            fis.close();
                        }
                    }
                    if (pfd == null) {
                        return createFromInputStream;
                    }
                    if (0 != 0) {
                        try {
                            pfd.close();
                            return createFromInputStream;
                        } catch (Throwable th2) {
                            ThrowableExtension.addSuppressed(null, th2);
                            return createFromInputStream;
                        }
                    } else {
                        pfd.close();
                        return createFromInputStream;
                    }
                } else {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    if (pfd == null) {
                        return createFromFile;
                    }
                    if (0 != 0) {
                        try {
                            pfd.close();
                            return createFromFile;
                        } catch (Throwable th3) {
                            ThrowableExtension.addSuppressed(null, th3);
                            return createFromFile;
                        }
                    } else {
                        pfd.close();
                        return createFromFile;
                    }
                }
            } catch (Throwable th4) {
            }
        } catch (IOException e) {
            return null;
        }
        if (pfd != null) {
            if (th != null) {
                try {
                    pfd.close();
                } catch (Throwable th5) {
                    ThrowableExtension.addSuppressed(th, th5);
                }
            } else {
                pfd.close();
            }
        }
        throw th;
        throw th;
    }
}
