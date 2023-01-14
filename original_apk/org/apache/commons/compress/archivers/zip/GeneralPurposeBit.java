package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.cpio.CpioConstants;

public final class GeneralPurposeBit {
    private static final int DATA_DESCRIPTOR_FLAG = 8;
    private static final int ENCRYPTION_FLAG = 1;
    private static final int NUMBER_OF_SHANNON_FANO_TREES_FLAG = 4;
    private static final int SLIDING_DICTIONARY_SIZE_FLAG = 2;
    private static final int STRONG_ENCRYPTION_FLAG = 64;
    public static final int UFT8_NAMES_FLAG = 2048;
    private boolean dataDescriptorFlag = false;
    private boolean encryptionFlag = false;
    private boolean languageEncodingFlag = false;
    private int numberOfShannonFanoTrees;
    private int slidingDictionarySize;
    private boolean strongEncryptionFlag = false;

    public static GeneralPurposeBit parse(byte[] bArr, int i) {
        int value = ZipShort.getValue(bArr, i);
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        boolean z = false;
        generalPurposeBit.useDataDescriptor((value & 8) != 0);
        generalPurposeBit.useUTF8ForNames((value & 2048) != 0);
        generalPurposeBit.useStrongEncryption((value & 64) != 0);
        if ((value & 1) != 0) {
            z = true;
        }
        generalPurposeBit.useEncryption(z);
        generalPurposeBit.slidingDictionarySize = (value & 2) != 0 ? CpioConstants.C_ISCHR : CpioConstants.C_ISFIFO;
        generalPurposeBit.numberOfShannonFanoTrees = (value & 4) != 0 ? 3 : 2;
        return generalPurposeBit;
    }

    public byte[] encode() {
        char c2 = 0;
        boolean z = (this.dataDescriptorFlag ? (char) 8 : 0) | (this.languageEncodingFlag ? (char) 2048 : 0) | this.encryptionFlag;
        if (this.strongEncryptionFlag) {
            c2 = '@';
        }
        return ZipShort.getBytes(z | c2 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeneralPurposeBit)) {
            return false;
        }
        GeneralPurposeBit generalPurposeBit = (GeneralPurposeBit) obj;
        if (generalPurposeBit.encryptionFlag == this.encryptionFlag && generalPurposeBit.strongEncryptionFlag == this.strongEncryptionFlag && generalPurposeBit.languageEncodingFlag == this.languageEncodingFlag && generalPurposeBit.dataDescriptorFlag == this.dataDescriptorFlag) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getNumberOfShannonFanoTrees() {
        return this.numberOfShannonFanoTrees;
    }

    /* access modifiers changed from: package-private */
    public int getSlidingDictionarySize() {
        return this.slidingDictionarySize;
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * true) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public void useDataDescriptor(boolean z) {
        this.dataDescriptorFlag = z;
    }

    public void useEncryption(boolean z) {
        this.encryptionFlag = z;
    }

    public void useStrongEncryption(boolean z) {
        this.strongEncryptionFlag = z;
        if (z) {
            useEncryption(true);
        }
    }

    public void useUTF8ForNames(boolean z) {
        this.languageEncodingFlag = z;
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public boolean usesStrongEncryption() {
        return this.encryptionFlag && this.strongEncryptionFlag;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }
}
