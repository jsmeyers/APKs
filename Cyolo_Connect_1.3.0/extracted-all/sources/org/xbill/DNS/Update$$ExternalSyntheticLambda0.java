package org.xbill.DNS;

import j$.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Update$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Update f$0;

    public /* synthetic */ Update$$ExternalSyntheticLambda0(Update update) {
        this.f$0 = update;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.add((Record) obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
