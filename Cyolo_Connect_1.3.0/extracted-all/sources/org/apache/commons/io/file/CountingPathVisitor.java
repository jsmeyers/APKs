package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import org.apache.commons.io.file.Counters;

/* JADX INFO: loaded from: classes3.dex */
public class CountingPathVisitor extends SimplePathVisitor {
    static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final Counters.PathCounters pathCounters;

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) throws IOException {
        return postVisitDirectory(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m1668m(obj), iOException);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) throws IOException {
        return visitFile(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m1668m(obj), basicFileAttributes);
    }

    public static CountingPathVisitor withBigIntegerCounters() {
        return new CountingPathVisitor(Counters.bigIntegerPathCounters());
    }

    public static CountingPathVisitor withLongCounters() {
        return new CountingPathVisitor(Counters.longPathCounters());
    }

    public CountingPathVisitor(Counters.PathCounters pathCounters) {
        this.pathCounters = (Counters.PathCounters) Objects.requireNonNull(pathCounters, "pathCounter");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CountingPathVisitor) {
            return Objects.equals(this.pathCounters, ((CountingPathVisitor) obj).pathCounters);
        }
        return false;
    }

    public Counters.PathCounters getPathCounters() {
        return this.pathCounters;
    }

    public int hashCode() {
        return Objects.hash(this.pathCounters);
    }

    public FileVisitResult postVisitDirectory(Path path, IOException iOException) throws IOException {
        this.pathCounters.getDirectoryCounter().increment();
        return FileVisitResult.CONTINUE;
    }

    public String toString() {
        return this.pathCounters.toString();
    }

    protected void updateFileCounters(Path path, BasicFileAttributes basicFileAttributes) {
        this.pathCounters.getFileCounter().increment();
        this.pathCounters.getByteCounter().add(basicFileAttributes.size());
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (Files.exists(path, new LinkOption[0])) {
            updateFileCounters(path, basicFileAttributes);
        }
        return FileVisitResult.CONTINUE;
    }
}
