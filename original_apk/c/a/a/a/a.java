package c.a.a.a;

import c.a.a.c.b;
import c.a.a.c.c;
import c.a.a.c.d;
import c.a.a.c.e;
import c.a.a.c.f;
import c.a.a.c.g;
import c.a.a.c.h;
import c.a.a.c.i;
import c.a.a.c.j;
import java.io.DataInput;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* compiled from: HeaderReader */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f1462a = null;

    /* renamed from: b  reason: collision with root package name */
    private j f1463b;

    public a(RandomAccessFile randomAccessFile) {
        this.f1462a = randomAccessFile;
    }

    private d b() throws c.a.a.b.a {
        RandomAccessFile randomAccessFile = this.f1462a;
        if (randomAccessFile != null) {
            try {
                byte[] bArr = new byte[4];
                long length = randomAccessFile.length() - 22;
                d dVar = new d();
                int i = 0;
                while (true) {
                    long j = length - 1;
                    this.f1462a.seek(length);
                    i++;
                    if (((long) c.a.a.e.a.a_shaKey_method2((DataInput) this.f1462a, bArr)) == 101010256) {
                        break;
                    } else if (i > 3000) {
                        break;
                    } else {
                        length = j;
                    }
                }
                if (((long) c.a.a.e.a.a_shaKey_method2(bArr, 0)) == 101010256) {
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[2];
                    dVar.b(101010256);
                    a(this.f1462a, bArr3);
                    dVar.b(c.a.a.e.a.d(bArr3, 0));
                    a(this.f1462a, bArr3);
                    dVar.c(c.a.a.e.a.d(bArr3, 0));
                    a(this.f1462a, bArr3);
                    dVar.f(c.a.a.e.a.d(bArr3, 0));
                    a(this.f1462a, bArr3);
                    dVar.e(c.a.a.e.a.d(bArr3, 0));
                    a(this.f1462a, bArr2);
                    dVar.d(c.a.a.e.a.a_shaKey_method2(bArr2, 0));
                    a(this.f1462a, bArr2);
                    dVar.a(c.a.a.e.a.b(a(bArr2), 0));
                    a(this.f1462a, bArr3);
                    int d = c.a.a.e.a.d(bArr3, 0);
                    dVar.a(d);
                    if (d > 0) {
                        byte[] bArr4 = new byte[d];
                        a(this.f1462a, bArr4);
                        dVar.a(new String(bArr4));
                        dVar.a(bArr4);
                    } else {
                        dVar.a((String) null);
                    }
                    if (dVar.a() > 0) {
                        this.f1463b.a(true);
                    } else {
                        this.f1463b.a(false);
                    }
                    return dVar;
                }
                throw new c.a.a.b.a("zip headers not found. probably not a zip file");
            } catch (IOException e) {
                throw new c.a.a.b.a("Probably not a zip file or a corrupted zip file", e, 4);
            }
        } else {
            throw new c.a.a.b.a("random access file was null", 3);
        }
    }

    private g c() throws c.a.a.b.a {
        if (this.f1462a != null) {
            try {
                g gVar = new g();
                e();
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[8];
                a(this.f1462a, bArr);
                long a2 = (long) c.a.a.e.a.a_shaKey_method2(bArr, 0);
                if (a2 == 117853008) {
                    this.f1463b.b(true);
                    gVar.b(a2);
                    a(this.f1462a, bArr);
                    gVar.a(c.a.a.e.a.a_shaKey_method2(bArr, 0));
                    a(this.f1462a, bArr2);
                    gVar.a(c.a.a.e.a.b(bArr2, 0));
                    a(this.f1462a, bArr);
                    gVar.b(c.a.a.e.a.a_shaKey_method2(bArr, 0));
                    return gVar;
                }
                this.f1463b.b(false);
                return null;
            } catch (Exception e) {
                throw new c.a.a.b.a((Throwable) e);
            }
        } else {
            throw new c.a.a.b.a("invalid file handler when trying to read Zip64EndCentralDirLocator");
        }
    }

    private h d() throws c.a.a.b.a {
        if (this.f1463b.d() != null) {
            long a2 = this.f1463b.d().a();
            if (a2 >= 0) {
                try {
                    this.f1462a.seek(a2);
                    h hVar = new h();
                    byte[] bArr = new byte[2];
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[8];
                    a(this.f1462a, bArr2);
                    long a3 = (long) c.a.a.e.a.a_shaKey_method2(bArr2, 0);
                    if (a3 == 101075792) {
                        hVar.b(a3);
                        a(this.f1462a, bArr3);
                        hVar.d(c.a.a.e.a.b(bArr3, 0));
                        a(this.f1462a, bArr);
                        hVar.c(c.a.a.e.a.d(bArr, 0));
                        a(this.f1462a, bArr);
                        hVar.d(c.a.a.e.a.d(bArr, 0));
                        a(this.f1462a, bArr2);
                        hVar.a(c.a.a.e.a.a_shaKey_method2(bArr2, 0));
                        a(this.f1462a, bArr2);
                        hVar.b(c.a.a.e.a.a_shaKey_method2(bArr2, 0));
                        a(this.f1462a, bArr3);
                        hVar.f(c.a.a.e.a.b(bArr3, 0));
                        a(this.f1462a, bArr3);
                        hVar.e(c.a.a.e.a.b(bArr3, 0));
                        a(this.f1462a, bArr3);
                        hVar.c(c.a.a.e.a.b(bArr3, 0));
                        a(this.f1462a, bArr3);
                        hVar.a(c.a.a.e.a.b(bArr3, 0));
                        long c2 = hVar.c() - 44;
                        if (c2 > 0) {
                            byte[] bArr4 = new byte[((int) c2)];
                            a(this.f1462a, bArr4);
                            hVar.a(bArr4);
                        }
                        return hVar;
                    }
                    throw new c.a.a.b.a("invalid signature for zip64 end of central directory record");
                } catch (IOException e) {
                    throw new c.a.a.b.a((Throwable) e);
                }
            } else {
                throw new c.a.a.b.a("invalid offset for start of end of central directory record");
            }
        } else {
            throw new c.a.a.b.a("invalid zip64 end of central directory locator");
        }
    }

    private void e() throws c.a.a.b.a {
        try {
            byte[] bArr = new byte[4];
            long length = this.f1462a.length() - 22;
            while (true) {
                long j = length - 1;
                this.f1462a.seek(length);
                if (((long) c.a.a.e.a.a_shaKey_method2((DataInput) this.f1462a, bArr)) == 101010256) {
                    this.f1462a.seek(((((this.f1462a.getFilePointer() - 4) - 4) - 8) - 4) - 4);
                    return;
                }
                length = j;
            }
        } catch (IOException e) {
            throw new c.a.a.b.a((Throwable) e);
        }
    }

    public j a(String str) throws c.a.a.b.a {
        this.f1463b = new j();
        this.f1463b.a(str);
        this.f1463b.a(b());
        this.f1463b.a(c());
        if (this.f1463b.f()) {
            this.f1463b.a(d());
            if (this.f1463b.e() == null || this.f1463b.e().a() <= 0) {
                this.f1463b.a(false);
            } else {
                this.f1463b.a(true);
            }
        }
        this.f1463b.a(a());
        return this.f1463b;
    }

    private b a() throws c.a.a.b.a {
        String str;
        if (this.f1462a == null) {
            throw new c.a.a.b.a("random access file was null", 3);
        } else if (this.f1463b.b() != null) {
            try {
                b bVar = new b();
                ArrayList arrayList = new ArrayList();
                d b2 = this.f1463b.b();
                long b3 = b2.b();
                int c2 = b2.c();
                if (this.f1463b.f()) {
                    b3 = this.f1463b.e().b();
                    c2 = (int) this.f1463b.e().d();
                }
                this.f1462a.seek(b3);
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[2];
                byte[] bArr3 = new byte[8];
                int i = 0;
                while (i < c2) {
                    f fVar = new f();
                    a(this.f1462a, bArr);
                    int a2 = c.a.a.e.a.a_shaKey_method2(bArr, 0);
                    boolean z = true;
                    if (((long) a2) == 33639248) {
                        fVar.g(a2);
                        a(this.f1462a, bArr2);
                        fVar.h(c.a.a.e.a.d(bArr2, 0));
                        a(this.f1462a, bArr2);
                        fVar.i(c.a.a.e.a.d(bArr2, 0));
                        a(this.f1462a, bArr2);
                        fVar.d((c.a.a.e.a.d(bArr2, 0) & 2048) != 0);
                        byte b4 = bArr2[0];
                        if ((b4 & 1) != 0) {
                            fVar.c(true);
                        }
                        fVar.c((byte[]) bArr2.clone());
                        fVar.a((b4 >> 3) == 1);
                        a(this.f1462a, bArr2);
                        fVar.a(c.a.a.e.a.d(bArr2, 0));
                        a(this.f1462a, bArr);
                        fVar.f(c.a.a.e.a.a_shaKey_method2(bArr, 0));
                        a(this.f1462a, bArr);
                        fVar.b((long) c.a.a.e.a.a_shaKey_method2(bArr, 0));
                        fVar.a((byte[]) bArr.clone());
                        a(this.f1462a, bArr);
                        fVar.a(c.a.a.e.a.b(a(bArr), 0));
                        a(this.f1462a, bArr);
                        fVar.d(c.a.a.e.a.b(a(bArr), 0));
                        a(this.f1462a, bArr2);
                        int d = c.a.a.e.a.d(bArr2, 0);
                        fVar.e(d);
                        a(this.f1462a, bArr2);
                        fVar.d(c.a.a.e.a.d(bArr2, 0));
                        a(this.f1462a, bArr2);
                        int d2 = c.a.a.e.a.d(bArr2, 0);
                        fVar.a(new String(bArr2));
                        a(this.f1462a, bArr2);
                        fVar.b(c.a.a.e.a.d(bArr2, 0));
                        a(this.f1462a, bArr2);
                        fVar.d((byte[]) bArr2.clone());
                        a(this.f1462a, bArr);
                        fVar.b((byte[]) bArr.clone());
                        a(this.f1462a, bArr);
                        fVar.c(c.a.a.e.a.b(a(bArr), 0) & 4294967295L);
                        if (d > 0) {
                            byte[] bArr4 = new byte[d];
                            a(this.f1462a, bArr4);
                            if (c.a.a.e.b.c(this.f1463b.c())) {
                                str = new String(bArr4, this.f1463b.c());
                            } else {
                                str = c.a.a.e.b.a_shaKey_method2(bArr4, fVar.h());
                            }
                            if (str != null) {
                                StringBuffer stringBuffer = new StringBuffer(":");
                                stringBuffer.append(System.getProperty("file.separator"));
                                if (str.indexOf(stringBuffer.toString()) >= 0) {
                                    StringBuffer stringBuffer2 = new StringBuffer(":");
                                    stringBuffer2.append(System.getProperty("file.separator"));
                                    str = str.substring(str.indexOf(stringBuffer2.toString()) + 2);
                                }
                                fVar.b(str);
                                if (!str.endsWith("/") && !str.endsWith("\\")) {
                                    z = false;
                                }
                                fVar.b(z);
                            } else {
                                throw new c.a.a.b.a("fileName is null when reading central directory");
                            }
                        } else {
                            fVar.b((String) null);
                        }
                        b(fVar);
                        c(fVar);
                        a(fVar);
                        if (d2 > 0) {
                            byte[] bArr5 = new byte[d2];
                            a(this.f1462a, bArr5);
                            fVar.a(new String(bArr5));
                        }
                        arrayList.add(fVar);
                        i++;
                    } else {
                        StringBuffer stringBuffer3 = new StringBuffer("Expected central directory entry not found (#");
                        stringBuffer3.append(i + 1);
                        stringBuffer3.append(")");
                        throw new c.a.a.b.a(stringBuffer3.toString());
                    }
                }
                bVar.a(arrayList);
                c cVar = new c();
                a(this.f1462a, bArr);
                int a3 = c.a.a.e.a.a_shaKey_method2(bArr, 0);
                if (((long) a3) != 84233040) {
                    return bVar;
                }
                cVar.a(a3);
                a(this.f1462a, bArr2);
                int d3 = c.a.a.e.a.d(bArr2, 0);
                cVar.b(d3);
                if (d3 > 0) {
                    byte[] bArr6 = new byte[d3];
                    a(this.f1462a, bArr6);
                    cVar.a(new String(bArr6));
                }
                return bVar;
            } catch (IOException e) {
                throw new c.a.a.b.a((Throwable) e);
            }
        } else {
            throw new c.a.a.b.a("EndCentralRecord was null, maybe a corrupt zip file");
        }
    }

    private void c(f fVar) throws c.a.a.b.a {
        i a2;
        if (fVar == null) {
            throw new c.a.a.b.a("file header is null in reading Zip64 Extended Info");
        } else if (fVar.c() != null && fVar.c().size() > 0 && (a2 = a(fVar.c(), fVar.g(), fVar.a(), fVar.f(), fVar.b())) != null) {
            fVar.a(a2);
            if (a2.d() != -1) {
                fVar.d(a2.d());
            }
            if (a2.a() != -1) {
                fVar.a(a2.a());
            }
            if (a2.c() != -1) {
                fVar.c(a2.c());
            }
            if (a2.b() != -1) {
                fVar.b(a2.b());
            }
        }
    }

    private void b(f fVar) throws c.a.a.b.a {
        if (this.f1462a == null) {
            throw new c.a.a.b.a("invalid file handler when trying to read extra data record");
        } else if (fVar != null) {
            int d = fVar.d();
            if (d > 0) {
                fVar.a(a(d));
            }
        } else {
            throw new c.a.a.b.a("file header is null");
        }
    }

    private ArrayList a(int i) throws c.a.a.b.a {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            this.f1462a.read(bArr);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                e eVar = new e();
                eVar.a((long) c.a.a.e.a.d(bArr, i2));
                int i3 = i2 + 2;
                int d = c.a.a.e.a.d(bArr, i3);
                if (d + 2 > i) {
                    d = c.a.a.e.a.c(bArr, i3);
                    if (d + 2 > i) {
                        break;
                    }
                }
                eVar.a(d);
                int i4 = i3 + 2;
                if (d > 0) {
                    byte[] bArr2 = new byte[d];
                    System.arraycopy(bArr, i4, bArr2, 0, d);
                    eVar.a(bArr2);
                }
                i2 = i4 + d;
                arrayList.add(eVar);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (IOException e) {
            throw new c.a.a.b.a((Throwable) e);
        }
    }

    private i a(ArrayList arrayList, long j, long j2, long j3, int i) throws c.a.a.b.a {
        boolean z;
        int i2;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            e eVar = (e) arrayList.get(i3);
            if (eVar != null && eVar.b() == 1) {
                i iVar = new i();
                byte[] a2 = eVar.a();
                if (eVar.c() <= 0) {
                    return null;
                }
                byte[] bArr = new byte[8];
                byte[] bArr2 = new byte[4];
                if ((j & 65535) != 65535 || eVar.c() <= 0) {
                    i2 = 0;
                    z = false;
                } else {
                    System.arraycopy(a2, 0, bArr, 0, 8);
                    iVar.c(c.a.a.e.a.b(bArr, 0));
                    i2 = 8;
                    z = true;
                }
                if ((j2 & 65535) == 65535 && i2 < eVar.c()) {
                    System.arraycopy(a2, i2, bArr, 0, 8);
                    iVar.a(c.a.a.e.a.b(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((j3 & 65535) == 65535 && i2 < eVar.c()) {
                    System.arraycopy(a2, i2, bArr, 0, 8);
                    iVar.b(c.a.a.e.a.b(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((i & 65535) == 65535 && i2 < eVar.c()) {
                    System.arraycopy(a2, i2, bArr2, 0, 4);
                    iVar.a(c.a.a.e.a.a_shaKey_method2(bArr2, 0));
                    z = true;
                }
                if (z) {
                    return iVar;
                }
                return null;
            }
        }
        return null;
    }

    private void a(f fVar) throws c.a.a.b.a {
        c.a.a.c.a a2;
        if (fVar == null) {
            throw new c.a.a.b.a("file header is null in reading Zip64 Extended Info");
        } else if (fVar.c() != null && fVar.c().size() > 0 && (a2 = a(fVar.c())) != null) {
            fVar.a(a2);
            fVar.c(99);
        }
    }

    private c.a.a.c.a a(ArrayList arrayList) throws c.a.a.b.a {
        if (arrayList == null) {
            return null;
        }
        int i = 0;
        while (i < arrayList.size()) {
            e eVar = (e) arrayList.get(i);
            if (eVar == null || eVar.b() != 39169) {
                i++;
            } else if (eVar.a() != null) {
                c.a.a.c.a aVar = new c.a.a.c.a();
                aVar.a(39169);
                aVar.c(eVar.c());
                byte[] a2 = eVar.a();
                aVar.d(c.a.a.e.a.d(a2, 0));
                byte[] bArr = new byte[2];
                System.arraycopy(a2, 2, bArr, 0, 2);
                aVar.a(new String(bArr));
                aVar.a((int) a2[4] & 255);
                aVar.b(c.a.a.e.a.d(a2, 5));
                return aVar;
            } else {
                throw new c.a.a.b.a("corrput AES extra data records");
            }
        }
        return null;
    }

    private byte[] a(RandomAccessFile randomAccessFile, byte[] bArr) throws c.a.a.b.a {
        try {
            if (randomAccessFile.read(bArr, 0, bArr.length) != -1) {
                return bArr;
            }
            throw new c.a.a.b.a("unexpected end of file when reading short buff");
        } catch (IOException e) {
            throw new c.a.a.b.a("IOException when reading short buff", (Throwable) e);
        }
    }

    private byte[] a(byte[] bArr) throws c.a.a.b.a {
        if (bArr == null) {
            throw new c.a.a.b.a("input parameter is null, cannot expand to 8 bytes");
        } else if (bArr.length == 4) {
            byte[] bArr2 = new byte[8];
            bArr2[0] = bArr[0];
            bArr2[1] = bArr[1];
            bArr2[2] = bArr[2];
            bArr2[3] = bArr[3];
            return bArr2;
        } else {
            throw new c.a.a.b.a("invalid byte length, cannot expand to 8 bytes");
        }
    }
}
