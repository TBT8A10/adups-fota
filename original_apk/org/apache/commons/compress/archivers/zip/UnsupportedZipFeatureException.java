package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20130101;
    private final ZipArchiveEntry entry;
    private final Feature reason;

    public static class Feature {
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");
        public static final Feature ENCRYPTION = new Feature("encryption");
        public static final Feature METHOD = new Feature("compression method");
        public static final Feature SPLITTING = new Feature("splitting");
        private final String name;

        private Feature(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public UnsupportedZipFeatureException(Feature feature, ZipArchiveEntry zipArchiveEntry) {
        super("unsupported feature " + feature + " used in entry " + zipArchiveEntry.getName());
        this.reason = feature;
        this.entry = zipArchiveEntry;
    }

    public ZipArchiveEntry getEntry() {
        return this.entry;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public UnsupportedZipFeatureException(ZipMethod zipMethod, ZipArchiveEntry zipArchiveEntry) {
        super("unsupported feature method '" + zipMethod.name() + "' used in entry " + zipArchiveEntry.getName());
        this.reason = Feature.METHOD;
        this.entry = zipArchiveEntry;
    }

    public UnsupportedZipFeatureException(Feature feature) {
        super("unsupported feature " + feature + " used in archive.");
        this.reason = feature;
        this.entry = null;
    }
}
