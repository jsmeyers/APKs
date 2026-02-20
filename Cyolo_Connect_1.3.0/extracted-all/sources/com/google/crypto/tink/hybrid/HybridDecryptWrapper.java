package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.monitoring.MonitoringClient;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt, HybridDecrypt> {
    private static final Logger logger = Logger.getLogger(HybridDecryptWrapper.class.getName());
    private static final HybridDecryptWrapper WRAPPER = new HybridDecryptWrapper();

    private static class WrappedHybridDecrypt implements HybridDecrypt {
        private final MonitoringClient.Logger decLogger;
        private final PrimitiveSet<HybridDecrypt> primitives;

        public WrappedHybridDecrypt(final PrimitiveSet<HybridDecrypt> primitives) {
            this.primitives = primitives;
            if (primitives.hasAnnotations()) {
                this.decLogger = MutableMonitoringRegistry.globalInstance().getMonitoringClient().createLogger(MonitoringUtil.getMonitoringKeysetInfo(primitives), "hybrid_decrypt", "decrypt");
            } else {
                this.decLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            }
        }

        @Override // com.google.crypto.tink.HybridDecrypt
        public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
            if (ciphertext.length > 5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(ciphertext, 0, 5);
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(ciphertext, 5, ciphertext.length);
                for (PrimitiveSet.Entry<HybridDecrypt> entry : this.primitives.getPrimitive(bArrCopyOfRange)) {
                    try {
                        byte[] bArrDecrypt = entry.getPrimitive().decrypt(bArrCopyOfRange2, contextInfo);
                        this.decLogger.log(entry.getKeyId(), bArrCopyOfRange2.length);
                        return bArrDecrypt;
                    } catch (GeneralSecurityException e) {
                        HybridDecryptWrapper.logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            for (PrimitiveSet.Entry<HybridDecrypt> entry2 : this.primitives.getRawPrimitives()) {
                try {
                    byte[] bArrDecrypt2 = entry2.getPrimitive().decrypt(ciphertext, contextInfo);
                    this.decLogger.log(entry2.getKeyId(), ciphertext.length);
                    return bArrDecrypt2;
                } catch (GeneralSecurityException unused) {
                }
            }
            this.decLogger.logFailure();
            throw new GeneralSecurityException("decryption failed");
        }
    }

    HybridDecryptWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public HybridDecrypt wrap(final PrimitiveSet<HybridDecrypt> primitives) {
        return new WrappedHybridDecrypt(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridDecrypt> getPrimitiveClass() {
        return HybridDecrypt.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridDecrypt> getInputPrimitiveClass() {
        return HybridDecrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(WRAPPER);
    }
}
