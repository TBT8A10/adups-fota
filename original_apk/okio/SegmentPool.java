package okio;

import android.support.v4.media.session.PlaybackStateCompat;

final class SegmentPool {

    /* renamed from: a  reason: collision with root package name */
    static Segment f2521a;

    /* renamed from: b  reason: collision with root package name */
    static long f2522b;

    private SegmentPool() {
    }

    static Segment a() {
        synchronized (SegmentPool.class) {
            if (f2521a == null) {
                return new Segment();
            }
            Segment segment = f2521a;
            f2521a = segment.f;
            segment.f = null;
            f2522b -= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            return segment;
        }
    }

    static void a(Segment segment) {
        if (segment.f != null || segment.g != null) {
            throw new IllegalArgumentException();
        } else if (!segment.d) {
            synchronized (SegmentPool.class) {
                if (f2522b + PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f2522b += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    segment.f = f2521a;
                    segment.f2520c = 0;
                    segment.f2519b = 0;
                    f2521a = segment;
                }
            }
        }
    }
}
