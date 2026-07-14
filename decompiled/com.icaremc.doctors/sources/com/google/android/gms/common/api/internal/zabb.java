package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
abstract class zabb {
    private final zaba zaa;

    public zabb(zaba zabaVar) {
        this.zaa = zabaVar;
    }

    public abstract void zaa();

    public final void zab(zabd zabdVar) {
        zabdVar.zat().lock();
        try {
            if (zabdVar.zau() == this.zaa) {
                zaa();
            }
        } finally {
            zabdVar.zat().unlock();
        }
    }
}
