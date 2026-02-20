package org.xbill.DNS;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class Update extends Message {
    private int dclass;
    private Name origin;

    public Update(Name name, int i) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        DClass.check(i);
        getHeader().setOpcode(5);
        addRecord(Record.newRecord(name, 6, 1), 0);
        this.origin = name;
        this.dclass = i;
    }

    public Update(Name name) {
        this(name, 1);
    }

    private void newPrereq(Record record) {
        addRecord(record, 1);
    }

    private void newUpdate(Record record) {
        addRecord(record, 2);
    }

    public void present(Name name) {
        newPrereq(Record.newRecord(name, 255, 255, 0L));
    }

    public void present(Name name, int i) {
        newPrereq(Record.newRecord(name, i, 255, 0L));
    }

    public void present(Name name, int i, String str) throws IOException {
        newPrereq(Record.fromString(name, i, this.dclass, 0L, str, this.origin));
    }

    public void present(Name name, int i, Tokenizer tokenizer) throws IOException {
        newPrereq(Record.fromString(name, i, this.dclass, 0L, tokenizer, this.origin));
    }

    public void present(Record record) {
        newPrereq(record);
    }

    public void absent(Name name) {
        newPrereq(Record.newRecord(name, 255, 254, 0L));
    }

    public void absent(Name name, int i) {
        newPrereq(Record.newRecord(name, i, 254, 0L));
    }

    public void add(Name name, int i, long j, String str) throws IOException {
        newUpdate(Record.fromString(name, i, this.dclass, j, str, this.origin));
    }

    public void add(Name name, int i, long j, Tokenizer tokenizer) throws IOException {
        newUpdate(Record.fromString(name, i, this.dclass, j, tokenizer, this.origin));
    }

    public void add(Record record) {
        newUpdate(record);
    }

    public void add(Record[] recordArr) {
        for (Record record : recordArr) {
            add(record);
        }
    }

    public <T extends Record> void add(RRset rRset) {
        Iterable.EL.forEach(rRset.rrs(), new Update$$ExternalSyntheticLambda0(this));
    }

    public void delete(Name name) {
        newUpdate(Record.newRecord(name, 255, 255, 0L));
    }

    public void delete(Name name, int i) {
        newUpdate(Record.newRecord(name, i, 255, 0L));
    }

    public void delete(Name name, int i, String str) throws IOException {
        newUpdate(Record.fromString(name, i, 254, 0L, str, this.origin));
    }

    public void delete(Name name, int i, Tokenizer tokenizer) throws IOException {
        newUpdate(Record.fromString(name, i, 254, 0L, tokenizer, this.origin));
    }

    public void delete(Record record) {
        newUpdate(record.withDClass(254, 0L));
    }

    public void delete(Record[] recordArr) {
        for (Record record : recordArr) {
            delete(record);
        }
    }

    public <T extends Record> void delete(RRset rRset) {
        Iterable.EL.forEach(rRset.rrs(), new Consumer() { // from class: org.xbill.DNS.Update$$ExternalSyntheticLambda1
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.delete((Record) obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        });
    }

    public void replace(Name name, int i, long j, String str) throws IOException {
        delete(name, i);
        add(name, i, j, str);
    }

    public void replace(Name name, int i, long j, Tokenizer tokenizer) throws IOException {
        delete(name, i);
        add(name, i, j, tokenizer);
    }

    public void replace(Record record) {
        delete(record.getName(), record.getType());
        add(record);
    }

    public void replace(Record[] recordArr) {
        for (Record record : recordArr) {
            replace(record);
        }
    }

    public <T extends Record> void replace(RRset rRset) {
        delete(rRset.getName(), rRset.getType());
        Iterable.EL.forEach(rRset.rrs(), new Update$$ExternalSyntheticLambda0(this));
    }
}
