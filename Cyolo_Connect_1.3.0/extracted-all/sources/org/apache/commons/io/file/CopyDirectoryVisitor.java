package org.apache.commons.io.file;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Objects;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import org.apache.commons.io.file.Counters;

/* JADX INFO: loaded from: classes3.dex */
public class CopyDirectoryVisitor extends CountingPathVisitor {
    private static final CopyOption[] EMPTY_COPY_OPTIONS = new CopyOption[0];
    private final CopyOption[] copyOptions;
    private final Path sourceDirectory;
    private final Path targetDirectory;

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) throws IOException {
        return preVisitDirectory(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m1668m(obj), basicFileAttributes);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor, java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) throws IOException {
        return visitFile(PathTreeWalk$$ExternalSyntheticApiModelOutline0.m1668m(obj), basicFileAttributes);
    }

    public CopyDirectoryVisitor(Counters.PathCounters pathCounters, Path path, Path path2, CopyOption... copyOptionArr) {
        super(pathCounters);
        this.sourceDirectory = path;
        this.targetDirectory = path2;
        this.copyOptions = copyOptionArr == null ? EMPTY_COPY_OPTIONS : (CopyOption[]) copyOptionArr.clone();
    }

    protected void copy(Path path, Path path2) throws IOException {
        Files.copy(path, path2, this.copyOptions);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        CopyDirectoryVisitor copyDirectoryVisitor = (CopyDirectoryVisitor) obj;
        return Arrays.equals(this.copyOptions, copyDirectoryVisitor.copyOptions) && Objects.equals(this.sourceDirectory, copyDirectoryVisitor.sourceDirectory) && Objects.equals(this.targetDirectory, copyDirectoryVisitor.targetDirectory);
    }

    public CopyOption[] getCopyOptions() {
        return (CopyOption[]) this.copyOptions.clone();
    }

    public Path getSourceDirectory() {
        return this.sourceDirectory;
    }

    public Path getTargetDirectory() {
        return this.targetDirectory;
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public int hashCode() {
        return (((super.hashCode() * 31) + Arrays.hashCode(this.copyOptions)) * 31) + Objects.hash(this.sourceDirectory, this.targetDirectory);
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        Path pathResolve = this.targetDirectory.resolve(this.sourceDirectory.relativize(path));
        if (Files.notExists(pathResolve, new LinkOption[0])) {
            Files.createDirectory(pathResolve, new FileAttribute[0]);
        }
        return super.preVisitDirectory((Object) path, basicFileAttributes);
    }

    @Override // org.apache.commons.io.file.CountingPathVisitor
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        Path pathResolve = this.targetDirectory.resolve(this.sourceDirectory.relativize(path));
        copy(path, pathResolve);
        return super.visitFile(pathResolve, basicFileAttributes);
    }
}
