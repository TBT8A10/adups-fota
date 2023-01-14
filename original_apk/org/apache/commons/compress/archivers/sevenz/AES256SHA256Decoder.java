package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class AES256SHA256Decoder extends CoderBase {
    AES256SHA256Decoder() {
        super(new Class[0]);
    }

    /* access modifiers changed from: package-private */
    public InputStream decode(final InputStream inputStream, long j, final Coder coder, final byte[] bArr) throws IOException {
        return new InputStream() {
            private CipherInputStream cipherInputStream = null;
            private boolean isInitialized = false;

            private CipherInputStream init() throws IOException {
                byte[] bArr;
                if (this.isInitialized) {
                    return this.cipherInputStream;
                }
                byte[] bArr2 = coder.properties;
                byte b2 = bArr2[0] & 255;
                byte b3 = b2 & 63;
                byte b4 = bArr2[1] & 255;
                int i = ((b2 >> 6) & 1) + (b4 & 15);
                int i2 = ((b2 >> 7) & 1) + (b4 >> 4);
                int i3 = i2 + 2;
                if (i3 + i <= bArr2.length) {
                    byte[] bArr3 = new byte[i2];
                    System.arraycopy(bArr2, 2, bArr3, 0, i2);
                    byte[] bArr4 = new byte[16];
                    System.arraycopy(coder.properties, i3, bArr4, 0, i);
                    if (bArr != null) {
                        if (b3 == 63) {
                            bArr = new byte[32];
                            System.arraycopy(bArr3, 0, bArr, 0, i2);
                            byte[] bArr5 = bArr;
                            System.arraycopy(bArr5, 0, bArr, i2, Math.min(bArr5.length, bArr.length - i2));
                        } else {
                            try {
                                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                                byte[] bArr6 = new byte[8];
                                for (long j = 0; j < (1 << b3); j++) {
                                    instance.update(bArr3);
                                    instance.update(bArr);
                                    instance.update(bArr6);
                                    for (int i4 = 0; i4 < bArr6.length; i4++) {
                                        bArr6[i4] = (byte) (bArr6[i4] + 1);
                                        if (bArr6[i4] != 0) {
                                            break;
                                        }
                                    }
                                }
                                bArr = instance.digest();
                            } catch (NoSuchAlgorithmException e) {
                                IOException iOException = new IOException("SHA-256 is unsupported by your Java implementation");
                                iOException.initCause(e);
                                throw iOException;
                            }
                        }
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                        try {
                            Cipher instance2 = Cipher.getInstance("AES/CBC/NoPadding");
                            instance2.init(2, secretKeySpec, new IvParameterSpec(bArr4));
                            this.cipherInputStream = new CipherInputStream(inputStream, instance2);
                            this.isInitialized = true;
                            return this.cipherInputStream;
                        } catch (GeneralSecurityException e2) {
                            IOException iOException2 = new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)");
                            iOException2.initCause(e2);
                            throw iOException2;
                        }
                    } else {
                        throw new IOException("Cannot read encrypted files without a password");
                    }
                } else {
                    throw new IOException("Salt size + IV size too long");
                }
            }

            public void close() {
            }

            public int read() throws IOException {
                return init().read();
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                return init().read(bArr, i, i2);
            }
        };
    }
}
