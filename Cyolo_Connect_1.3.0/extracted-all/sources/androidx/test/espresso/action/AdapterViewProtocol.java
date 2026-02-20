package androidx.test.espresso.action;

import android.database.Cursor;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public interface AdapterViewProtocol {

    public interface DataFunction {
        Object getData();
    }

    Iterable<AdaptedData> getDataInAdapterView(AdapterView<? extends Adapter> adapterView);

    EspressoOptional<AdaptedData> getDataRenderedByView(AdapterView<? extends Adapter> adapterView, View descendantView);

    boolean isDataRenderedWithinAdapterView(AdapterView<? extends Adapter> adapterView, AdaptedData adaptedData);

    void makeDataRenderedWithinAdapterView(AdapterView<? extends Adapter> adapterView, AdaptedData data);

    public static class AdaptedData {

        @Deprecated
        public final Object data;
        private final DataFunction dataFunction;
        public final Object opaqueToken;

        public Object getData() {
            return this.dataFunction.getData();
        }

        public String toString() {
            Object data = getData();
            String name = data == null ? "null" : data.getClass().getName();
            if (data instanceof Cursor) {
                data = HumanReadables.describe((Cursor) data);
            }
            return String.format(Locale.ROOT, "Data: %s (class: %s) token: %s", data, name, this.opaqueToken);
        }

        private AdaptedData(Object data, Object opaqueToken, DataFunction dataFunction) {
            this.data = data;
            this.opaqueToken = Preconditions.checkNotNull(opaqueToken);
            this.dataFunction = (DataFunction) Preconditions.checkNotNull(dataFunction);
        }

        public static class Builder {
            private Object data;
            private DataFunction dataFunction;
            private Object opaqueToken;

            public Builder withDataFunction(DataFunction dataFunction) {
                this.dataFunction = dataFunction;
                return this;
            }

            public Builder withData(Object data) {
                this.data = data;
                return this;
            }

            public Builder withOpaqueToken(Object opaqueToken) {
                this.opaqueToken = opaqueToken;
                return this;
            }

            public AdaptedData build() {
                DataFunction dataFunction = this.dataFunction;
                if (dataFunction != null) {
                    this.data = dataFunction.getData();
                } else {
                    this.dataFunction = new DataFunction() { // from class: androidx.test.espresso.action.AdapterViewProtocol.AdaptedData.Builder.1
                        @Override // androidx.test.espresso.action.AdapterViewProtocol.DataFunction
                        public Object getData() {
                            return Builder.this.data;
                        }
                    };
                }
                return new AdaptedData(this.data, this.opaqueToken, this.dataFunction);
            }
        }
    }
}
