package com.google.i18n.phonenumbers.metadata.init;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class MetadataParser {
    private static final Logger logger = Logger.getLogger(MetadataParser.class.getName());
    private final boolean strictMode;

    public static MetadataParser newLenientParser() {
        return new MetadataParser(false);
    }

    public static MetadataParser newStrictParser() {
        return new MetadataParser(true);
    }

    private MetadataParser(boolean z) {
        this.strictMode = z;
    }

    /* JADX WARN: Found duplicated region for block: B:54:0x0045  */
    /* JADX WARN: Found duplicated region for block: B:55:0x0049  */
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
    public Collection<Phonemetadata.PhoneMetadata> parse(InputStream inputStream) throws Throwable {
        Throwable th;
        IOException e;
        if (inputStream == null) {
            return handleNullSource();
        }
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                try {
                    Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
                    phoneMetadataCollection.readExternal(objectInputStream);
                    if (phoneMetadataCollection.getMetadataList().isEmpty()) {
                        throw new IllegalStateException("Empty metadata");
                    }
                    List<Phonemetadata.PhoneMetadata> metadataList = phoneMetadataCollection.getMetadataList();
                    close(objectInputStream);
                    return metadataList;
                } catch (IOException e2) {
                    e = e2;
                    throw new IllegalStateException("Unable to parse metadata file", e);
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    close(null);
                } else {
                    close(inputStream);
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
                close(null);
            } else {
                close(inputStream);
            }
            throw th;
        }
    }

    private List<Phonemetadata.PhoneMetadata> handleNullSource() {
        if (this.strictMode) {
            throw new IllegalArgumentException("Source cannot be null");
        }
        return Collections.emptyList();
    }

    private void close(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error closing input stream (ignored)", (Throwable) e);
        }
    }
}
