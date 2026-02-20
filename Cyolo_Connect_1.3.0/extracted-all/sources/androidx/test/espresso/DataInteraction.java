package androidx.test.espresso;

import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import androidx.test.espresso.action.AdapterDataLoaderAction;
import androidx.test.espresso.action.AdapterViewProtocol;
import androidx.test.espresso.action.AdapterViewProtocols;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.ConstructorInvocation;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.remote.annotation.RemoteMsgField;
import androidx.test.espresso.util.EspressoOptional;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

/* JADX INFO: loaded from: classes.dex */
public class DataInteraction {
    private final Matcher<? extends Object> dataMatcher;
    private Matcher<View> adapterMatcher = ViewMatchers.isAssignableFrom(AdapterView.class);
    private EspressoOptional<Matcher<View>> childViewMatcher = EspressoOptional.absent();
    private EspressoOptional<Integer> atPosition = EspressoOptional.absent();
    private AdapterViewProtocol adapterViewProtocol = AdapterViewProtocols.standardProtocol();
    private Matcher<Root> rootMatcher = RootMatchers.DEFAULT;

    DataInteraction(Matcher<? extends Object> dataMatcher) {
        this.dataMatcher = (Matcher) Preconditions.checkNotNull(dataMatcher);
    }

    public DataInteraction onChildView(Matcher<View> childMatcher) {
        this.childViewMatcher = EspressoOptional.of((Matcher) Preconditions.checkNotNull(childMatcher));
        return this;
    }

    public DataInteraction inRoot(Matcher<Root> rootMatcher) {
        this.rootMatcher = (Matcher) Preconditions.checkNotNull(rootMatcher);
        return this;
    }

    public DataInteraction inAdapterView(Matcher<View> adapterMatcher) {
        this.adapterMatcher = (Matcher) Preconditions.checkNotNull(adapterMatcher);
        return this;
    }

    public DataInteraction atPosition(Integer atPosition) {
        this.atPosition = EspressoOptional.of((Integer) Preconditions.checkNotNull(atPosition));
        return this;
    }

    public DataInteraction usingAdapterViewProtocol(AdapterViewProtocol adapterViewProtocol) {
        this.adapterViewProtocol = (AdapterViewProtocol) Preconditions.checkNotNull(adapterViewProtocol);
        return this;
    }

    public ViewInteraction perform(ViewAction... actions) {
        return Espresso.onView(makeTargetMatcher()).inRoot(this.rootMatcher).perform(actions);
    }

    public ViewInteraction check(ViewAssertion assertion) {
        return Espresso.onView(makeTargetMatcher()).inRoot(this.rootMatcher).check(assertion);
    }

    private Matcher<View> makeTargetMatcher() {
        DisplayDataMatcher displayDataMatcher = DisplayDataMatcher.displayDataMatcher(this.adapterMatcher, this.dataMatcher, this.rootMatcher, this.atPosition, this.adapterViewProtocol);
        return this.childViewMatcher.isPresent() ? Matchers.allOf(this.childViewMatcher.get(), ViewMatchers.isDescendantOfA(displayDataMatcher)) : displayDataMatcher;
    }

    public static final class DisplayDataMatcher extends TypeSafeMatcher<View> {
        private static final String TAG = "DisplayDataMatcher";

        @RemoteMsgField(order = 3)
        private final AdapterDataLoaderAction adapterDataLoaderAction;

        @RemoteMsgField(order = 0)
        private final Matcher<View> adapterMatcher;
        private final AdapterViewProtocol adapterViewProtocol;

        @RemoteMsgField(order = 2)
        private final Class<? extends AdapterViewProtocol> adapterViewProtocolClass;

        @RemoteMsgField(order = 1)
        private final Matcher<? extends Object> dataMatcher;

        @RemoteMsgConstructor
        DisplayDataMatcher(Matcher<View> adapterMatcher, Matcher<? extends Object> dataMatcher, Class<? extends AdapterViewProtocol> adapterViewProtocolClass, AdapterDataLoaderAction adapterDataLoaderAction) throws IllegalAccessException, InstantiationException {
            this(adapterMatcher, dataMatcher, RootMatchers.DEFAULT, adapterViewProtocolClass.cast(new ConstructorInvocation(adapterViewProtocolClass, null, new Class[0]).invokeConstructor(new Object[0])), adapterDataLoaderAction);
        }

        private DisplayDataMatcher(final Matcher<View> adapterMatcher, Matcher<? extends Object> dataMatcher, final Matcher<Root> rootMatcher, AdapterViewProtocol adapterViewProtocol, AdapterDataLoaderAction adapterDataLoaderAction) {
            this(adapterMatcher, dataMatcher, adapterViewProtocol, adapterDataLoaderAction, new Function<AdapterDataLoaderAction, ViewInteraction>() { // from class: androidx.test.espresso.DataInteraction.DisplayDataMatcher.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
                public ViewInteraction apply(AdapterDataLoaderAction adapterDataLoaderAction2) {
                    return Espresso.onView(adapterMatcher).inRoot(rootMatcher).perform(adapterDataLoaderAction2);
                }
            });
        }

        DisplayDataMatcher(Matcher<View> adapterMatcher, Matcher<? extends Object> dataMatcher, AdapterViewProtocol adapterViewProtocol, AdapterDataLoaderAction adapterDataLoaderAction, Function<AdapterDataLoaderAction, ViewInteraction> loadDataFunction) {
            this.adapterMatcher = (Matcher) Preconditions.checkNotNull(adapterMatcher);
            this.dataMatcher = (Matcher) Preconditions.checkNotNull(dataMatcher);
            this.adapterViewProtocol = (AdapterViewProtocol) Preconditions.checkNotNull(adapterViewProtocol);
            this.adapterViewProtocolClass = adapterViewProtocol.getClass();
            this.adapterDataLoaderAction = (AdapterDataLoaderAction) Preconditions.checkNotNull(adapterDataLoaderAction);
            ((Function) Preconditions.checkNotNull(loadDataFunction)).apply(adapterDataLoaderAction);
        }

        public static DisplayDataMatcher displayDataMatcher(Matcher<View> adapterMatcher, Matcher<? extends Object> dataMatcher, Matcher<Root> rootMatcher, EspressoOptional<Integer> atPosition, AdapterViewProtocol adapterViewProtocol) {
            return new DisplayDataMatcher(adapterMatcher, dataMatcher, rootMatcher, adapterViewProtocol, new AdapterDataLoaderAction(dataMatcher, atPosition, adapterViewProtocol));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText(" displaying data matching: ");
            this.dataMatcher.describeTo(description);
            description.appendText(" within adapter view matching: ");
            this.adapterMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            Preconditions.checkState(this.adapterViewProtocol != null, "adapterViewProtocol cannot be null!");
            ViewParent parent = view.getParent();
            while (parent != null && !(parent instanceof AdapterView)) {
                parent = parent.getParent();
            }
            if (parent != null && this.adapterMatcher.matches(parent)) {
                EspressoOptional<AdapterViewProtocol.AdaptedData> dataRenderedByView = this.adapterViewProtocol.getDataRenderedByView((AdapterView) parent, view);
                if (dataRenderedByView.isPresent()) {
                    return dataRenderedByView.get().opaqueToken.equals(this.adapterDataLoaderAction.getAdaptedData().opaqueToken);
                }
            }
            return false;
        }
    }
}
