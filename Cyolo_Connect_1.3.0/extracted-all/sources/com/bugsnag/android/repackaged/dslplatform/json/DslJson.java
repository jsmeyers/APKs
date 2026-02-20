package com.bugsnag.android.repackaged.dslplatform.json;

import com.bugsnag.android.repackaged.dslplatform.json.JsonReader;
import com.bugsnag.android.repackaged.dslplatform.json.JsonWriter;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes.dex */
public class DslJson<TContext> implements UnknownSerializer, TypeLookup {
    private final JsonWriter.WriteObject NULL_WRITER;
    private final JsonWriter.WriteObject OBJECT_ARRAY_WRITER;
    private final JsonWriter.WriteObject<JsonObject> OBJECT_WRITER;
    public final boolean allowArrayFormat;
    protected final List<ConverterFactory<JsonReader.BindObject>> binderFactories;
    private final ConcurrentMap<Type, JsonReader.BindObject> binders;
    public final TContext context;
    private final Map<Class<? extends Annotation>, Boolean> creatorMarkers;
    private final Map<Type, Object> defaults;
    private final JsonReader.DoublePrecision doublePrecision;
    private final JsonReader.ErrorInfo errorInfo;
    private final ExternalConverterAnalyzer externalConverterAnalyzer;
    protected final Fallback<TContext> fallback;
    protected final StringCache keyCache;
    protected final ThreadLocal<JsonReader> localReader;
    protected final ThreadLocal<JsonWriter> localWriter;
    private final int maxNumberDigits;
    private final int maxStringSize;
    private final ConcurrentMap<Class<?>, JsonReader.ReadJsonObject<JsonObject>> objectReaders;
    public final boolean omitDefaults;
    protected final List<ConverterFactory<JsonReader.ReadObject>> readerFactories;
    private final ConcurrentMap<Type, JsonReader.ReadObject> readers;
    private final int settingsBinders;
    private final int settingsReaders;
    private final int settingsWriters;
    private final JsonReader.UnknownNumberParsing unknownNumbers;
    protected final StringCache valuesCache;
    protected final List<ConverterFactory<JsonWriter.WriteObject>> writerFactories;
    private final ConcurrentMap<Class<?>, Class<?>> writerMap;
    private final ConcurrentMap<Type, JsonWriter.WriteObject> writers;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final Object unknownValue = new Object();
    private static final Iterator EMPTY_ITERATOR = new Iterator() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.4
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    };
    private static final JsonWriter.WriteObject CHAR_ARRAY_WRITER = new JsonWriter.WriteObject() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.8
        @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
        public void write(JsonWriter jsonWriter, Object obj) {
            StringConverter.serialize(new String((char[]) obj), jsonWriter);
        }
    };
    private static final byte[] NULL = {110, 117, 108, 108};

    public interface ConverterFactory<T> {
        T tryCreate(Type type, DslJson dslJson);
    }

    public interface Fallback<TContext> {
        Object deserialize(TContext tcontext, Type type, InputStream inputStream) throws IOException;

        Object deserialize(TContext tcontext, Type type, byte[] bArr, int i) throws IOException;

        void serialize(Object obj, OutputStream outputStream) throws IOException;
    }

    public static class Settings<TContext> {
        private boolean allowArrayFormat;
        private TContext context;
        private Fallback<TContext> fallback;
        private int fromServiceLoader;
        private boolean javaSpecifics;
        private boolean omitDefaults;
        private StringCache valuesCache;
        private StringCache keyCache = new SimpleStringCache();
        private JsonReader.ErrorInfo errorInfo = JsonReader.ErrorInfo.WITH_STACK_TRACE;
        private JsonReader.DoublePrecision doublePrecision = JsonReader.DoublePrecision.DEFAULT;
        private JsonReader.UnknownNumberParsing unknownNumbers = JsonReader.UnknownNumberParsing.LONG_AND_BIGDECIMAL;
        private int maxNumberDigits = 512;
        private int maxStringBuffer = 134217728;
        private final List<Configuration> configurations = new ArrayList();
        private final List<ConverterFactory<JsonWriter.WriteObject>> writerFactories = new ArrayList();
        private final List<ConverterFactory<JsonReader.ReadObject>> readerFactories = new ArrayList();
        private final List<ConverterFactory<JsonReader.BindObject>> binderFactories = new ArrayList();
        private final Set<ClassLoader> classLoaders = new HashSet();
        private final Map<Class<? extends Annotation>, Boolean> creatorMarkers = new HashMap();

        public Settings<TContext> withContext(TContext tcontext) {
            this.context = tcontext;
            return this;
        }

        public Settings<TContext> withJavaConverters(boolean z) {
            this.javaSpecifics = z;
            return this;
        }

        @Deprecated
        public Settings<TContext> fallbackTo(Fallback<TContext> fallback) {
            this.fallback = fallback;
            return this;
        }

        public Settings<TContext> skipDefaultValues(boolean z) {
            this.omitDefaults = z;
            return this;
        }

        public Settings<TContext> allowArrayFormat(boolean z) {
            this.allowArrayFormat = z;
            return this;
        }

        public Settings<TContext> useKeyCache(StringCache stringCache) {
            this.keyCache = stringCache;
            return this;
        }

        public Settings<TContext> useStringValuesCache(StringCache stringCache) {
            this.valuesCache = stringCache;
            return this;
        }

        public Settings<TContext> resolveWriter(ConverterFactory<? extends JsonWriter.WriteObject> converterFactory) {
            if (converterFactory == null) {
                throw new IllegalArgumentException("writer can't be null");
            }
            if (this.writerFactories.contains(converterFactory)) {
                throw new IllegalArgumentException("writer already registered");
            }
            this.writerFactories.add(converterFactory);
            return this;
        }

        public Settings<TContext> resolveReader(ConverterFactory<? extends JsonReader.ReadObject> converterFactory) {
            if (converterFactory == null) {
                throw new IllegalArgumentException("reader can't be null");
            }
            if (this.readerFactories.contains(converterFactory)) {
                throw new IllegalArgumentException("reader already registered");
            }
            this.readerFactories.add(converterFactory);
            return this;
        }

        public Settings<TContext> resolveBinder(ConverterFactory<? extends JsonReader.BindObject> converterFactory) {
            if (converterFactory == null) {
                throw new IllegalArgumentException("binder can't be null");
            }
            if (this.binderFactories.contains(converterFactory)) {
                throw new IllegalArgumentException("binder already registered");
            }
            this.binderFactories.add(converterFactory);
            return this;
        }

        public Settings<TContext> includeServiceLoader() {
            return includeServiceLoader(Thread.currentThread().getContextClassLoader());
        }

        public Settings<TContext> includeServiceLoader(ClassLoader classLoader) {
            boolean z;
            if (classLoader == null) {
                throw new IllegalArgumentException("loader can't be null");
            }
            this.classLoaders.add(classLoader);
            for (Configuration configuration : ServiceLoader.load(Configuration.class, classLoader)) {
                Class<?> cls = configuration.getClass();
                Iterator<Configuration> it = this.configurations.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    if (it.next().getClass() == cls) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.fromServiceLoader++;
                    this.configurations.add(configuration);
                }
            }
            return this;
        }

        public Settings<TContext> errorInfo(JsonReader.ErrorInfo errorInfo) {
            if (errorInfo == null) {
                throw new IllegalArgumentException("errorInfo can't be null");
            }
            this.errorInfo = errorInfo;
            return this;
        }

        public Settings<TContext> doublePrecision(JsonReader.DoublePrecision doublePrecision) {
            if (doublePrecision == null) {
                throw new IllegalArgumentException("precision can't be null");
            }
            this.doublePrecision = doublePrecision;
            return this;
        }

        public Settings<TContext> unknownNumbers(JsonReader.UnknownNumberParsing unknownNumberParsing) {
            if (unknownNumberParsing == null) {
                throw new IllegalArgumentException("unknownNumbers can't be null");
            }
            this.unknownNumbers = unknownNumberParsing;
            return this;
        }

        public Settings<TContext> limitDigitsBuffer(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("size can't be smaller than 1");
            }
            this.maxNumberDigits = i;
            return this;
        }

        public Settings<TContext> limitStringBuffer(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("size can't be smaller than 1");
            }
            this.maxStringBuffer = i;
            return this;
        }

        public Settings<TContext> creatorMarker(Class<? extends Annotation> cls, boolean z) {
            if (cls == null) {
                throw new IllegalArgumentException("marker can't be null");
            }
            this.creatorMarkers.put(cls, Boolean.valueOf(z));
            return this;
        }

        public Settings<TContext> with(Configuration configuration) {
            if (configuration == null) {
                throw new IllegalArgumentException("conf can't be null");
            }
            this.configurations.add(configuration);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Settings<TContext> with(Iterable<Configuration> iterable) {
            if (iterable != null) {
                Iterator<Configuration> it = iterable.iterator();
                while (it.hasNext()) {
                    this.configurations.add(it.next());
                }
            }
            return this;
        }
    }

    public DslJson() {
        this(new Settings().includeServiceLoader());
    }

    @Deprecated
    public DslJson(TContext tcontext, boolean z, Fallback<TContext> fallback, boolean z2, StringCache stringCache, Iterable<Configuration> iterable) {
        this(new Settings().withContext(tcontext).withJavaConverters(z).fallbackTo(fallback).skipDefaultValues(z2).useKeyCache(stringCache).with(iterable));
    }

    public DslJson(Settings<TContext> settings) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.writerFactories = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.readerFactories = copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
        this.binderFactories = copyOnWriteArrayList3;
        this.defaults = new ConcurrentHashMap();
        this.objectReaders = new ConcurrentHashMap();
        this.readers = new ConcurrentHashMap();
        this.binders = new ConcurrentHashMap();
        this.writers = new ConcurrentHashMap();
        this.writerMap = new ConcurrentHashMap();
        this.OBJECT_WRITER = new JsonWriter.WriteObject<JsonObject>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.5
            @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
            public void write(JsonWriter jsonWriter, JsonObject jsonObject) {
                if (jsonObject == null) {
                    jsonWriter.writeNull();
                } else {
                    jsonObject.serialize(jsonWriter, DslJson.this.omitDefaults);
                }
            }
        };
        this.OBJECT_ARRAY_WRITER = new JsonWriter.WriteObject() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.7
            @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
            public void write(JsonWriter jsonWriter, Object obj) {
                DslJson.this.serialize(jsonWriter, (JsonObject[]) obj);
            }
        };
        this.NULL_WRITER = new JsonWriter.WriteObject() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.9
            @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
            public void write(JsonWriter jsonWriter, Object obj) {
                jsonWriter.writeNull();
            }
        };
        if (settings == null) {
            throw new IllegalArgumentException("settings can't be null");
        }
        this.localWriter = new ThreadLocal<JsonWriter>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public JsonWriter initialValue() {
                return new JsonWriter(4096, this);
            }
        };
        this.localReader = new ThreadLocal<JsonReader>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public JsonReader initialValue() {
                StringCache stringCache = this.keyCache;
                StringCache stringCache2 = this.valuesCache;
                DslJson dslJson = this;
                return new JsonReader(new byte[4096], 4096, this.context, new char[64], stringCache, stringCache2, dslJson, dslJson.errorInfo, this.doublePrecision, this.unknownNumbers, this.maxNumberDigits, this.maxStringSize);
            }
        };
        this.context = (TContext) ((Settings) settings).context;
        this.fallback = ((Settings) settings).fallback;
        this.omitDefaults = ((Settings) settings).omitDefaults;
        this.allowArrayFormat = ((Settings) settings).allowArrayFormat;
        this.keyCache = ((Settings) settings).keyCache;
        this.valuesCache = ((Settings) settings).valuesCache;
        this.unknownNumbers = ((Settings) settings).unknownNumbers;
        this.errorInfo = ((Settings) settings).errorInfo;
        this.doublePrecision = ((Settings) settings).doublePrecision;
        this.maxNumberDigits = ((Settings) settings).maxNumberDigits;
        this.maxStringSize = ((Settings) settings).maxStringBuffer;
        copyOnWriteArrayList.addAll(((Settings) settings).writerFactories);
        this.settingsWriters = ((Settings) settings).writerFactories.size();
        copyOnWriteArrayList2.addAll(((Settings) settings).readerFactories);
        this.settingsReaders = ((Settings) settings).readerFactories.size();
        copyOnWriteArrayList3.addAll(((Settings) settings).binderFactories);
        this.settingsBinders = ((Settings) settings).binderFactories.size();
        this.externalConverterAnalyzer = new ExternalConverterAnalyzer(((Settings) settings).classLoaders);
        this.creatorMarkers = new HashMap(((Settings) settings).creatorMarkers);
        registerReader(byte[].class, BinaryConverter.Base64Reader);
        registerWriter(byte[].class, BinaryConverter.Base64Writer);
        registerReader((Class) Boolean.TYPE, BoolConverter.READER);
        registerWriter((Class) Boolean.TYPE, BoolConverter.WRITER);
        registerDefault(Boolean.TYPE, false);
        registerReader(boolean[].class, BoolConverter.ARRAY_READER);
        registerWriter(boolean[].class, BoolConverter.ARRAY_WRITER);
        registerReader(Boolean.class, BoolConverter.NULLABLE_READER);
        registerWriter(Boolean.class, BoolConverter.WRITER);
        if (((Settings) settings).javaSpecifics) {
            registerJavaSpecifics(this);
        }
        registerReader(LinkedHashMap.class, ObjectConverter.MapReader);
        registerReader(HashMap.class, ObjectConverter.MapReader);
        registerReader(Map.class, ObjectConverter.MapReader);
        registerWriter(Map.class, new JsonWriter.WriteObject<Map>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.3
            @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
            public void write(JsonWriter jsonWriter, Map map) {
                if (map == null) {
                    jsonWriter.writeNull();
                    return;
                }
                try {
                    DslJson.this.serializeMap(map, jsonWriter);
                } catch (IOException e) {
                    throw new SerializationException(e);
                }
            }
        });
        registerReader(URI.class, NetConverter.UriReader);
        registerWriter(URI.class, NetConverter.UriWriter);
        registerReader(InetAddress.class, NetConverter.AddressReader);
        registerWriter(InetAddress.class, NetConverter.AddressWriter);
        registerReader((Class) Double.TYPE, NumberConverter.DOUBLE_READER);
        registerWriter((Class) Double.TYPE, NumberConverter.DOUBLE_WRITER);
        registerDefault(Double.TYPE, Double.valueOf(0.0d));
        registerReader(double[].class, NumberConverter.DOUBLE_ARRAY_READER);
        registerWriter(double[].class, NumberConverter.DOUBLE_ARRAY_WRITER);
        registerReader(Double.class, NumberConverter.NULLABLE_DOUBLE_READER);
        registerWriter(Double.class, NumberConverter.DOUBLE_WRITER);
        registerReader((Class) Float.TYPE, NumberConverter.FLOAT_READER);
        registerWriter((Class) Float.TYPE, NumberConverter.FLOAT_WRITER);
        registerDefault(Float.TYPE, Float.valueOf(0.0f));
        registerReader(float[].class, NumberConverter.FLOAT_ARRAY_READER);
        registerWriter(float[].class, NumberConverter.FLOAT_ARRAY_WRITER);
        registerReader(Float.class, NumberConverter.NULLABLE_FLOAT_READER);
        registerWriter(Float.class, NumberConverter.FLOAT_WRITER);
        registerReader((Class) Integer.TYPE, NumberConverter.INT_READER);
        registerWriter((Class) Integer.TYPE, NumberConverter.INT_WRITER);
        registerDefault(Integer.TYPE, 0);
        registerReader(int[].class, NumberConverter.INT_ARRAY_READER);
        registerWriter(int[].class, NumberConverter.INT_ARRAY_WRITER);
        registerReader(Integer.class, NumberConverter.NULLABLE_INT_READER);
        registerWriter(Integer.class, NumberConverter.INT_WRITER);
        registerReader((Class) Short.TYPE, NumberConverter.SHORT_READER);
        registerWriter((Class) Short.TYPE, NumberConverter.SHORT_WRITER);
        registerDefault(Short.TYPE, (short) 0);
        registerReader(short[].class, NumberConverter.SHORT_ARRAY_READER);
        registerWriter(short[].class, NumberConverter.SHORT_ARRAY_WRITER);
        registerReader(Short.class, NumberConverter.NULLABLE_SHORT_READER);
        registerWriter(Short.class, NumberConverter.SHORT_WRITER);
        registerReader((Class) Long.TYPE, NumberConverter.LONG_READER);
        registerWriter((Class) Long.TYPE, NumberConverter.LONG_WRITER);
        registerDefault(Long.TYPE, 0L);
        registerReader(long[].class, NumberConverter.LONG_ARRAY_READER);
        registerWriter(long[].class, NumberConverter.LONG_ARRAY_WRITER);
        registerReader(Long.class, NumberConverter.NULLABLE_LONG_READER);
        registerWriter(Long.class, NumberConverter.LONG_WRITER);
        registerReader(BigDecimal.class, NumberConverter.DecimalReader);
        registerWriter(BigDecimal.class, NumberConverter.DecimalWriter);
        registerReader(String.class, StringConverter.READER);
        registerWriter(String.class, StringConverter.WRITER);
        registerReader(UUID.class, UUIDConverter.READER);
        registerWriter(UUID.class, UUIDConverter.WRITER);
        registerReader(Number.class, NumberConverter.NumberReader);
        registerWriter(CharSequence.class, StringConverter.WRITER_CHARS);
        registerReader(StringBuilder.class, StringConverter.READER_BUILDER);
        registerReader(StringBuffer.class, StringConverter.READER_BUFFER);
        Iterator it = ((Settings) settings).configurations.iterator();
        while (it.hasNext()) {
            ((Configuration) it.next()).configure(this);
        }
        if (((Settings) settings).classLoaders.isEmpty() || ((Settings) settings).fromServiceLoader != 0) {
            return;
        }
        loadDefaultConverters(this, ((Settings) settings).classLoaders, "dsl_json_Annotation_Processor_External_Serialization");
        loadDefaultConverters(this, ((Settings) settings).classLoaders, "dsl_json.json.ExternalSerialization");
        loadDefaultConverters(this, ((Settings) settings).classLoaders, "dsl_json_ExternalSerialization");
    }

    public static class SimpleStringCache implements StringCache {
        private final String[] cache;
        private final int mask;

        public SimpleStringCache() {
            this(10);
        }

        public SimpleStringCache(int i) {
            int i2 = 2;
            for (int i3 = 1; i3 < i; i3++) {
                i2 *= 2;
            }
            this.mask = i2 - 1;
            this.cache = new String[i2];
        }

        @Override // com.bugsnag.android.repackaged.dslplatform.json.StringCache
        public String get(char[] cArr, int i) {
            long j = -2128831035;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j ^ ((long) ((byte) cArr[i2]))) * 16777619;
            }
            int i3 = this.mask & ((int) j);
            String str = this.cache[i3];
            if (str == null) {
                return createAndPut(i3, cArr, i);
            }
            if (str.length() != i) {
                return createAndPut(i3, cArr, i);
            }
            for (int i4 = 0; i4 < str.length(); i4++) {
                if (str.charAt(i4) != cArr[i4]) {
                    return createAndPut(i3, cArr, i);
                }
            }
            return str;
        }

        private String createAndPut(int i, char[] cArr, int i2) {
            String str = new String(cArr, 0, i2);
            this.cache[i] = str;
            return str;
        }
    }

    public JsonWriter newWriter() {
        return new JsonWriter(this);
    }

    public JsonWriter newWriter(int i) {
        return new JsonWriter(i, this);
    }

    public JsonWriter newWriter(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("null value provided for buffer");
        }
        return new JsonWriter(bArr, this);
    }

    public JsonReader<TContext> newReader() {
        return new JsonReader<>(new byte[4096], 4096, this.context, new char[64], this.keyCache, this.valuesCache, this, this.errorInfo, this.doublePrecision, this.unknownNumbers, this.maxNumberDigits, this.maxStringSize);
    }

    public JsonReader<TContext> newReader(byte[] bArr) {
        return new JsonReader<>(bArr, bArr.length, this.context, new char[64], this.keyCache, this.valuesCache, this, this.errorInfo, this.doublePrecision, this.unknownNumbers, this.maxNumberDigits, this.maxStringSize);
    }

    public JsonReader<TContext> newReader(byte[] bArr, int i) {
        return new JsonReader<>(bArr, i, this.context, new char[64], this.keyCache, this.valuesCache, this, this.errorInfo, this.doublePrecision, this.unknownNumbers, this.maxNumberDigits, this.maxStringSize);
    }

    public JsonReader<TContext> newReader(byte[] bArr, int i, char[] cArr) {
        return new JsonReader<>(bArr, i, this.context, cArr, this.keyCache, this.valuesCache, this, this.errorInfo, this.doublePrecision, this.unknownNumbers, this.maxNumberDigits, this.maxStringSize);
    }

    public JsonReader<TContext> newReader(InputStream inputStream, byte[] bArr) throws IOException {
        JsonReader<TContext> jsonReaderNewReader = newReader(bArr);
        jsonReaderNewReader.process(inputStream);
        return jsonReaderNewReader;
    }

    @Deprecated
    public JsonReader<TContext> newReader(String str) {
        byte[] bytes = str.getBytes(UTF8);
        return new JsonReader<>(bytes, bytes.length, this.context, new char[64], this.keyCache, this.valuesCache, this, this.errorInfo, this.doublePrecision, this.unknownNumbers, this.maxNumberDigits, this.maxStringSize);
    }

    private static void loadDefaultConverters(DslJson dslJson, Set<ClassLoader> set, String str) {
        Iterator<ClassLoader> it = set.iterator();
        while (it.hasNext()) {
            try {
                ((Configuration) it.next().loadClass(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).configure(dslJson);
            } catch (Exception | NoClassDefFoundError unused) {
            }
        }
    }

    static void registerJavaSpecifics(DslJson dslJson) {
        dslJson.registerReader(Element.class, (JsonReader.ReadObject) XmlConverter.Reader);
        dslJson.registerWriter(Element.class, (JsonWriter.WriteObject) XmlConverter.Writer);
    }

    public <T> void registerDefault(Class<T> cls, T t) {
        this.defaults.put(cls, t);
    }

    public boolean registerWriterFactory(ConverterFactory<? extends JsonWriter.WriteObject> converterFactory) {
        if (converterFactory == null) {
            throw new IllegalArgumentException("factory can't be null");
        }
        if (this.writerFactories.contains(converterFactory)) {
            return false;
        }
        List<ConverterFactory<JsonWriter.WriteObject>> list = this.writerFactories;
        list.add(list.size() - this.settingsWriters, converterFactory);
        return true;
    }

    public boolean registerReaderFactory(ConverterFactory<? extends JsonReader.ReadObject> converterFactory) {
        if (converterFactory == null) {
            throw new IllegalArgumentException("factory can't be null");
        }
        if (this.readerFactories.contains(converterFactory)) {
            return false;
        }
        List<ConverterFactory<JsonReader.ReadObject>> list = this.readerFactories;
        list.add(list.size() - this.settingsReaders, converterFactory);
        return true;
    }

    public boolean registerBinderFactory(ConverterFactory<? extends JsonReader.BindObject> converterFactory) {
        if (converterFactory == null) {
            throw new IllegalArgumentException("factory can't be null");
        }
        if (this.binderFactories.contains(converterFactory)) {
            return false;
        }
        List<ConverterFactory<JsonReader.BindObject>> list = this.binderFactories;
        list.add(list.size() - this.settingsBinders, converterFactory);
        return true;
    }

    public final Object getDefault(Type type) {
        Class cls;
        if (type == null) {
            return null;
        }
        Object obj = this.defaults.get(type);
        if (obj != null) {
            return obj;
        }
        if (type instanceof Class) {
            cls = (Class) type;
        } else {
            if (!(type instanceof ParameterizedType)) {
                return null;
            }
            cls = (Class) ((ParameterizedType) type).getRawType();
        }
        if (cls.isPrimitive()) {
            return Array.get(Array.newInstance((Class<?>) cls, 1), 0);
        }
        return this.defaults.get(cls);
    }

    public final Set<Type> getRegisteredDecoders() {
        return this.readers.keySet();
    }

    public final Set<Type> getRegisteredBinders() {
        return this.binders.keySet();
    }

    public final Set<Type> getRegisteredEncoders() {
        return this.writers.keySet();
    }

    public final Map<Class<? extends Annotation>, Boolean> getRegisteredCreatorMarkers() {
        return this.creatorMarkers;
    }

    public <T, S extends T> void registerReader(Class<T> cls, JsonReader.ReadObject<S> readObject) {
        if (readObject == null) {
            this.readers.remove(cls);
        } else {
            this.readers.put(cls, readObject);
        }
    }

    public JsonReader.ReadObject registerReader(Type type, JsonReader.ReadObject<?> readObject) {
        if (readObject == null) {
            return this.readers.remove(type);
        }
        try {
            return this.readers.get(type);
        } finally {
            this.readers.put(type, readObject);
        }
    }

    public <T, S extends T> void registerBinder(Class<T> cls, JsonReader.BindObject<S> bindObject) {
        if (bindObject == null) {
            this.binders.remove(cls);
        } else {
            this.binders.put(cls, bindObject);
        }
    }

    public void registerBinder(Type type, JsonReader.BindObject<?> bindObject) {
        if (bindObject == null) {
            this.binders.remove(type);
        } else {
            this.binders.put(type, bindObject);
        }
    }

    public <T> void registerWriter(Class<T> cls, JsonWriter.WriteObject<T> writeObject) {
        if (writeObject == null) {
            this.writerMap.remove(cls);
            this.writers.remove(cls);
        } else {
            this.writerMap.put(cls, cls);
            this.writers.put(cls, writeObject);
        }
    }

    public JsonWriter.WriteObject registerWriter(Type type, JsonWriter.WriteObject<?> writeObject) {
        if (writeObject == null) {
            return this.writers.remove(type);
        }
        try {
            return this.writers.get(type);
        } finally {
            this.writers.put(type, writeObject);
        }
    }

    public JsonWriter.WriteObject<?> tryFindWriter(Type type) {
        JsonWriter.WriteObject<?> writeObject;
        JsonWriter.WriteObject<?> writeObject2 = this.writers.get(type);
        if (writeObject2 != null) {
            return writeObject2;
        }
        Type typeExtractActualType = extractActualType(type);
        if (typeExtractActualType != type && (writeObject = this.writers.get(typeExtractActualType)) != null) {
            this.writers.putIfAbsent(type, writeObject);
            return writeObject;
        }
        boolean z = typeExtractActualType instanceof Class;
        if (z && JsonObject.class.isAssignableFrom((Class) typeExtractActualType)) {
            this.writers.putIfAbsent(type, this.OBJECT_WRITER);
            return this.OBJECT_WRITER;
        }
        JsonWriter.WriteObject<?> writeObject3 = (JsonWriter.WriteObject) lookupFromFactories(type, typeExtractActualType, this.writerFactories, this.writers);
        if (writeObject3 != null) {
            return writeObject3;
        }
        if (!z) {
            return null;
        }
        Class<?> cls = this.writerMap.get(typeExtractActualType);
        if (cls != null) {
            return this.writers.get(cls);
        }
        Class<?> cls2 = (Class) typeExtractActualType;
        ArrayList<Class<?>> arrayList = new ArrayList();
        findAllSignatures(cls2, arrayList);
        for (Class<?> cls3 : arrayList) {
            JsonWriter.WriteObject<?> writeObject4 = this.writers.get(cls3);
            if (writeObject4 == null) {
                writeObject4 = (JsonWriter.WriteObject) lookupFromFactories(type, cls3, this.writerFactories, this.writers);
            }
            if (writeObject4 != null) {
                this.writerMap.putIfAbsent(cls2, cls3);
                return writeObject4;
            }
        }
        return null;
    }

    private static Type extractActualType(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return (wildcardType.getUpperBounds().length == 1 && wildcardType.getLowerBounds().length == 0) ? wildcardType.getUpperBounds()[0] : type;
    }

    private <T> void checkExternal(Type type, ConcurrentMap<Type, T> concurrentMap) {
        Type typeExtractActualType;
        if (type instanceof Class) {
            this.externalConverterAnalyzer.tryFindConverter((Class) type, this);
            return;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            this.externalConverterAnalyzer.tryFindConverter((Class) parameterizedType.getRawType(), this);
            for (Type type2 : parameterizedType.getActualTypeArguments()) {
                if (!concurrentMap.containsKey(type2) && (typeExtractActualType = extractActualType(type2)) != type2 && !concurrentMap.containsKey(typeExtractActualType)) {
                    checkExternal(typeExtractActualType, concurrentMap);
                }
            }
        }
    }

    private <T> T lookupFromFactories(Type type, Type type2, List<ConverterFactory<T>> list, ConcurrentMap<Type, T> concurrentMap) {
        if (type2 instanceof Class) {
            this.externalConverterAnalyzer.tryFindConverter((Class) type2, this);
            T t = concurrentMap.get(type2);
            if (t != null) {
                return t;
            }
        } else if (type2 instanceof ParameterizedType) {
            checkExternal(type2, concurrentMap);
        }
        Iterator<ConverterFactory<T>> it = list.iterator();
        while (it.hasNext()) {
            T tTryCreate = it.next().tryCreate(type2, this);
            if (tTryCreate != null) {
                concurrentMap.putIfAbsent(type, tTryCreate);
                return tTryCreate;
            }
        }
        return null;
    }

    public JsonReader.ReadObject<?> tryFindReader(Type type) {
        JsonReader.ReadJsonObject<JsonObject> objectReader;
        JsonReader.ReadObject<?> readObject;
        JsonReader.ReadObject<?> readObject2 = this.readers.get(type);
        if (readObject2 != null) {
            return readObject2;
        }
        Type typeExtractActualType = extractActualType(type);
        if (typeExtractActualType != type && (readObject = this.readers.get(typeExtractActualType)) != null) {
            this.readers.putIfAbsent(type, readObject);
            return readObject;
        }
        if (typeExtractActualType instanceof Class) {
            Class<?> cls = (Class) typeExtractActualType;
            if (JsonObject.class.isAssignableFrom(cls) && (objectReader = getObjectReader(cls)) != null) {
                JsonReader.ReadObject readObjectConvertToReader = convertToReader(objectReader);
                this.readers.putIfAbsent(type, readObjectConvertToReader);
                return readObjectConvertToReader;
            }
        }
        return (JsonReader.ReadObject) lookupFromFactories(type, typeExtractActualType, this.readerFactories, this.readers);
    }

    public JsonReader.BindObject<?> tryFindBinder(Type type) {
        JsonReader.BindObject<?> bindObject;
        JsonReader.BindObject<?> bindObject2 = this.binders.get(type);
        if (bindObject2 != null) {
            return bindObject2;
        }
        Type typeExtractActualType = extractActualType(type);
        if (typeExtractActualType != type && (bindObject = this.binders.get(typeExtractActualType)) != null) {
            this.binders.putIfAbsent(type, bindObject);
            return bindObject;
        }
        return (JsonReader.BindObject) lookupFromFactories(type, typeExtractActualType, this.binderFactories, this.binders);
    }

    public <T> JsonWriter.WriteObject<T> tryFindWriter(Class<T> cls) {
        return (JsonWriter.WriteObject<T>) tryFindWriter((Type) cls);
    }

    @Override // com.bugsnag.android.repackaged.dslplatform.json.TypeLookup
    public <T> JsonReader.ReadObject<T> tryFindReader(Class<T> cls) {
        return (JsonReader.ReadObject<T>) tryFindReader((Type) cls);
    }

    @Override // com.bugsnag.android.repackaged.dslplatform.json.TypeLookup
    public <T> JsonReader.BindObject<T> tryFindBinder(Class<T> cls) {
        return (JsonReader.BindObject<T>) tryFindBinder((Type) cls);
    }

    private static void findAllSignatures(Class<?> cls, ArrayList<Class<?>> arrayList) {
        if (arrayList.contains(cls)) {
            return;
        }
        arrayList.add(cls);
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            findAllSignatures(superclass, arrayList);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            findAllSignatures(cls2, arrayList);
        }
    }

    private JsonReader.ReadJsonObject<JsonObject> probeForObjectReader(Class<?> cls, Object obj) {
        Object objInvoke;
        try {
            objInvoke = cls.getField("JSON_READER").get(obj);
        } catch (Exception unused) {
            try {
                try {
                    objInvoke = cls.getMethod("JSON_READER", new Class[0]).invoke(obj, new Object[0]);
                } catch (Exception unused2) {
                    return null;
                }
            } catch (Exception unused3) {
                objInvoke = cls.getMethod("getJSON_READER", new Class[0]).invoke(obj, new Object[0]);
            }
        }
        if (objInvoke instanceof JsonReader.ReadJsonObject) {
            return (JsonReader.ReadJsonObject) objInvoke;
        }
        return null;
    }

    protected final JsonReader.ReadJsonObject<JsonObject> getObjectReader(Class<?> cls) {
        try {
            JsonReader.ReadJsonObject<JsonObject> readJsonObjectProbeForObjectReader = this.objectReaders.get(cls);
            if (readJsonObjectProbeForObjectReader == null) {
                readJsonObjectProbeForObjectReader = probeForObjectReader(cls, null);
                if (readJsonObjectProbeForObjectReader == null) {
                    try {
                        Object obj = cls.getField("Companion").get(null);
                        readJsonObjectProbeForObjectReader = probeForObjectReader(obj.getClass(), obj);
                    } catch (Exception unused) {
                        return null;
                    }
                }
                if (readJsonObjectProbeForObjectReader != null) {
                    this.objectReaders.putIfAbsent(cls, readJsonObjectProbeForObjectReader);
                }
            }
            return readJsonObjectProbeForObjectReader;
        } catch (Exception unused2) {
            return null;
        }
    }

    public void serializeMap(Map<String, Object> map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeByte(JsonWriter.OBJECT_START);
        int size = map.size();
        if (size > 0) {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            Map.Entry<String, Object> next = it.next();
            jsonWriter.writeString(next.getKey());
            jsonWriter.writeByte(JsonWriter.SEMI);
            serialize(jsonWriter, next.getValue());
            for (int i = 1; i < size; i++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                Map.Entry<String, Object> next2 = it.next();
                jsonWriter.writeString(next2.getKey());
                jsonWriter.writeByte(JsonWriter.SEMI);
                serialize(jsonWriter, next2.getValue());
            }
        }
        jsonWriter.writeByte(JsonWriter.OBJECT_END);
    }

    @Deprecated
    public static Object deserializeObject(JsonReader jsonReader) throws IOException {
        return ObjectConverter.deserializeObject(jsonReader);
    }

    @Deprecated
    public static ArrayList<Object> deserializeList(JsonReader jsonReader) throws IOException {
        return ObjectConverter.deserializeList(jsonReader);
    }

    @Deprecated
    public static LinkedHashMap<String, Object> deserializeMap(JsonReader jsonReader) throws IOException {
        return ObjectConverter.deserializeMap(jsonReader);
    }

    private static Object convertResultToArray(Class<?> cls, List<?> list) {
        int i = 0;
        if (cls.isPrimitive()) {
            if (Boolean.TYPE.equals(cls)) {
                boolean[] zArr = new boolean[list.size()];
                while (i < list.size()) {
                    zArr[i] = ((Boolean) list.get(i)).booleanValue();
                    i++;
                }
                return zArr;
            }
            if (Integer.TYPE.equals(cls)) {
                int[] iArr = new int[list.size()];
                while (i < list.size()) {
                    iArr[i] = ((Integer) list.get(i)).intValue();
                    i++;
                }
                return iArr;
            }
            if (Long.TYPE.equals(cls)) {
                long[] jArr = new long[list.size()];
                while (i < list.size()) {
                    jArr[i] = ((Long) list.get(i)).longValue();
                    i++;
                }
                return jArr;
            }
            if (Short.TYPE.equals(cls)) {
                short[] sArr = new short[list.size()];
                while (i < list.size()) {
                    sArr[i] = ((Short) list.get(i)).shortValue();
                    i++;
                }
                return sArr;
            }
            if (Byte.TYPE.equals(cls)) {
                byte[] bArr = new byte[list.size()];
                while (i < list.size()) {
                    bArr[i] = ((Byte) list.get(i)).byteValue();
                    i++;
                }
                return bArr;
            }
            if (Float.TYPE.equals(cls)) {
                float[] fArr = new float[list.size()];
                while (i < list.size()) {
                    fArr[i] = ((Float) list.get(i)).floatValue();
                    i++;
                }
                return fArr;
            }
            if (Double.TYPE.equals(cls)) {
                double[] dArr = new double[list.size()];
                while (i < list.size()) {
                    dArr[i] = ((Double) list.get(i)).doubleValue();
                    i++;
                }
                return dArr;
            }
            if (Character.TYPE.equals(cls)) {
                char[] cArr = new char[list.size()];
                while (i < list.size()) {
                    cArr[i] = ((Character) list.get(i)).charValue();
                    i++;
                }
                return cArr;
            }
        }
        return list.toArray((Object[]) Array.newInstance(cls, 0));
    }

    public final boolean canSerialize(Type type) {
        if (this.writers.get(type) != null) {
            return true;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (JsonObject.class.isAssignableFrom(cls) || JsonObject[].class.isAssignableFrom(cls) || tryFindWriter(type) != null) {
                return true;
            }
            if (cls.isArray()) {
                return (cls.getComponentType().isArray() || Collection.class.isAssignableFrom(cls.getComponentType()) || !canSerialize(cls.getComponentType())) ? false : true;
            }
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getActualTypeArguments().length == 1) {
                Class cls2 = (Class) parameterizedType.getRawType();
                if (cls2.isArray() || Collection.class.isAssignableFrom(cls2)) {
                    Type type2 = parameterizedType.getActualTypeArguments()[0];
                    return ((type2 instanceof Class) && JsonObject.class.isAssignableFrom((Class) type2)) || tryFindWriter(type2) != null;
                }
            }
        } else if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type;
            return ((genericArrayType.getGenericComponentType() instanceof Class) && JsonObject.class.isAssignableFrom((Class) genericArrayType.getGenericComponentType())) || tryFindWriter(genericArrayType.getGenericComponentType()) != null;
        }
        Iterator<ConverterFactory<JsonWriter.WriteObject>> it = this.writerFactories.iterator();
        while (it.hasNext()) {
            if (it.next().tryCreate(type, this) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean canDeserialize(Type type) {
        if (tryFindReader(type) != null) {
            return true;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return (cls.getComponentType().isArray() || Collection.class.isAssignableFrom(cls.getComponentType()) || !canDeserialize(cls.getComponentType())) ? false : true;
            }
        }
        if (!(type instanceof ParameterizedType)) {
            return (type instanceof GenericArrayType) && tryFindReader(((GenericArrayType) type).getGenericComponentType()) != null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getActualTypeArguments().length == 1) {
            Class cls2 = (Class) parameterizedType.getRawType();
            if ((cls2.isArray() || Collection.class.isAssignableFrom(cls2)) && tryFindReader(parameterizedType.getActualTypeArguments()[0]) != null) {
                return true;
            }
        }
        return false;
    }

    public <T> T deserialize(JsonReader.ReadObject<T> readObject, JsonReader<TContext> jsonReader) throws IOException {
        if (readObject == null) {
            throw new IllegalArgumentException("converter can't be null");
        }
        if (jsonReader == null) {
            throw new IllegalArgumentException("input can't be null");
        }
        jsonReader.getNextToken();
        return readObject.read(jsonReader);
    }

    public <TResult> TResult deserialize(Class<TResult> cls, byte[] bArr, int i) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("body can't be null");
        }
        JsonReader<TContext> jsonReaderProcess = this.localReader.get().process(bArr, i);
        try {
            jsonReaderProcess.getNextToken();
            JsonReader.ReadObject<T> readObjectTryFindReader = tryFindReader((Class) cls);
            if (readObjectTryFindReader != 0) {
                TResult tresult = (TResult) readObjectTryFindReader.read(jsonReaderProcess);
                jsonReaderProcess.reset();
                return tresult;
            }
            if (!cls.isArray()) {
                Fallback<TContext> fallback = this.fallback;
                if (fallback == null) {
                    throw createErrorMessage(cls);
                }
                TResult tresult2 = (TResult) fallback.deserialize(this.context, cls, bArr, i);
                jsonReaderProcess.reset();
                return tresult2;
            }
            if (jsonReaderProcess.wasNull()) {
                jsonReaderProcess.reset();
                return null;
            }
            if (jsonReaderProcess.last() != 91) {
                throw jsonReaderProcess.newParseError("Expecting '[' for array start");
            }
            Class componentType = cls.getComponentType();
            List<TResult> listDeserializeList = deserializeList(componentType, bArr, i);
            if (listDeserializeList == null) {
                jsonReaderProcess.reset();
                return null;
            }
            TResult tresult3 = (TResult) convertResultToArray(componentType, listDeserializeList);
            jsonReaderProcess.reset();
            return tresult3;
        } catch (Throwable th) {
            jsonReaderProcess.reset();
            throw th;
        }
    }

    public Object deserialize(Type type, byte[] bArr, int i) throws IOException {
        if (type instanceof Class) {
            return deserialize((Class) type, bArr, i);
        }
        if (type == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("body can't be null");
        }
        JsonReader<TContext> jsonReaderProcess = this.localReader.get().process(bArr, i);
        try {
            jsonReaderProcess.getNextToken();
            Object objDeserializeWith = deserializeWith(type, jsonReaderProcess);
            if (objDeserializeWith == unknownValue) {
                Fallback<TContext> fallback = this.fallback;
                if (fallback != null) {
                    Object objDeserialize = fallback.deserialize(this.context, type, bArr, i);
                    jsonReaderProcess.reset();
                    return objDeserialize;
                }
                throw new ConfigurationException("Unable to find reader for provided type: " + type + " and fallback serialization is not registered.\nTry initializing DslJson with custom fallback in case of unsupported objects or register specified type using registerReader into " + getClass());
            }
            jsonReaderProcess.reset();
            return objDeserializeWith;
        } catch (Throwable th) {
            jsonReaderProcess.reset();
            throw th;
        }
    }

    protected Object deserializeWith(Type type, JsonReader jsonReader) throws IOException {
        JsonReader.ReadObject<?> readObjectTryFindReader = tryFindReader(type);
        if (readObjectTryFindReader != null) {
            return readObjectTryFindReader.read(jsonReader);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getActualTypeArguments().length == 1) {
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Class cls = (Class) parameterizedType.getRawType();
                if (cls.isArray() || Collection.class.isAssignableFrom(cls)) {
                    if (jsonReader.wasNull()) {
                        return null;
                    }
                    if (jsonReader.last() != 91) {
                        throw jsonReader.newParseError("Expecting '[' for array start");
                    }
                    if (jsonReader.getNextToken() == 93) {
                        if (cls.isArray()) {
                            returnEmptyArray(type2);
                        }
                        return new ArrayList(0);
                    }
                    JsonReader.ReadObject<?> readObjectTryFindReader2 = tryFindReader(type2);
                    if (readObjectTryFindReader2 != null) {
                        ArrayList arrayListDeserializeNullableCollectionCustom = jsonReader.deserializeNullableCollectionCustom(readObjectTryFindReader2);
                        return cls.isArray() ? returnAsArray(type2, arrayListDeserializeNullableCollectionCustom) : arrayListDeserializeNullableCollectionCustom;
                    }
                }
            }
        } else if (type instanceof GenericArrayType) {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for array start");
            }
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (jsonReader.getNextToken() == 93) {
                return returnEmptyArray(genericComponentType);
            }
            JsonReader.ReadObject<?> readObjectTryFindReader3 = tryFindReader(genericComponentType);
            if (readObjectTryFindReader3 != null) {
                return returnAsArray(genericComponentType, jsonReader.deserializeNullableCollectionCustom(readObjectTryFindReader3));
            }
        }
        return unknownValue;
    }

    private static Object returnAsArray(Type type, ArrayList<?> arrayList) {
        if (type instanceof Class) {
            return convertResultToArray((Class) type, arrayList);
        }
        if (type instanceof ParameterizedType) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) ((ParameterizedType) type).getRawType(), 0));
        }
        return arrayList.toArray();
    }

    private static Object returnEmptyArray(Type type) {
        if (type instanceof Class) {
            return Array.newInstance((Class<?>) type, 0);
        }
        return type instanceof ParameterizedType ? Array.newInstance((Class<?>) ((ParameterizedType) type).getRawType(), 0) : new Object[0];
    }

    protected IOException createErrorMessage(Class<?> cls) {
        ArrayList<Class> arrayList = new ArrayList();
        findAllSignatures(cls, arrayList);
        for (Class cls2 : arrayList) {
            if (this.readers.containsKey(cls2)) {
                if (cls2.equals(cls)) {
                    return new IOException("Reader for provided type: " + cls + " is disabled and fallback serialization is not registered (converter is registered as null).\nTry initializing system with custom fallback or don't register null for " + cls);
                }
                return new IOException("Unable to find reader for provided type: " + cls + " and fallback serialization is not registered.\nFound reader for: " + cls2 + " so try deserializing into that instead?\nAlternatively, try initializing system with custom fallback or register specified type using registerReader into " + getClass());
            }
        }
        return new IOException("Unable to find reader for provided type: " + cls + " and fallback serialization is not registered.\nTry initializing DslJson with custom fallback in case of unsupported objects or register specified type using registerReader into " + getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TResult> List<TResult> deserializeList(Class<TResult> cls, byte[] bArr, int i) throws IOException {
        JsonReader.ReadJsonObject<JsonObject> objectReader;
        if (cls == 0) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("body can't be null");
        }
        if (i == 4 && bArr[0] == 110 && bArr[1] == 117 && bArr[2] == 108 && bArr[3] == 108) {
            return null;
        }
        if (i == 2 && bArr[0] == 91 && bArr[1] == 93) {
            return new ArrayList(0);
        }
        JsonReader<TContext> jsonReaderProcess = this.localReader.get().process(bArr, i);
        try {
            if (jsonReaderProcess.getNextToken() != 91) {
                if (!jsonReaderProcess.wasNull()) {
                    throw jsonReaderProcess.newParseError("Expecting '[' for list start");
                }
                jsonReaderProcess.reset();
                return null;
            }
            if (jsonReaderProcess.getNextToken() == 93) {
                ArrayList arrayList = new ArrayList(0);
                jsonReaderProcess.reset();
                return arrayList;
            }
            if (JsonObject.class.isAssignableFrom(cls) && (objectReader = getObjectReader(cls)) != null) {
                List<TResult> listDeserializeNullableCollection = jsonReaderProcess.deserializeNullableCollection(objectReader);
                jsonReaderProcess.reset();
                return listDeserializeNullableCollection;
            }
            JsonReader.ReadObject readObjectTryFindReader = tryFindReader((Class) cls);
            if (readObjectTryFindReader != null) {
                List<TResult> listDeserializeNullableCollectionCustom = jsonReaderProcess.deserializeNullableCollectionCustom(readObjectTryFindReader);
                jsonReaderProcess.reset();
                return listDeserializeNullableCollectionCustom;
            }
            if (this.fallback == null) {
                throw createErrorMessage(cls);
            }
            Object[] objArr = (Object[]) this.fallback.deserialize(this.context, Array.newInstance((Class<?>) cls, 0).getClass(), bArr, i);
            if (objArr == null) {
                jsonReaderProcess.reset();
                return null;
            }
            ArrayList arrayList2 = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList2.add(obj);
            }
            jsonReaderProcess.reset();
            return arrayList2;
        } catch (Throwable th) {
            jsonReaderProcess.reset();
            throw th;
        }
    }

    public <TResult> List<TResult> deserializeList(Class<TResult> cls, InputStream inputStream, byte[] bArr) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("buffer can't be null");
        }
        return deserializeList(cls, newReader(inputStream, bArr), inputStream);
    }

    public <TResult> List<TResult> deserializeList(Class<TResult> cls, InputStream inputStream) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        JsonReader<TContext> jsonReaderProcess = this.localReader.get().process(inputStream);
        try {
            return deserializeList(cls, jsonReaderProcess, inputStream);
        } finally {
            jsonReaderProcess.reset();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <TResult> List<TResult> deserializeList(Class<TResult> cls, JsonReader<TContext> jsonReader, InputStream inputStream) throws IOException {
        JsonReader.ReadJsonObject objectReader;
        if (jsonReader.getNextToken() != 91) {
            if (jsonReader.wasNull()) {
                return null;
            }
            throw jsonReader.newParseError("Expecting '[' for list start");
        }
        if (jsonReader.getNextToken() == 93) {
            return new ArrayList(0);
        }
        if (JsonObject.class.isAssignableFrom(cls) && (objectReader = getObjectReader(cls)) != null) {
            return jsonReader.deserializeNullableCollection(objectReader);
        }
        JsonReader.ReadObject readObjectTryFindReader = tryFindReader((Class) cls);
        if (readObjectTryFindReader != null) {
            return jsonReader.deserializeNullableCollectionCustom(readObjectTryFindReader);
        }
        if (this.fallback != null) {
            Object[] objArr = (Object[]) this.fallback.deserialize(this.context, Array.newInstance((Class<?>) cls, 0).getClass(), new RereadStream(jsonReader.buffer, inputStream));
            if (objArr == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        throw createErrorMessage(cls);
    }

    public <TResult> TResult deserialize(Class<TResult> cls, InputStream inputStream, byte[] bArr) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("buffer can't be null");
        }
        return (TResult) deserialize(cls, newReader(inputStream, bArr), inputStream);
    }

    public <TResult> TResult deserialize(Class<TResult> cls, InputStream inputStream) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        JsonReader<TContext> jsonReaderProcess = this.localReader.get().process(inputStream);
        try {
            return (TResult) deserialize(cls, jsonReaderProcess, inputStream);
        } finally {
            jsonReaderProcess.reset();
        }
    }

    protected <TResult> TResult deserialize(Class<TResult> cls, JsonReader jsonReader, InputStream inputStream) throws IOException {
        JsonReader.ReadJsonObject<JsonObject> objectReader;
        jsonReader.getNextToken();
        JsonReader.ReadObject<T> readObjectTryFindReader = tryFindReader((Class) cls);
        if (readObjectTryFindReader != 0) {
            return (TResult) readObjectTryFindReader.read(jsonReader);
        }
        if (cls.isArray()) {
            if (jsonReader.wasNull()) {
                return null;
            }
            if (jsonReader.last() != 91) {
                throw jsonReader.newParseError("Expecting '[' for array start");
            }
            Class componentType = cls.getComponentType();
            if (jsonReader.getNextToken() == 93) {
                return (TResult) Array.newInstance((Class<?>) componentType, 0);
            }
            if (JsonObject.class.isAssignableFrom(componentType) && (objectReader = getObjectReader(componentType)) != null) {
                return (TResult) convertResultToArray(componentType, jsonReader.deserializeNullableCollection(objectReader));
            }
            Object objTryFindReader = tryFindReader(componentType);
            if (objTryFindReader != null) {
                return (TResult) convertResultToArray(componentType, jsonReader.deserializeNullableCollectionCustom(objTryFindReader));
            }
        }
        Fallback<TContext> fallback = this.fallback;
        if (fallback != null) {
            return (TResult) fallback.deserialize(this.context, cls, new RereadStream(jsonReader.buffer, inputStream));
        }
        throw createErrorMessage(cls);
    }

    public Object deserialize(Type type, InputStream inputStream, byte[] bArr) throws IOException {
        if (type instanceof Class) {
            return deserialize((Class) type, inputStream, bArr);
        }
        if (type == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("buffer can't be null");
        }
        JsonReader<TContext> jsonReaderNewReader = newReader(inputStream, bArr);
        jsonReaderNewReader.getNextToken();
        Object objDeserializeWith = deserializeWith(type, jsonReaderNewReader);
        if (objDeserializeWith != unknownValue) {
            return objDeserializeWith;
        }
        Fallback<TContext> fallback = this.fallback;
        if (fallback != null) {
            return fallback.deserialize(this.context, type, new RereadStream(bArr, inputStream));
        }
        throw new ConfigurationException("Unable to find reader for provided type: " + type + " and fallback serialization is not registered.\nTry initializing DslJson with custom fallback in case of unsupported objects or register specified type using registerReader into " + getClass());
    }

    public Object deserialize(Type type, InputStream inputStream) throws IOException {
        if (type instanceof Class) {
            return deserialize((Class) type, inputStream);
        }
        if (type == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        JsonReader<TContext> jsonReaderProcess = this.localReader.get().process(inputStream);
        try {
            jsonReaderProcess.getNextToken();
            Object objDeserializeWith = deserializeWith(type, jsonReaderProcess);
            if (objDeserializeWith == unknownValue) {
                Fallback<TContext> fallback = this.fallback;
                if (fallback != null) {
                    Object objDeserialize = fallback.deserialize(this.context, type, new RereadStream(jsonReaderProcess.buffer, inputStream));
                    jsonReaderProcess.reset();
                    return objDeserialize;
                }
                throw new ConfigurationException("Unable to find reader for provided type: " + type + " and fallback serialization is not registered.\nTry initializing DslJson with custom fallback in case of unsupported objects or register specified type using registerReader into " + getClass());
            }
            jsonReaderProcess.reset();
            return objDeserializeWith;
        } catch (Throwable th) {
            jsonReaderProcess.reset();
            throw th;
        }
    }

    static class RereadStream extends InputStream {
        private final byte[] buffer;
        private int position;
        private final InputStream stream;
        private boolean usingBuffer = true;

        RereadStream(byte[] bArr, InputStream inputStream) {
            this.buffer = bArr;
            this.stream = inputStream;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.usingBuffer) {
                int i = this.position;
                byte[] bArr = this.buffer;
                if (i < bArr.length) {
                    this.position = i + 1;
                    return bArr[i];
                }
                this.usingBuffer = false;
            }
            return this.stream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            if (this.usingBuffer) {
                return super.read(bArr);
            }
            return this.stream.read(bArr);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.usingBuffer) {
                return super.read(bArr, i, i2);
            }
            return this.stream.read(bArr, i, i2);
        }
    }

    public <TResult> Iterator<TResult> iterateOver(Class<TResult> cls, InputStream inputStream) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        JsonReader jsonReader = this.localReader.get();
        jsonReader.process(inputStream);
        return iterateOver(cls, jsonReader, inputStream);
    }

    public <TResult> Iterator<TResult> iterateOver(Class<TResult> cls, InputStream inputStream, byte[] bArr) throws IOException {
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("buffer can't be null");
        }
        return iterateOver(cls, newReader(inputStream, bArr), inputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <TResult> Iterator<TResult> iterateOver(Class<TResult> cls, JsonReader jsonReader, InputStream inputStream) throws IOException {
        JsonReader.ReadJsonObject<JsonObject> objectReader;
        if (jsonReader.getNextToken() != 91) {
            if (jsonReader.wasNull()) {
                return null;
            }
            throw jsonReader.newParseError("Expecting '[' for iterator start");
        }
        if (jsonReader.getNextToken() == 93) {
            return EMPTY_ITERATOR;
        }
        if (JsonObject.class.isAssignableFrom(cls) && (objectReader = getObjectReader(cls)) != null) {
            return jsonReader.iterateOver(objectReader);
        }
        Object objTryFindReader = tryFindReader((Class) cls);
        if (objTryFindReader != null) {
            return jsonReader.iterateOverCustom(objTryFindReader);
        }
        if (this.fallback != null) {
            Object[] objArr = (Object[]) this.fallback.deserialize(this.context, Array.newInstance((Class<?>) cls, 0).getClass(), new RereadStream(jsonReader.buffer, inputStream));
            if (objArr == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj);
            }
            return arrayList.iterator();
        }
        throw createErrorMessage(cls);
    }

    private <T extends JsonObject> JsonReader.ReadObject<T> convertToReader(final JsonReader.ReadJsonObject<T> readJsonObject) {
        return (JsonReader.ReadObject<T>) new JsonReader.ReadObject<T>() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.6
            /* JADX WARN: Incorrect return type in method signature: (Lcom/bugsnag/android/repackaged/dslplatform/json/JsonReader;)TT; */
            @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonReader.ReadObject
            public JsonObject read(JsonReader jsonReader) throws IOException {
                if (jsonReader.wasNull()) {
                    return null;
                }
                if (jsonReader.last() != 123) {
                    throw jsonReader.newParseError("Expecting '{' for object start");
                }
                jsonReader.getNextToken();
                return readJsonObject.deserialize(jsonReader);
            }
        };
    }

    private JsonWriter.WriteObject getOrCreateWriter(Object obj, Class<?> cls) throws IOException {
        Class cls2;
        Class cls3;
        if (obj instanceof JsonObject) {
            return this.OBJECT_WRITER;
        }
        if (obj instanceof JsonObject[]) {
            return this.OBJECT_ARRAY_WRITER;
        }
        if (cls != null) {
            cls3 = cls;
        } else {
            cls2 = obj.getClass();
        }
        if (cls != null) {
            cls3 = cls2;
            if (JsonObject.class.isAssignableFrom(cls3)) {
                return this.OBJECT_WRITER;
            }
        }
        cls3 = cls2;
        JsonWriter.WriteObject<T> writeObjectTryFindWriter = tryFindWriter(cls3);
        if (writeObjectTryFindWriter != 0) {
            return writeObjectTryFindWriter;
        }
        if (cls3.isArray()) {
            Class componentType = cls3.getComponentType();
            if (Character.TYPE == componentType) {
                return CHAR_ARRAY_WRITER;
            }
            final JsonWriter.WriteObject<T> writeObjectTryFindWriter2 = tryFindWriter(componentType);
            if (writeObjectTryFindWriter2 != 0) {
                return new JsonWriter.WriteObject() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.10
                    @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
                    public void write(JsonWriter jsonWriter, Object obj2) {
                        jsonWriter.serialize((Object[]) obj2, writeObjectTryFindWriter2);
                    }
                };
            }
        }
        if ((obj instanceof Collection) || Collection.class.isAssignableFrom(cls3)) {
            return new JsonWriter.WriteObject() { // from class: com.bugsnag.android.repackaged.dslplatform.json.DslJson.11
                @Override // com.bugsnag.android.repackaged.dslplatform.json.JsonWriter.WriteObject
                public void write(JsonWriter jsonWriter, Object obj2) {
                    Class<?> cls4;
                    Collection collection = (Collection) obj2;
                    Iterator it = collection.iterator();
                    Class<?> cls5 = null;
                    do {
                        Object next = it.next();
                        if (next != null && (cls4 = next.getClass()) != cls5 && (cls5 == null || cls4.isAssignableFrom(cls5))) {
                            cls5 = cls4;
                        }
                    } while (it.hasNext());
                    if (cls5 == null) {
                        jsonWriter.writeByte(JsonWriter.ARRAY_START);
                        jsonWriter.writeNull();
                        for (int i = 1; i < collection.size(); i++) {
                            jsonWriter.writeAscii(",null");
                        }
                        jsonWriter.writeByte(JsonWriter.ARRAY_END);
                        return;
                    }
                    if (JsonObject.class.isAssignableFrom(cls5)) {
                        DslJson.this.serialize(jsonWriter, collection);
                        return;
                    }
                    JsonWriter.WriteObject writeObjectTryFindWriter3 = DslJson.this.tryFindWriter((Class) cls5);
                    if (writeObjectTryFindWriter3 != null) {
                        jsonWriter.serialize(collection, writeObjectTryFindWriter3);
                        return;
                    }
                    if (DslJson.this.fallback != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.reset();
                        try {
                            DslJson.this.fallback.serialize(obj2, byteArrayOutputStream);
                            jsonWriter.writeAscii(byteArrayOutputStream.toByteArray());
                            return;
                        } catch (IOException e) {
                            throw new SerializationException(e);
                        }
                    }
                    throw new ConfigurationException("Unable to serialize provided object. Failed to find serializer for: " + collection.getClass());
                }
            };
        }
        throw new ConfigurationException("Unable to serialize provided object. Failed to find serializer for: " + cls3);
    }

    public <T> void iterateOver(Iterator<T> it, OutputStream outputStream, JsonWriter jsonWriter) throws IOException {
        Class<?> cls;
        JsonWriter.WriteObject orCreateWriter;
        if (it == null) {
            throw new IllegalArgumentException("iterator can't be null");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        outputStream.write(91);
        if (!it.hasNext()) {
            outputStream.write(93);
            return;
        }
        if (jsonWriter == null) {
            jsonWriter = new JsonWriter(this);
        }
        T next = it.next();
        if (next != null) {
            cls = next.getClass();
            orCreateWriter = getOrCreateWriter(next, cls);
            jsonWriter.reset();
            try {
                orCreateWriter.write(jsonWriter, next);
                jsonWriter.toStream(outputStream);
            } catch (ConfigurationException e) {
                throw e;
            } catch (Exception e2) {
                throw new IOException(e2);
            }
        } else {
            outputStream.write(NULL);
            cls = null;
            orCreateWriter = null;
        }
        while (it.hasNext()) {
            outputStream.write(44);
            T next2 = it.next();
            if (next2 != null) {
                Class<?> cls2 = next2.getClass();
                if (orCreateWriter == null || cls == null || !cls.equals(cls2)) {
                    orCreateWriter = getOrCreateWriter(next2, cls2);
                    cls = cls2;
                }
                jsonWriter.reset();
                try {
                    orCreateWriter.write(jsonWriter, next2);
                    jsonWriter.toStream(outputStream);
                } catch (ConfigurationException e3) {
                    throw e3;
                } catch (Exception e4) {
                    throw new IOException(e4);
                }
            } else {
                outputStream.write(NULL);
            }
        }
        outputStream.write(93);
    }

    public <T> void iterateOver(Iterator<T> it, Class<T> cls, OutputStream outputStream, JsonWriter jsonWriter) throws IOException {
        if (it == null) {
            throw new IllegalArgumentException("iterator can't be null");
        }
        if (cls == null) {
            throw new IllegalArgumentException("manifest can't be null");
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        if (jsonWriter == null) {
            jsonWriter = new JsonWriter(this);
        }
        JsonWriter.WriteObject orCreateWriter = getOrCreateWriter(null, cls);
        outputStream.write(91);
        T next = it.next();
        if (next != null) {
            jsonWriter.reset();
            try {
                orCreateWriter.write(jsonWriter, next);
                jsonWriter.toStream(outputStream);
            } catch (ConfigurationException e) {
                throw e;
            } catch (Exception e2) {
                throw new IOException(e2);
            }
        } else {
            outputStream.write(NULL);
        }
        while (it.hasNext()) {
            outputStream.write(44);
            T next2 = it.next();
            if (next2 != null) {
                jsonWriter.reset();
                try {
                    orCreateWriter.write(jsonWriter, next2);
                    jsonWriter.toStream(outputStream);
                } catch (ConfigurationException e3) {
                    throw e3;
                } catch (Exception e4) {
                    throw new IOException(e4);
                }
            } else {
                outputStream.write(NULL);
            }
        }
        outputStream.write(93);
    }

    @Deprecated
    public <T extends JsonObject> void serialize(JsonWriter jsonWriter, T[] tArr) {
        if (tArr == null) {
            jsonWriter.writeNull();
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        if (tArr.length != 0) {
            T t = tArr[0];
            if (t != null) {
                t.serialize(jsonWriter, this.omitDefaults);
            } else {
                jsonWriter.writeNull();
            }
            for (int i = 1; i < tArr.length; i++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                T t2 = tArr[i];
                if (t2 != null) {
                    t2.serialize(jsonWriter, this.omitDefaults);
                } else {
                    jsonWriter.writeNull();
                }
            }
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    @Deprecated
    public <T extends JsonObject> void serialize(JsonWriter jsonWriter, T[] tArr, int i) {
        if (jsonWriter == null) {
            throw new IllegalArgumentException("writer can't be null");
        }
        if (tArr == null) {
            jsonWriter.writeNull();
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        if (i != 0) {
            T t = tArr[0];
            if (t != null) {
                t.serialize(jsonWriter, this.omitDefaults);
            } else {
                jsonWriter.writeNull();
            }
            for (int i2 = 1; i2 < i; i2++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                T t2 = tArr[i2];
                if (t2 != null) {
                    t2.serialize(jsonWriter, this.omitDefaults);
                } else {
                    jsonWriter.writeNull();
                }
            }
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    @Deprecated
    public <T extends JsonObject> void serialize(JsonWriter jsonWriter, List<T> list) {
        if (jsonWriter == null) {
            throw new IllegalArgumentException("writer can't be null");
        }
        if (list == null) {
            jsonWriter.writeNull();
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        if (list.size() != 0) {
            T t = list.get(0);
            if (t != null) {
                t.serialize(jsonWriter, this.omitDefaults);
            } else {
                jsonWriter.writeNull();
            }
            for (int i = 1; i < list.size(); i++) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                T t2 = list.get(i);
                if (t2 != null) {
                    t2.serialize(jsonWriter, this.omitDefaults);
                } else {
                    jsonWriter.writeNull();
                }
            }
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    @Deprecated
    public <T extends JsonObject> void serialize(JsonWriter jsonWriter, Collection<T> collection) {
        if (jsonWriter == null) {
            throw new IllegalArgumentException("writer can't be null");
        }
        if (collection == null) {
            jsonWriter.writeNull();
            return;
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_START);
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            T next = it.next();
            if (next != null) {
                next.serialize(jsonWriter, this.omitDefaults);
            } else {
                jsonWriter.writeNull();
            }
            while (it.hasNext()) {
                jsonWriter.writeByte(JsonWriter.COMMA);
                T next2 = it.next();
                if (next2 != null) {
                    next2.serialize(jsonWriter, this.omitDefaults);
                } else {
                    jsonWriter.writeNull();
                }
            }
        }
        jsonWriter.writeByte(JsonWriter.ARRAY_END);
    }

    /* JADX WARN: Found duplicated region for block: B:61:0x00a8  */
    public boolean serialize(JsonWriter jsonWriter, Type type, Object obj) {
        Class cls;
        try {
            if (jsonWriter == null) {
                throw new IllegalArgumentException("writer can't be null");
            }
            if (obj == null) {
                jsonWriter.writeNull();
                return true;
            }
            if (obj instanceof JsonObject) {
                ((JsonObject) obj).serialize(jsonWriter, this.omitDefaults);
                return true;
            }
            if (obj instanceof JsonObject[]) {
                serialize(jsonWriter, (JsonObject[]) obj);
                return true;
            }
            JsonWriter.WriteObject<?> writeObjectTryFindWriter = tryFindWriter(type);
            if (writeObjectTryFindWriter != null) {
                writeObjectTryFindWriter.write(jsonWriter, obj);
                return true;
            }
            Class cls2 = null;
            Class cls3 = type instanceof Class ? (Class) type : null;
            if (cls3 != null && cls3.isArray()) {
                if (Array.getLength(obj) == 0) {
                    jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    return true;
                }
                Class componentType = cls3.getComponentType();
                if (Character.TYPE == componentType) {
                    StringConverter.serialize(new String((char[]) obj), jsonWriter);
                    return true;
                }
                Object objTryFindWriter = tryFindWriter(componentType);
                if (objTryFindWriter != null) {
                    jsonWriter.serialize((Object[]) obj, (JsonWriter.WriteObject) objTryFindWriter);
                    return true;
                }
            }
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                if (collection.isEmpty()) {
                    jsonWriter.writeAscii(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    return true;
                }
                Iterator it = collection.iterator();
                boolean z = collection instanceof List;
                List arrayList = z ? (List) collection : new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Class cls4 = null;
                Object objTryFindWriter2 = null;
                boolean z2 = false;
                do {
                    Object next = it.next();
                    if (!z) {
                        arrayList.add(next);
                    }
                    if (next != null) {
                        Class cls5 = next.getClass();
                        if (cls5 != cls2) {
                            if (cls2 != null) {
                                boolean zIsAssignableFrom = cls5.isAssignableFrom(cls2);
                                cls = cls2;
                                if (zIsAssignableFrom) {
                                    cls = cls5;
                                }
                            } else {
                                cls = cls5;
                            }
                        }
                        if (cls4 != cls5) {
                            objTryFindWriter2 = tryFindWriter(cls5);
                            cls4 = cls5;
                        }
                        arrayList2.add(objTryFindWriter2);
                        if (z2 || objTryFindWriter2 == null) {
                            z2 = true;
                            cls2 = cls;
                            cls4 = cls4;
                        } else {
                            z2 = false;
                            cls2 = cls;
                            cls4 = cls4;
                        }
                    } else {
                        arrayList2.add(this.NULL_WRITER);
                        cls2 = cls2;
                        cls4 = cls4;
                    }
                } while (it.hasNext());
                if (cls2 != null && JsonObject.class.isAssignableFrom(cls2)) {
                    jsonWriter.writeByte(JsonWriter.ARRAY_START);
                    Iterator it2 = arrayList.iterator();
                    JsonObject jsonObject = (JsonObject) it2.next();
                    if (jsonObject != null) {
                        jsonObject.serialize(jsonWriter, this.omitDefaults);
                    } else {
                        jsonWriter.writeNull();
                    }
                    while (it2.hasNext()) {
                        jsonWriter.writeByte(JsonWriter.COMMA);
                        JsonObject jsonObject2 = (JsonObject) it2.next();
                        if (jsonObject2 != null) {
                            jsonObject2.serialize(jsonWriter, this.omitDefaults);
                        } else {
                            jsonWriter.writeNull();
                        }
                    }
                    jsonWriter.writeByte(JsonWriter.ARRAY_END);
                    return true;
                }
                if (!z2) {
                    jsonWriter.writeByte(JsonWriter.ARRAY_START);
                    Iterator it3 = arrayList.iterator();
                    ((JsonWriter.WriteObject) arrayList2.get(0)).write(jsonWriter, it3.next());
                    int i = 1;
                    while (it3.hasNext()) {
                        jsonWriter.writeByte(JsonWriter.COMMA);
                        ((JsonWriter.WriteObject) arrayList2.get(i)).write(jsonWriter, it3.next());
                        i++;
                    }
                    jsonWriter.writeByte(JsonWriter.ARRAY_END);
                    return true;
                }
                Object objTryFindWriter3 = tryFindWriter(cls2);
                if (objTryFindWriter3 != null) {
                    jsonWriter.serialize(collection, (JsonWriter.WriteObject) objTryFindWriter3);
                    return true;
                }
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final void serialize(Object obj, OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }
        if (obj == null) {
            outputStream.write(NULL);
            return;
        }
        JsonWriter jsonWriter = this.localWriter.get();
        jsonWriter.reset(outputStream);
        Class<?> cls = obj.getClass();
        if (!serialize(jsonWriter, cls, obj)) {
            Fallback<TContext> fallback = this.fallback;
            if (fallback == null) {
                throw new ConfigurationException("Unable to serialize provided object. Failed to find serializer for: " + cls);
            }
            fallback.serialize(obj, outputStream);
            return;
        }
        jsonWriter.flush();
        jsonWriter.reset(null);
    }

    @Override // com.bugsnag.android.repackaged.dslplatform.json.UnknownSerializer
    public final void serialize(JsonWriter jsonWriter, Object obj) throws IOException {
        if (jsonWriter == null) {
            throw new IllegalArgumentException("writer can't be null");
        }
        if (obj == null) {
            jsonWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (serialize(jsonWriter, cls, obj)) {
            return;
        }
        if (this.fallback == null) {
            throw new ConfigurationException("Unable to serialize provided object. Failed to find serializer for: " + cls);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.fallback.serialize(obj, byteArrayOutputStream);
        jsonWriter.writeAscii(byteArrayOutputStream.toByteArray());
    }
}
