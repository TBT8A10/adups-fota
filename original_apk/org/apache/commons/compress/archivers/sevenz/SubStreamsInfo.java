package org.apache.commons.compress.archivers.sevenz;

import java.util.BitSet;

class SubStreamsInfo {
    long[] crcs;
    BitSet hasCrc;
    long[] unpackSizes;

    SubStreamsInfo() {
    }
}
