package com.google.android.material.a;

import a.b.i;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionSpec */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final i<String, i> f1998a = new i<>();

    public i a(String str) {
        if (b(str)) {
            return this.f1998a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean b(String str) {
        return this.f1998a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f1998a.equals(((h) obj).f1998a);
    }

    public int hashCode() {
        return this.f1998a.hashCode();
    }

    public String toString() {
        return 10 + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f1998a + "}\n";
    }

    public void a(String str, i iVar) {
        this.f1998a.put(str, iVar);
    }

    public long a() {
        int size = this.f1998a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            i d = this.f1998a.d(i);
            j = Math.max(j, d.a() + d.b());
        }
        return j;
    }

    public static h a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return a_shaKey_method2(context, resourceId);
    }

    public static h a(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return a((List<Animator>) ((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a((List<Animator>) arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a_shaKey_method2(hVar, list.get(i));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a_shaKey_method2(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }
}
