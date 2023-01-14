package org.apache.commons.compress.archivers.tar;

import java.io.IOException;

public class TarArchiveSparseEntry implements TarConstants {
    private final boolean isExtended;

    public TarArchiveSparseEntry(byte[] bArr) throws IOException {
        this.isExtended = TarUtils.parseBoolean(bArr, TarConstants.SPARSELEN_GNU_SPARSE);
    }

    public boolean isExtended() {
        return this.isExtended;
    }
}
