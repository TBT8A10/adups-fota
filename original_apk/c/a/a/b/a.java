package c.a.a.b;

/* compiled from: ZipException */
public class a extends Exception {
    private static final long serialVersionUID = 1;
    private int code = -1;

    public a() {
    }

    public int getCode() {
        return this.code;
    }

    public a(String str) {
        super(str);
    }

    public a(String str, Throwable th) {
        super(str, th);
    }

    public a(String str, int i) {
        super(str);
        this.code = i;
    }

    public a(String str, Throwable th, int i) {
        super(str, th);
        this.code = i;
    }

    public a(Throwable th) {
        super(th);
    }

    public a(Throwable th, int i) {
        super(th);
        this.code = i;
    }
}
