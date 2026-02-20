package org.apache.commons.io.file;

import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.file.Counters;

/* JADX INFO: loaded from: classes3.dex */
public final class PathUtils {
    public static final DeleteOption[] EMPTY_DELETE_OPTION_ARRAY = new DeleteOption[0];
    public static final FileVisitOption[] EMPTY_FILE_VISIT_OPTION_ARRAY = new FileVisitOption[0];
    public static final LinkOption[] EMPTY_LINK_OPTION_ARRAY = new LinkOption[0];
    public static final OpenOption[] EMPTY_OPEN_OPTION_ARRAY = new OpenOption[0];

    private static class RelativeSortedPaths {
        final boolean equals;
        final List<Path> relativeFileList1;
        final List<Path> relativeFileList2;

        private RelativeSortedPaths(Path path, Path path2, int i, LinkOption[] linkOptionArr, FileVisitOption[] fileVisitOptionArr) throws IOException {
            List<Path> list;
            List<Path> list2 = null;
            if (path == null && path2 == null) {
                this.equals = true;
            } else {
                if ((path == null) ^ (path2 == null)) {
                    this.equals = false;
                } else {
                    boolean zExists = Files.exists(path, linkOptionArr);
                    boolean zExists2 = Files.exists(path2, linkOptionArr);
                    if (zExists && zExists2) {
                        AccumulatorPathVisitor accumulatorPathVisitorAccumulate = PathUtils.accumulate(path, i, fileVisitOptionArr);
                        AccumulatorPathVisitor accumulatorPathVisitorAccumulate2 = PathUtils.accumulate(path2, i, fileVisitOptionArr);
                        if (accumulatorPathVisitorAccumulate.getDirList().size() != accumulatorPathVisitorAccumulate2.getDirList().size() || accumulatorPathVisitorAccumulate.getFileList().size() != accumulatorPathVisitorAccumulate2.getFileList().size() || !accumulatorPathVisitorAccumulate.relativizeDirectories(path, true, null).equals(accumulatorPathVisitorAccumulate2.relativizeDirectories(path2, true, null))) {
                            this.equals = false;
                        } else {
                            List<Path> listRelativizeFiles = accumulatorPathVisitorAccumulate.relativizeFiles(path, true, null);
                            List<Path> listRelativizeFiles2 = accumulatorPathVisitorAccumulate2.relativizeFiles(path2, true, null);
                            this.equals = listRelativizeFiles.equals(listRelativizeFiles2);
                            list2 = listRelativizeFiles;
                            list = listRelativizeFiles2;
                        }
                        this.relativeFileList1 = list2;
                        this.relativeFileList2 = list;
                    }
                    this.equals = (zExists || zExists2) ? false : true;
                }
            }
            list = null;
            this.relativeFileList1 = list2;
            this.relativeFileList2 = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AccumulatorPathVisitor accumulate(Path path, int i, FileVisitOption[] fileVisitOptionArr) throws IOException {
        return (AccumulatorPathVisitor) visitFileTree(AccumulatorPathVisitor.withLongCounters(), path, toFileVisitOptionSet(fileVisitOptionArr), i);
    }

    public static Counters.PathCounters cleanDirectory(Path path) throws IOException {
        return cleanDirectory(path, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters cleanDirectory(Path path, DeleteOption... deleteOptionArr) throws IOException {
        return ((CleaningPathVisitor) visitFileTree(new CleaningPathVisitor(Counters.longPathCounters(), deleteOptionArr, new String[0]), path)).getPathCounters();
    }

    public static Counters.PathCounters copyDirectory(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        return ((CopyDirectoryVisitor) visitFileTree(new CopyDirectoryVisitor(Counters.longPathCounters(), path, path2, copyOptionArr), path)).getPathCounters();
    }

    public static Path copyFile(URL url, Path path, CopyOption... copyOptionArr) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            Files.copy(inputStreamOpenStream, path, copyOptionArr);
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
            return path;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static Path copyFileToDirectory(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        return Files.copy(path, path2.resolve(path.getFileName()), copyOptionArr);
    }

    public static Path copyFileToDirectory(URL url, Path path, CopyOption... copyOptionArr) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            Files.copy(inputStreamOpenStream, path.resolve(url.getFile()), copyOptionArr);
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
            return path;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static Counters.PathCounters countDirectory(Path path) throws IOException {
        return ((CountingPathVisitor) visitFileTree(new CountingPathVisitor(Counters.longPathCounters()), path)).getPathCounters();
    }

    public static Counters.PathCounters delete(Path path) throws IOException {
        return delete(path, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters delete(Path path, DeleteOption... deleteOptionArr) throws IOException {
        return Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS) ? deleteDirectory(path, deleteOptionArr) : deleteFile(path, deleteOptionArr);
    }

    public static Counters.PathCounters deleteDirectory(Path path) throws IOException {
        return deleteDirectory(path, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters deleteDirectory(Path path, DeleteOption... deleteOptionArr) throws IOException {
        return ((DeletingPathVisitor) visitFileTree(new DeletingPathVisitor(Counters.longPathCounters(), deleteOptionArr, new String[0]), path)).getPathCounters();
    }

    public static Counters.PathCounters deleteFile(Path path) throws IOException {
        return deleteFile(path, EMPTY_DELETE_OPTION_ARRAY);
    }

    public static Counters.PathCounters deleteFile(Path path, DeleteOption... deleteOptionArr) throws IOException {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$5();
            throw NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m(path.toString());
        }
        Counters.PathCounters pathCountersLongPathCounters = Counters.longPathCounters();
        boolean zExists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        long size = zExists ? Files.size(path) : 0L;
        if (overrideReadOnly(deleteOptionArr) && zExists) {
            setReadOnly(path, false, LinkOption.NOFOLLOW_LINKS);
        }
        if (Files.deleteIfExists(path)) {
            pathCountersLongPathCounters.getFileCounter().increment();
            pathCountersLongPathCounters.getByteCounter().add(size);
        }
        return pathCountersLongPathCounters;
    }

    private static boolean overrideReadOnly(DeleteOption[] deleteOptionArr) {
        if (deleteOptionArr == null) {
            return false;
        }
        for (DeleteOption deleteOption : deleteOptionArr) {
            if (deleteOption == StandardDeleteOption.OVERRIDE_READ_ONLY) {
                return true;
            }
        }
        return false;
    }

    public static boolean directoryAndFileContentEquals(Path path, Path path2) throws IOException {
        return directoryAndFileContentEquals(path, path2, EMPTY_LINK_OPTION_ARRAY, EMPTY_OPEN_OPTION_ARRAY, EMPTY_FILE_VISIT_OPTION_ARRAY);
    }

    public static boolean directoryAndFileContentEquals(Path path, Path path2, LinkOption[] linkOptionArr, OpenOption[] openOptionArr, FileVisitOption[] fileVisitOptionArr) throws IOException {
        if (path == null && path2 == null) {
            return true;
        }
        if ((path == null) ^ (path2 == null)) {
            return false;
        }
        if (!Files.exists(path, new LinkOption[0]) && !Files.exists(path2, new LinkOption[0])) {
            return true;
        }
        RelativeSortedPaths relativeSortedPaths = new RelativeSortedPaths(path, path2, Integer.MAX_VALUE, linkOptionArr, fileVisitOptionArr);
        if (!relativeSortedPaths.equals) {
            return false;
        }
        List<Path> list = relativeSortedPaths.relativeFileList1;
        List<Path> list2 = relativeSortedPaths.relativeFileList2;
        Iterator<Path> it = list.iterator();
        while (it.hasNext()) {
            Path pathM1668m = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m1668m((Object) it.next());
            if (Collections.binarySearch(list2, pathM1668m) > -1) {
                if (!fileContentEquals(path.resolve(pathM1668m), path2.resolve(pathM1668m), linkOptionArr, openOptionArr)) {
                    return false;
                }
            } else {
                throw new IllegalStateException("Unexpected mismatch.");
            }
        }
        return true;
    }

    public static boolean directoryContentEquals(Path path, Path path2) throws IOException {
        return directoryContentEquals(path, path2, Integer.MAX_VALUE, EMPTY_LINK_OPTION_ARRAY, EMPTY_FILE_VISIT_OPTION_ARRAY);
    }

    public static boolean directoryContentEquals(Path path, Path path2, int i, LinkOption[] linkOptionArr, FileVisitOption[] fileVisitOptionArr) throws IOException {
        return new RelativeSortedPaths(path, path2, i, linkOptionArr, fileVisitOptionArr).equals;
    }

    public static boolean fileContentEquals(Path path, Path path2) throws IOException {
        return fileContentEquals(path, path2, EMPTY_LINK_OPTION_ARRAY, EMPTY_OPEN_OPTION_ARRAY);
    }

    public static boolean fileContentEquals(Path path, Path path2, LinkOption[] linkOptionArr, OpenOption[] openOptionArr) throws IOException {
        if (path == null && path2 == null) {
            return true;
        }
        if ((path == null) ^ (path2 == null)) {
            return false;
        }
        Path pathNormalize = path.normalize();
        Path pathNormalize2 = path2.normalize();
        boolean zExists = Files.exists(pathNormalize, linkOptionArr);
        if (zExists != Files.exists(pathNormalize2, linkOptionArr)) {
            return false;
        }
        if (!zExists) {
            return true;
        }
        if (Files.isDirectory(pathNormalize, linkOptionArr)) {
            throw new IOException("Can't compare directories, only files: " + pathNormalize);
        }
        if (Files.isDirectory(pathNormalize2, linkOptionArr)) {
            throw new IOException("Can't compare directories, only files: " + pathNormalize2);
        }
        if (Files.size(pathNormalize) != Files.size(pathNormalize2)) {
            return false;
        }
        if (path.equals(path2)) {
            return true;
        }
        InputStream inputStreamNewInputStream = Files.newInputStream(pathNormalize, openOptionArr);
        try {
            InputStream inputStreamNewInputStream2 = Files.newInputStream(pathNormalize2, openOptionArr);
            try {
                boolean zContentEquals = IOUtils.contentEquals(inputStreamNewInputStream, inputStreamNewInputStream2);
                if (inputStreamNewInputStream2 != null) {
                    inputStreamNewInputStream2.close();
                }
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
                return zContentEquals;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamNewInputStream2 != null) {
                        try {
                            inputStreamNewInputStream2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    public static List<AclEntry> getAclEntryList(Path path) throws IOException {
        AclFileAttributeView aclFileAttributeViewM2216m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2216m((Object) Files.getFileAttributeView(path, NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m$2(), new LinkOption[0]));
        if (aclFileAttributeViewM2216m == null) {
            return null;
        }
        return aclFileAttributeViewM2216m.getAcl();
    }

    public static boolean isEmpty(Path path) throws IOException {
        return Files.isDirectory(path, new LinkOption[0]) ? isEmptyDirectory(path) : isEmptyFile(path);
    }

    public static boolean isEmptyDirectory(Path path) throws IOException {
        DirectoryStream directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
        try {
            if (directoryStreamNewDirectoryStream.iterator().hasNext()) {
                if (directoryStreamNewDirectoryStream == null) {
                    return false;
                }
                directoryStreamNewDirectoryStream.close();
                return false;
            }
            if (directoryStreamNewDirectoryStream == null) {
                return true;
            }
            directoryStreamNewDirectoryStream.close();
            return true;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static boolean isEmptyFile(Path path) throws IOException {
        return Files.size(path) <= 0;
    }

    static List<Path> relativize(Collection<Path> collection, final Path path, boolean z, Comparator<? super Path> comparator) {
        Stream stream = Collection.EL.stream(collection);
        path.getClass();
        Stream map = stream.map(new Function() { // from class: org.apache.commons.io.file.PathUtils$$ExternalSyntheticLambda20
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return path.relativize((Path) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        });
        if (z) {
            map = comparator == null ? map.sorted() : map.sorted(comparator);
        }
        return (List) map.collect(Collectors.toList());
    }

    public static Path setReadOnly(Path path, boolean z, LinkOption... linkOptionArr) throws IOException {
        DosFileAttributeView dosFileAttributeViewM2218m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2218m((Object) Files.getFileAttributeView(path, NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m$4(), linkOptionArr));
        if (dosFileAttributeViewM2218m != null) {
            dosFileAttributeViewM2218m.setReadOnly(z);
            return path;
        }
        PosixFileAttributeView posixFileAttributeViewM2221m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2221m((Object) Files.getFileAttributeView(path, NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m$3(), linkOptionArr));
        if (posixFileAttributeViewM2221m != null) {
            Set setPermissions = posixFileAttributeViewM2221m.readAttributes().permissions();
            setPermissions.remove(PosixFilePermission.OWNER_WRITE);
            setPermissions.remove(PosixFilePermission.GROUP_WRITE);
            setPermissions.remove(PosixFilePermission.OTHERS_WRITE);
            return Files.setPosixFilePermissions(path, setPermissions);
        }
        throw new IOException("No DosFileAttributeView or PosixFileAttributeView for " + path);
    }

    static Set<FileVisitOption> toFileVisitOptionSet(FileVisitOption... fileVisitOptionArr) {
        if (fileVisitOptionArr == null) {
            return EnumSet.noneOf(NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m$1());
        }
        return (Set) DesugarArrays.stream(fileVisitOptionArr).collect(Collectors.toSet());
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T t, Path path) throws IOException {
        Files.walkFileTree(path, t);
        return t;
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T t, Path path, Set<FileVisitOption> set, int i) throws IOException {
        Files.walkFileTree(path, set, i, t);
        return t;
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T t, String str, String... strArr) throws IOException {
        return (T) visitFileTree(t, Paths.get(str, strArr));
    }

    public static <T extends FileVisitor<? super Path>> T visitFileTree(T t, URI uri) throws IOException {
        return (T) visitFileTree(t, Paths.get(uri));
    }

    private PathUtils() {
    }
}
