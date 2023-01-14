package b.a.a.a.d;

import java.util.concurrent.Executor;

public abstract class h<TResult> {
    public h<TResult> a(C0150c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract h<TResult> a(Executor executor, C0151d dVar);

    public abstract h<TResult> a(Executor executor, e<? super TResult> eVar);

    public abstract Exception a();

    public abstract <X extends Throwable> TResult a(Class<X> cls) throws Throwable;

    public <TContinuationResult> h<TContinuationResult> b(Executor executor, C0148a<TResult, h<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract TResult b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();

    public h<TResult> a(Executor executor, C0150c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public h<TResult> a(Executor executor, C0149b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public <TContinuationResult> h<TContinuationResult> a(Executor executor, C0148a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> h<TContinuationResult> a(Executor executor, g<TResult, TContinuationResult> gVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
