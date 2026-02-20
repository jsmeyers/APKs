package okio;

import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class NioSystemFileSystem$$ExternalSyntheticApiModelOutline0 {
    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m2206m() {
        return FileAttributeView.class;
    }

    public static /* bridge */ /* synthetic */ CopyOption m(Object obj) {
        return (CopyOption) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DirectoryStream m2208m(Object obj) {
        return (DirectoryStream) obj;
    }

    public static /* synthetic */ NoSuchFileException m(String str) {
        return new NoSuchFileException(str);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ SecureDirectoryStream m2213m(Object obj) {
        return (SecureDirectoryStream) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AclFileAttributeView m2216m(Object obj) {
        return (AclFileAttributeView) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BasicFileAttributes m2217m(Object obj) {
        return (BasicFileAttributes) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DosFileAttributeView m2218m(Object obj) {
        return (DosFileAttributeView) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ FileAttributeView m2219m(Object obj) {
        return (FileAttributeView) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ PosixFileAttributeView m2221m(Object obj) {
        return (PosixFileAttributeView) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CompletableFuture m2226m() {
        return new CompletableFuture();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CompletionException m2228m(Object obj) {
        return (CompletionException) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m2230m(Object obj) {
        return obj instanceof SecureDirectoryStream;
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return FileVisitOption.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof CompletionException;
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return AclFileAttributeView.class;
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return PosixFileAttributeView.class;
    }

    public static /* bridge */ /* synthetic */ Class m$4() {
        return DosFileAttributeView.class;
    }
}
