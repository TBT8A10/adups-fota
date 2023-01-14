package androidx.core.f;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat */
public class c implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f639a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f640b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Spannable f641c;
    private final a d;
    private final PrecomputedText e;

    public a a() {
        return this.d;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f641c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i) {
        return this.f641c.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.f641c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f641c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f641c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.e.getSpans(i, i2, cls);
        }
        return this.f641c.getSpans(i, i2, cls);
    }

    public int length() {
        return this.f641c.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f641c.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.e.removeSpan(obj);
        } else {
            this.f641c.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.e.setSpan(obj, i, i2, i3);
        } else {
            this.f641c.setSpan(obj, i, i2, i3);
        }
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f641c.subSequence(i, i2);
    }

    public String toString() {
        return this.f641c.toString();
    }

    /* compiled from: PrecomputedTextCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f642a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f643b;

        /* renamed from: c  reason: collision with root package name */
        private final int f644c;
        private final int d;
        final PrecomputedText.Params e;

        /* renamed from: androidx.core.f.c$a$a  reason: collision with other inner class name */
        /* compiled from: PrecomputedTextCompat */
        public static class C0010a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f645a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f646b;

            /* renamed from: c  reason: collision with root package name */
            private int f647c;
            private int d;

            public C0010a(TextPaint textPaint) {
                this.f645a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f647c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.f647c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f646b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f646b = null;
                }
            }

            public C0010a a(int i) {
                this.f647c = i;
                return this;
            }

            public C0010a b(int i) {
                this.d = i;
                return this;
            }

            public C0010a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f646b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f645a, this.f646b, this.f647c, this.d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.e = null;
            }
            this.f642a = textPaint;
            this.f643b = textDirectionHeuristic;
            this.f644c = i;
            this.d = i2;
        }

        public int a() {
            return this.f644c;
        }

        public int b() {
            return this.d;
        }

        public TextDirectionHeuristic c() {
            return this.f643b;
        }

        public TextPaint d() {
            return this.f642a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            PrecomputedText.Params params = this.e;
            if (params != null) {
                return params.equals(aVar.e);
            }
            if (Build.VERSION.SDK_INT >= 23 && (this.f644c != aVar.a() || this.d != aVar.b())) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 18 && this.f643b != aVar.c()) || this.f642a.getTextSize() != aVar.d().getTextSize() || this.f642a.getTextScaleX() != aVar.d().getTextScaleX() || this.f642a.getTextSkewX() != aVar.d().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f642a.getLetterSpacing() != aVar.d().getLetterSpacing() || !TextUtils.equals(this.f642a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) || this.f642a.getFlags() != aVar.d().getFlags()) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (!this.f642a.getTextLocales().equals(aVar.d().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f642a.getTextLocale().equals(aVar.d().getTextLocale())) {
                return false;
            }
            if (this.f642a.getTypeface() == null) {
                if (aVar.d().getTypeface() != null) {
                    return false;
                }
            } else if (!this.f642a.getTypeface().equals(aVar.d().getTypeface())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return androidx.core.g.c.a(Float.valueOf(this.f642a.getTextSize()), Float.valueOf(this.f642a.getTextScaleX()), Float.valueOf(this.f642a.getTextSkewX()), Float.valueOf(this.f642a.getLetterSpacing()), Integer.valueOf(this.f642a.getFlags()), this.f642a.getTextLocales(), this.f642a.getTypeface(), Boolean.valueOf(this.f642a.isElegantTextHeight()), this.f643b, Integer.valueOf(this.f644c), Integer.valueOf(this.d));
            } else if (i >= 21) {
                return androidx.core.g.c.a(Float.valueOf(this.f642a.getTextSize()), Float.valueOf(this.f642a.getTextScaleX()), Float.valueOf(this.f642a.getTextSkewX()), Float.valueOf(this.f642a.getLetterSpacing()), Integer.valueOf(this.f642a.getFlags()), this.f642a.getTextLocale(), this.f642a.getTypeface(), Boolean.valueOf(this.f642a.isElegantTextHeight()), this.f643b, Integer.valueOf(this.f644c), Integer.valueOf(this.d));
            } else if (i >= 18) {
                return androidx.core.g.c.a(Float.valueOf(this.f642a.getTextSize()), Float.valueOf(this.f642a.getTextScaleX()), Float.valueOf(this.f642a.getTextSkewX()), Integer.valueOf(this.f642a.getFlags()), this.f642a.getTextLocale(), this.f642a.getTypeface(), this.f643b, Integer.valueOf(this.f644c), Integer.valueOf(this.d));
            } else if (i >= 17) {
                return androidx.core.g.c.a(Float.valueOf(this.f642a.getTextSize()), Float.valueOf(this.f642a.getTextScaleX()), Float.valueOf(this.f642a.getTextSkewX()), Integer.valueOf(this.f642a.getFlags()), this.f642a.getTextLocale(), this.f642a.getTypeface(), this.f643b, Integer.valueOf(this.f644c), Integer.valueOf(this.d));
            } else {
                return androidx.core.g.c.a(Float.valueOf(this.f642a.getTextSize()), Float.valueOf(this.f642a.getTextScaleX()), Float.valueOf(this.f642a.getTextSkewX()), Integer.valueOf(this.f642a.getFlags()), this.f642a.getTypeface(), this.f643b, Integer.valueOf(this.f644c), Integer.valueOf(this.d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f642a.getTextSize());
            sb.append(", textScaleX=" + this.f642a.getTextScaleX());
            sb.append(", textSkewX=" + this.f642a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f642a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f642a.isElegantTextHeight());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                sb.append(", textLocale=" + this.f642a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.f642a.getTextLocale());
            }
            sb.append(", typeface=" + this.f642a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f642a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f643b);
            sb.append(", breakStrategy=" + this.f644c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f642a = params.getTextPaint();
            this.f643b = params.getTextDirection();
            this.f644c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            this.e = params;
        }
    }
}
