package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class r extends s {
    private final List<e<?>> componentsInCycle;

    public r(List<e<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<e<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
