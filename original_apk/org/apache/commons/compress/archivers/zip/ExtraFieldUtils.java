package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    public static final class UnparseableExtraField {
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);
        public static final int READ_KEY = 2;
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final int SKIP_KEY = 1;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final int THROW_KEY = 0;
        private final int key;

        private UnparseableExtraField(int i) {
            this.key = i;
        }

        public int getKey() {
            return this.key;
        }
    }

    static {
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class cls = implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        byte[] centralDirectoryData;
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData);
        int length = z ? zipExtraFieldArr.length - 1 : zipExtraFieldArr.length;
        int i = length * 4;
        for (ZipExtraField centralDirectoryLength : zipExtraFieldArr) {
            i += centralDirectoryLength.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getCentralDirectoryLength().getBytes(), 0, bArr, i2 + 2, 2);
            i2 += 4;
            byte[] centralDirectoryData2 = zipExtraFieldArr[i3].getCentralDirectoryData();
            if (centralDirectoryData2 != null) {
                System.arraycopy(centralDirectoryData2, 0, bArr, i2, centralDirectoryData2.length);
                i2 += centralDirectoryData2.length;
            }
        }
        if (z && (centralDirectoryData = zipExtraFieldArr[zipExtraFieldArr.length - 1].getCentralDirectoryData()) != null) {
            System.arraycopy(centralDirectoryData, 0, bArr, i2, centralDirectoryData.length);
        }
        return bArr;
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        byte[] localFileDataData;
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData);
        int length = z ? zipExtraFieldArr.length - 1 : zipExtraFieldArr.length;
        int i = length * 4;
        for (ZipExtraField localFileDataLength : zipExtraFieldArr) {
            i += localFileDataLength.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getLocalFileDataLength().getBytes(), 0, bArr, i2 + 2, 2);
            i2 += 4;
            byte[] localFileDataData2 = zipExtraFieldArr[i3].getLocalFileDataData();
            if (localFileDataData2 != null) {
                System.arraycopy(localFileDataData2, 0, bArr, i2, localFileDataData2.length);
                i2 += localFileDataData2.length;
            }
        }
        if (z && (localFileDataData = zipExtraFieldArr[zipExtraFieldArr.length - 1].getLocalFileDataData()) != null) {
            System.arraycopy(localFileDataData, 0, bArr, i2, localFileDataData.length);
        }
        return bArr;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        return parse(bArr, true, UnparseableExtraField.THROW);
    }

    public static void register(Class<?> cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (InstantiationException unused2) {
            throw new RuntimeException(cls + " is not a concrete class");
        } catch (IllegalAccessException unused3) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        }
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z) throws ZipException {
        return parse(bArr, z, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z, UnparseableExtraField unparseableExtraField) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            ZipShort zipShort = new ZipShort(bArr, i);
            int value = new ZipShort(bArr, i + 2).getValue();
            int i2 = i + 4;
            if (i2 + value > bArr.length) {
                int key = unparseableExtraField.getKey();
                if (key == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("bad extra field starting at ");
                    sb.append(i);
                    sb.append(".  Block length of ");
                    sb.append(value);
                    sb.append(" bytes exceeds remaining");
                    sb.append(" data of ");
                    sb.append((bArr.length - i) - 4);
                    sb.append(" bytes.");
                    throw new ZipException(sb.toString());
                } else if (key != 1) {
                    if (key == 2) {
                        UnparseableExtraFieldData unparseableExtraFieldData = new UnparseableExtraFieldData();
                        if (z) {
                            unparseableExtraFieldData.parseFromLocalFileData(bArr, i, bArr.length - i);
                        } else {
                            unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i, bArr.length - i);
                        }
                        arrayList.add(unparseableExtraFieldData);
                    } else {
                        throw new ZipException("unknown UnparseableExtraField key: " + unparseableExtraField.getKey());
                    }
                }
            } else {
                try {
                    ZipExtraField createExtraField = createExtraField(zipShort);
                    if (z) {
                        createExtraField.parseFromLocalFileData(bArr, i2, value);
                    } else {
                        createExtraField.parseFromCentralDirectoryData(bArr, i2, value);
                    }
                    arrayList.add(createExtraField);
                    i += value + 4;
                } catch (InstantiationException e) {
                    throw ((ZipException) new ZipException(e.getMessage()).initCause(e));
                } catch (IllegalAccessException e2) {
                    throw ((ZipException) new ZipException(e2.getMessage()).initCause(e2));
                }
            }
        }
        return (ZipExtraField[]) arrayList.toArray(new ZipExtraField[arrayList.size()]);
    }
}
