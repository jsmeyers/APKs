package androidx.test.espresso.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.collect.Maps;
import j$.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TreeIterables {
    private static final TreeViewer<View> VIEW_TREE_VIEWER = new ViewTreeViewer();

    interface TreeViewer<T> {
        Collection<T> children(T instance);
    }

    private TreeIterables() {
    }

    public static Iterable<ViewAndDistance> depthFirstViewTraversalWithDistance(View root) {
        final DistanceRecordingTreeViewer distanceRecordingTreeViewer = new DistanceRecordingTreeViewer(root, VIEW_TREE_VIEWER);
        return Iterables.transform(depthFirstTraversal(root, distanceRecordingTreeViewer), new Function<View, ViewAndDistance>() { // from class: androidx.test.espresso.util.TreeIterables.1
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public ViewAndDistance apply(View view) {
                return new ViewAndDistance(view, distanceRecordingTreeViewer.getDistance(view));
            }
        });
    }

    public static Iterable<View> depthFirstViewTraversal(View root) {
        return depthFirstTraversal(root, VIEW_TREE_VIEWER);
    }

    public static Iterable<View> breadthFirstViewTraversal(View root) {
        return breadthFirstTraversal(root, VIEW_TREE_VIEWER);
    }

    static <T> Iterable<T> depthFirstTraversal(final T root, final TreeViewer<T> viewer) {
        Preconditions.checkNotNull(root);
        Preconditions.checkNotNull(viewer);
        return new TreeTraversalIterable(root, TraversalStrategy.DEPTH_FIRST, viewer);
    }

    static <T> Iterable<T> breadthFirstTraversal(final T root, final TreeViewer<T> viewer) {
        Preconditions.checkNotNull(root);
        Preconditions.checkNotNull(viewer);
        return new TreeTraversalIterable(root, TraversalStrategy.BREADTH_FIRST, viewer);
    }

    private static class TreeTraversalIterable<T> implements Iterable<T> {
        private final T root;
        private final TraversalStrategy traversalStrategy;
        private final TreeViewer<T> treeViewer;

        private TreeTraversalIterable(T t, TraversalStrategy traversalStrategy, TreeViewer<T> treeViewer) {
            this.root = (T) Preconditions.checkNotNull(t);
            this.traversalStrategy = (TraversalStrategy) Preconditions.checkNotNull(traversalStrategy);
            this.treeViewer = (TreeViewer) Preconditions.checkNotNull(treeViewer);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            final LinkedList linkedListNewLinkedList = Lists.newLinkedList();
            linkedListNewLinkedList.add(this.root);
            return new AbstractIterator<T>() { // from class: androidx.test.espresso.util.TreeIterables.TreeTraversalIterable.1
                @Override // androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator
                public T computeNext() {
                    if (!linkedListNewLinkedList.isEmpty()) {
                        T t = (T) Preconditions.checkNotNull(TreeTraversalIterable.this.traversalStrategy.next(linkedListNewLinkedList), "Null items not allowed!");
                        TreeTraversalIterable.this.traversalStrategy.combineNewChildren(linkedListNewLinkedList, TreeTraversalIterable.this.treeViewer.children(t));
                        return t;
                    }
                    return endOfData();
                }
            };
        }
    }

    private enum TraversalStrategy {
        BREADTH_FIRST { // from class: androidx.test.espresso.util.TreeIterables.TraversalStrategy.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.test.espresso.util.TreeIterables.TraversalStrategy
            <T> void combineNewChildren(LinkedList<T> nodes, Collection<T> newChildren) {
                nodes.addAll(newChildren);
            }
        },
        DEPTH_FIRST { // from class: androidx.test.espresso.util.TreeIterables.TraversalStrategy.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.test.espresso.util.TreeIterables.TraversalStrategy
            <T> void combineNewChildren(LinkedList<T> nodes, Collection<T> newChildren) {
                nodes.addAll(0, newChildren);
            }
        };

        abstract <T> void combineNewChildren(LinkedList<T> nodes, Collection<T> newChildren);

        <T> T next(LinkedList<T> linkedList) {
            return (T) List.EL.removeFirst(linkedList);
        }
    }

    static class ViewTreeViewer implements TreeViewer<View> {
        ViewTreeViewer() {
        }

        @Override // androidx.test.espresso.util.TreeIterables.TreeViewer
        public Collection<View> children(View view) {
            Preconditions.checkNotNull(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                for (int i = 0; i < childCount; i++) {
                    arrayListNewArrayList.add(viewGroup.getChildAt(i));
                }
                return arrayListNewArrayList;
            }
            return Collections.emptyList();
        }
    }

    static class DistanceRecordingTreeViewer<T> implements TreeViewer<T> {
        private final TreeViewer<T> delegateViewer;
        private final Map<T, Integer> nodeToDistance = Maps.newHashMap();
        private final T root;

        DistanceRecordingTreeViewer(T t, TreeViewer<T> treeViewer) {
            this.root = (T) Preconditions.checkNotNull(t);
            this.delegateViewer = (TreeViewer) Preconditions.checkNotNull(treeViewer);
        }

        int getDistance(T node) {
            return ((Integer) Preconditions.checkNotNull(this.nodeToDistance.get(node), "Never seen %s before", node)).intValue();
        }

        @Override // androidx.test.espresso.util.TreeIterables.TreeViewer
        public Collection<T> children(final T node) {
            if (node == this.root) {
                this.nodeToDistance.put(node, 0);
            }
            int distance = getDistance(node) + 1;
            Collection<T> collectionChildren = this.delegateViewer.children(node);
            Iterator<T> it = collectionChildren.iterator();
            while (it.hasNext()) {
                this.nodeToDistance.put(it.next(), Integer.valueOf(distance));
            }
            return collectionChildren;
        }
    }

    public static class ViewAndDistance {
        private final int distanceFromRoot;
        private final View view;

        private ViewAndDistance(View view, int distanceFromRoot) {
            this.view = view;
            this.distanceFromRoot = distanceFromRoot;
        }

        public View getView() {
            return this.view;
        }

        public int getDistanceFromRoot() {
            return this.distanceFromRoot;
        }
    }
}
