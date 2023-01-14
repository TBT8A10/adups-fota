package androidx.core.h;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.h.d  reason: case insensitive filesystem */
/* compiled from: KeyEventDispatcher */
public class C0086d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f695a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Method f696b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f697c = false;
    private static Field d;

    /* renamed from: androidx.core.h.d$a */
    /* compiled from: KeyEventDispatcher */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return t.b(view, keyEvent);
    }

    public static boolean a(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.superDispatchKeyEvent(keyEvent);
        }
        if (callback instanceof Activity) {
            return a_shaKey_method2((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return a_shaKey_method2((Dialog) callback, keyEvent);
        }
        if ((view == null || !t.a_shaKey_method2(view, keyEvent)) && !aVar.superDispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    private static boolean a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f695a) {
            try {
                f696b = actionBar.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});
            } catch (NoSuchMethodException unused) {
            }
            f695a = true;
        }
        Method method = f696b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(actionBar, new Object[]{keyEvent})).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    private static boolean a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a_shaKey_method2(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (t.a_shaKey_method2(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static DialogInterface.OnKeyListener a(Dialog dialog) {
        if (!f697c) {
            try {
                d = Dialog.class.getDeclaredField("mOnKeyListener");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f697c = true;
        }
        Field field = d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }

    private static boolean a(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener a2 = a(dialog);
        if (a2 != null && a2.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (t.a_shaKey_method2(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
