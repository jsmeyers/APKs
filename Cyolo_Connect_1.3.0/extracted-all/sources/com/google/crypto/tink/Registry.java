package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class Registry {
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final AtomicReference<KeyManagerRegistry> keyManagerRegistry = new AtomicReference<>(new KeyManagerRegistry());
    private static final ConcurrentMap<String, KeyDeriverContainer> keyDeriverMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyTemplate> keyTemplateMap = new ConcurrentHashMap();

    private interface KeyDeriverContainer {
        KeyData deriveKey(ByteString serializedKeyFormat, InputStream stream) throws GeneralSecurityException;
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer createDeriverFor(final KeyTypeManager<KeyProtoT> keyManager) {
        return new KeyDeriverContainer() { // from class: com.google.crypto.tink.Registry.1
            /* JADX WARN: Unknown type variable: KeyProtoT in type: com.google.crypto.tink.internal.KeyTypeManager$KeyFactory<KeyFormatProtoT extends com.google.crypto.tink.shaded.protobuf.MessageLite, KeyProtoT> */
            private <KeyFormatProtoT extends MessageLite> MessageLite deriveKeyWithFactory(ByteString serializedKeyFormat, InputStream stream, KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) throws GeneralSecurityException {
                try {
                    MessageLite keyFormat = keyFactory.parseKeyFormat(serializedKeyFormat);
                    keyFactory.validateKeyFormat(keyFormat);
                    return keyFactory.deriveKey(keyFormat, stream);
                } catch (InvalidProtocolBufferException e) {
                    throw new GeneralSecurityException("parsing key format failed in deriveKey", e);
                }
            }

            @Override // com.google.crypto.tink.Registry.KeyDeriverContainer
            public KeyData deriveKey(ByteString serializedKeyFormat, InputStream stream) throws GeneralSecurityException {
                return (KeyData) KeyData.newBuilder().setTypeUrl(keyManager.getKeyType()).setValue(deriveKeyWithFactory(serializedKeyFormat, stream, keyManager.keyFactory()).toByteString()).setKeyMaterialType(keyManager.keyMaterialType()).build();
            }
        };
    }

    static synchronized void reset() {
        keyManagerRegistry.set(new KeyManagerRegistry());
        MutablePrimitiveRegistry.resetGlobalInstanceTestOnly();
        keyDeriverMap.clear();
        newKeyAllowedMap.clear();
        catalogueMap.clear();
        keyTemplateMap.clear();
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Deprecated
    public static synchronized void addCatalogue(String catalogueName, Catalogue<?> catalogue) throws GeneralSecurityException {
        try {
            if (catalogueName == null) {
                throw new IllegalArgumentException("catalogueName must be non-null.");
            }
            if (catalogue == null) {
                throw new IllegalArgumentException("catalogue must be non-null.");
            }
            ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
            if (concurrentMap.containsKey(catalogueName.toLowerCase(Locale.US))) {
                if (!catalogue.getClass().getName().equals(concurrentMap.get(catalogueName.toLowerCase(Locale.US)).getClass().getName())) {
                    logger.warning("Attempted overwrite of a catalogueName catalogue for name " + catalogueName);
                    throw new GeneralSecurityException("catalogue for name " + catalogueName + " has been already registered");
                }
            }
            concurrentMap.put(catalogueName.toLowerCase(Locale.US), catalogue);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String catalogueName) throws GeneralSecurityException {
        if (catalogueName == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        Catalogue<?> catalogue = catalogueMap.get(catalogueName.toLowerCase(Locale.US));
        if (catalogue != null) {
            return catalogue;
        }
        String str = String.format("no catalogue found for %s. ", catalogueName);
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkaead")) {
            str = str + "Maybe call AeadConfig.register().";
        }
        if (catalogueName.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
            str = str + "Maybe call DeterministicAeadConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
            str = str + "Maybe call StreamingAeadConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || catalogueName.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
            str = str + "Maybe call HybridConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkmac")) {
            str = str + "Maybe call MacConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || catalogueName.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
            str = str + "Maybe call SignatureConfig.register().";
        } else if (catalogueName.toLowerCase(Locale.US).startsWith("tink")) {
            str = str + "Maybe call TinkConfig.register().";
        }
        throw new GeneralSecurityException(str);
    }

    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager) throws GeneralSecurityException {
        registerKeyManager((KeyManager) manager, true);
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static synchronized <P> void registerKeyManager(final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        try {
            if (manager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerKeyManager(manager);
            if (!TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
                throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
            }
            String keyType = manager.getKeyType();
            ensureKeyManagerInsertable(keyType, Collections.emptyMap(), newKeyAllowed);
            newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
            atomicReference.set(keyManagerRegistry2);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(final KeyTypeManager<KeyProtoT> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        try {
            if (manager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerKeyManager(manager);
            String keyType = manager.getKeyType();
            ensureKeyManagerInsertable(keyType, newKeyAllowed ? manager.keyFactory().keyFormats() : Collections.emptyMap(), newKeyAllowed);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(manager));
                if (newKeyAllowed) {
                    registerKeyTemplates(keyType, manager.keyFactory().keyFormats());
                }
            }
            newKeyAllowedMap.put(keyType, Boolean.valueOf(newKeyAllowed));
            atomicReference.set(keyManagerRegistry2);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager) throws GeneralSecurityException {
        registerKeyManager(typeUrl, manager, true);
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Deprecated
    public static synchronized <P> void registerKeyManager(String typeUrl, final KeyManager<P> manager, boolean newKeyAllowed) throws GeneralSecurityException {
        try {
            if (manager == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            if (!typeUrl.equals(manager.getKeyType())) {
                throw new GeneralSecurityException("Manager does not support key type " + typeUrl + ".");
            }
            registerKeyManager(manager, newKeyAllowed);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized <KeyProtoT extends MessageLite, KeyFormatProtoT extends MessageLite> void ensureKeyManagerInsertable(String typeUrl, Map<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> keyFormats, boolean newKeyAllowed) throws GeneralSecurityException {
        if (newKeyAllowed) {
            try {
                ConcurrentMap<String, Boolean> concurrentMap = newKeyAllowedMap;
                if (concurrentMap.containsKey(typeUrl) && !concurrentMap.get(typeUrl).booleanValue()) {
                    throw new GeneralSecurityException("New keys are already disallowed for key type " + typeUrl);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (newKeyAllowed) {
            if (keyManagerRegistry.get().typeUrlExists(typeUrl)) {
                for (Map.Entry<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> entry : keyFormats.entrySet()) {
                    if (!keyTemplateMap.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + entry.getKey() + " from an existing key manager of type " + typeUrl);
                    }
                }
            } else {
                for (Map.Entry<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> entry2 : keyFormats.entrySet()) {
                    if (keyTemplateMap.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template " + entry2.getKey());
                    }
                }
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(final PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, final KeyTypeManager<PublicKeyProtoT> publicKeyTypeManager, boolean newKeyAllowed) throws GeneralSecurityException {
        try {
            if (privateKeyTypeManager == null || publicKeyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerAsymmetricKeyManagers(privateKeyTypeManager, publicKeyTypeManager);
            String keyType = privateKeyTypeManager.getKeyType();
            String keyType2 = publicKeyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, newKeyAllowed ? privateKeyTypeManager.keyFactory().keyFormats() : Collections.emptyMap(), newKeyAllowed);
            ensureKeyManagerInsertable(keyType2, Collections.emptyMap(), false);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(privateKeyTypeManager));
                if (newKeyAllowed) {
                    registerKeyTemplates(privateKeyTypeManager.getKeyType(), privateKeyTypeManager.keyFactory().keyFormats());
                }
            }
            ConcurrentMap<String, Boolean> concurrentMap = newKeyAllowedMap;
            concurrentMap.put(keyType, Boolean.valueOf(newKeyAllowed));
            concurrentMap.put(keyType2, false);
            atomicReference.set(keyManagerRegistry2);
        } catch (Throwable th) {
            throw th;
        }
    }

    private static <KeyFormatProtoT extends MessageLite> void registerKeyTemplates(String typeUrl, Map<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> keyFormats) {
        for (Map.Entry<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> entry : keyFormats.entrySet()) {
            keyTemplateMap.put(entry.getKey(), KeyTemplate.create(typeUrl, entry.getValue().keyFormat.toByteArray(), entry.getValue().outputPrefixType));
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(final PrimitiveWrapper<B, P> wrapper) throws GeneralSecurityException {
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(wrapper);
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String typeUrl) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl);
    }

    public static <P> KeyManager<P> getKeyManager(String typeUrl, Class<P> primitiveClass) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl, primitiveClass);
    }

    public static KeyManager<?> getUntypedKeyManager(String typeUrl) throws GeneralSecurityException {
        return keyManagerRegistry.get().getUntypedKeyManager(typeUrl);
    }

    public static synchronized KeyData newKeyData(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyManager<?> untypedKeyManager;
        untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
        if (newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
        } else {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
        }
        return untypedKeyManager.newKeyData(keyTemplate.getValue());
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return newKeyData(keyTemplate.getProto());
    }

    public static synchronized MessageLite newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyManager<?> untypedKeyManager;
        untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
        if (newKeyAllowedMap.get(keyTemplate.getTypeUrl()).booleanValue()) {
        } else {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
        }
        return untypedKeyManager.newKey(keyTemplate.getValue());
    }

    public static synchronized MessageLite newKey(String typeUrl, MessageLite format) throws GeneralSecurityException {
        KeyManager keyManager;
        keyManager = getKeyManager(typeUrl);
        if (newKeyAllowedMap.get(typeUrl).booleanValue()) {
        } else {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + typeUrl);
        }
        return keyManager.newKey(format);
    }

    static synchronized KeyData deriveKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate, InputStream randomStream) throws GeneralSecurityException {
        String typeUrl;
        ConcurrentMap<String, KeyDeriverContainer> concurrentMap;
        typeUrl = keyTemplate.getTypeUrl();
        concurrentMap = keyDeriverMap;
        if (!concurrentMap.containsKey(typeUrl)) {
            throw new GeneralSecurityException("No keymanager registered or key manager cannot derive keys for " + typeUrl);
        }
        return concurrentMap.get(typeUrl).deriveKey(keyTemplate.getValue(), randomStream);
    }

    public static KeyData getPublicKeyData(String typeUrl, ByteString serializedPrivateKey) throws GeneralSecurityException {
        KeyManager keyManager = getKeyManager(typeUrl);
        if (!(keyManager instanceof PrivateKeyManager)) {
            throw new GeneralSecurityException("manager for key type " + typeUrl + " is not a PrivateKeyManager");
        }
        return ((PrivateKeyManager) keyManager).getPublicKeyData(serializedPrivateKey);
    }

    @Deprecated
    public static <P> P getPrimitive(String typeUrl, MessageLite key) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl).getPrimitive(key);
    }

    public static <P> P getPrimitive(String typeUrl, MessageLite key, Class<P> primitiveClass) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl, primitiveClass).getPrimitive(key);
    }

    @Deprecated
    public static <P> P getPrimitive(String typeUrl, ByteString serializedKey) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl).getPrimitive(serializedKey);
    }

    public static <P> P getPrimitive(String typeUrl, ByteString serializedKey, Class<P> primitiveClass) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(typeUrl, primitiveClass).getPrimitive(serializedKey);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) throws GeneralSecurityException {
        return (P) getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    static <KeyT extends Key, P> P getFullPrimitive(KeyT keyt, Class<P> cls) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().getPrimitive(keyt, cls);
    }

    public static <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> cls) throws GeneralSecurityException {
        return (P) MutablePrimitiveRegistry.globalInstance().wrap(primitiveSet, cls);
    }

    public static <P> P wrap(PrimitiveSet<P> primitiveSet) throws GeneralSecurityException {
        return (P) wrap(primitiveSet, primitiveSet.getPrimitiveClass());
    }

    public static synchronized List<String> keyTemplates() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(keyTemplateMap.keySet());
        return Collections.unmodifiableList(arrayList);
    }

    static synchronized Map<String, KeyTemplate> keyTemplateMap() {
        return Collections.unmodifiableMap(keyTemplateMap);
    }

    @Nullable
    public static Class<?> getInputPrimitive(Class<?> wrappedPrimitive) {
        try {
            return MutablePrimitiveRegistry.globalInstance().getInputPrimitiveClass(wrappedPrimitive);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    static MessageLite parseKeyData(KeyData keyData) throws InvalidProtocolBufferException, GeneralSecurityException {
        return keyManagerRegistry.get().parseKeyData(keyData);
    }

    public static synchronized void restrictToFipsIfEmpty() throws GeneralSecurityException {
        if (TinkFipsUtil.useOnlyFips()) {
            return;
        }
        if (keyManagerRegistry.get().isEmpty()) {
            TinkFipsUtil.setFipsRestricted();
            return;
        }
        throw new GeneralSecurityException("Could not enable FIPS mode as Registry is not empty.");
    }

    private Registry() {
    }
}
