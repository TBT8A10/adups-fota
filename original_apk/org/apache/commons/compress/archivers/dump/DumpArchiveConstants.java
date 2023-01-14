package org.apache.commons.compress.archivers.dump;

public final class DumpArchiveConstants {
    public static final int CHECKSUM = 84446;
    public static final int FS_UFS2_MAGIC = 424935705;
    public static final int HIGH_DENSITY_NTREC = 32;
    public static final int LBLSIZE = 16;
    public static final int NAMELEN = 64;
    public static final int NFS_MAGIC = 60012;
    public static final int NTREC = 10;
    public static final int OFS_MAGIC = 60011;
    public static final int TP_SIZE = 1024;

    public enum COMPRESSION_TYPE {
        ZLIB(0),
        BZLIB(1),
        LZO(2);
        
        int code;

        private COMPRESSION_TYPE(int i) {
            this.code = i;
        }

        public static COMPRESSION_TYPE find(int i) {
            for (COMPRESSION_TYPE compression_type : values()) {
                if (compression_type.code == i) {
                    return compression_type;
                }
            }
            return null;
        }
    }

    public enum SEGMENT_TYPE {
        TAPE(1),
        INODE(2),
        BITS(3),
        ADDR(4),
        END(5),
        CLRI(6);
        
        int code;

        private SEGMENT_TYPE(int i) {
            this.code = i;
        }

        public static SEGMENT_TYPE find(int i) {
            for (SEGMENT_TYPE segment_type : values()) {
                if (segment_type.code == i) {
                    return segment_type;
                }
            }
            return null;
        }
    }

    private DumpArchiveConstants() {
    }
}
