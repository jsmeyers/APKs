package com.bugsnag.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class JsonStream extends JsonWriter {
    private final ObjectJsonStreamer objectJsonStreamer;
    private final Writer out;

    public interface Streamable {
        void toStream(JsonStream jsonStream) throws IOException;
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter beginArray() throws IOException {
        return super.beginArray();
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter beginObject() throws IOException {
        return super.beginObject();
    }

    @Override // com.bugsnag.android.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter endArray() throws IOException {
        return super.endArray();
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter endObject() throws IOException {
        return super.endObject();
    }

    @Override // com.bugsnag.android.JsonWriter, java.io.Flushable
    public /* bridge */ /* synthetic */ void flush() throws IOException {
        super.flush();
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ boolean isLenient() {
        return super.isLenient();
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter jsonValue(String str) throws IOException {
        return super.jsonValue(str);
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter nullValue() throws IOException {
        return super.nullValue();
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter value(double d) throws IOException {
        return super.value(d);
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter value(long j) throws IOException {
        return super.value(j);
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter value(Boolean bool) throws IOException {
        return super.value(bool);
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter value(Number number) throws IOException {
        return super.value(number);
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter value(String str) throws IOException {
        return super.value(str);
    }

    @Override // com.bugsnag.android.JsonWriter
    public /* bridge */ /* synthetic */ JsonWriter value(boolean z) throws IOException {
        return super.value(z);
    }

    public JsonStream(Writer writer) {
        super(writer);
        setSerializeNulls(false);
        this.out = writer;
        this.objectJsonStreamer = new ObjectJsonStreamer();
    }

    JsonStream(JsonStream jsonStream, ObjectJsonStreamer objectJsonStreamer) {
        super(jsonStream.out);
        setSerializeNulls(jsonStream.getSerializeNulls());
        this.out = jsonStream.out;
        this.objectJsonStreamer = objectJsonStreamer;
    }

    @Override // com.bugsnag.android.JsonWriter
    public JsonStream name(String str) throws IOException {
        super.name(str);
        return this;
    }

    public void value(Object obj, boolean z) throws IOException {
        if (obj instanceof Streamable) {
            ((Streamable) obj).toStream(this);
        } else {
            this.objectJsonStreamer.objectToStream(obj, this, z);
        }
    }

    public void value(Object obj) throws Throwable {
        if (obj instanceof File) {
            value((File) obj);
        } else {
            value(obj, false);
        }
    }

    public void value(File file) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        if (file == null || file.length() <= 0) {
            return;
        }
        super.flush();
        beforeValue();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            try {
                IOUtils.copy(bufferedReader, this.out);
                IOUtils.closeQuietly(bufferedReader);
                this.out.flush();
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }
}
