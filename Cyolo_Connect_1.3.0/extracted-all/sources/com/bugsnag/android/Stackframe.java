package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.JsonHelper;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: compiled from: Stackframe.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fB\u000f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u001d\b\u0010\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n¢\u0006\u0002\u0010\u0012J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001e\u00101\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001e\u00106\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lcom/bugsnag/android/Stackframe;", "Lcom/bugsnag/android/JsonStream$Streamable;", "method", "", "file", "lineNumber", "", "inProject", "", ResponseTypeValues.CODE, "", "columnNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Number;)V", "nativeFrame", "Lcom/bugsnag/android/NativeStackframe;", "(Lcom/bugsnag/android/NativeStackframe;)V", "json", "", "(Ljava/util/Map;)V", "getCode", "()Ljava/util/Map;", "setCode", "codeIdentifier", "getCodeIdentifier", "()Ljava/lang/String;", "setCodeIdentifier", "(Ljava/lang/String;)V", "getColumnNumber", "()Ljava/lang/Number;", "setColumnNumber", "(Ljava/lang/Number;)V", "getFile", "setFile", "frameAddress", "", "getFrameAddress", "()Ljava/lang/Long;", "setFrameAddress", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getInProject", "()Ljava/lang/Boolean;", "setInProject", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isPC", "setPC", "getLineNumber", "setLineNumber", "loadAddress", "getLoadAddress", "setLoadAddress", "getMethod", "setMethod", "symbolAddress", "getSymbolAddress", "setSymbolAddress", "type", "Lcom/bugsnag/android/ErrorType;", "getType", "()Lcom/bugsnag/android/ErrorType;", "setType", "(Lcom/bugsnag/android/ErrorType;)V", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Stackframe implements JsonStream.Streamable {
    private Map<String, String> code;
    private String codeIdentifier;
    private Number columnNumber;
    private String file;
    private Long frameAddress;
    private Boolean inProject;
    private Boolean isPC;
    private Number lineNumber;
    private Long loadAddress;
    private String method;
    private Long symbolAddress;
    private ErrorType type;

    public Stackframe(String str, String str2, Number number, Boolean bool) {
        this(str, str2, number, bool, null, null, 48, null);
    }

    public Stackframe(String str, String str2, Number number, Boolean bool, Map<String, String> map) {
        this(str, str2, number, bool, map, null, 32, null);
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final String getFile() {
        return this.file;
    }

    public final void setFile(String str) {
        this.file = str;
    }

    public final Number getLineNumber() {
        return this.lineNumber;
    }

    public final void setLineNumber(Number number) {
        this.lineNumber = number;
    }

    public final Boolean getInProject() {
        return this.inProject;
    }

    public final void setInProject(Boolean bool) {
        this.inProject = bool;
    }

    public final Map<String, String> getCode() {
        return this.code;
    }

    public final void setCode(Map<String, String> map) {
        this.code = map;
    }

    public final Number getColumnNumber() {
        return this.columnNumber;
    }

    public final void setColumnNumber(Number number) {
        this.columnNumber = number;
    }

    public final Long getFrameAddress() {
        return this.frameAddress;
    }

    public final void setFrameAddress(Long l) {
        this.frameAddress = l;
    }

    public final Long getSymbolAddress() {
        return this.symbolAddress;
    }

    public final void setSymbolAddress(Long l) {
        this.symbolAddress = l;
    }

    public final Long getLoadAddress() {
        return this.loadAddress;
    }

    public final void setLoadAddress(Long l) {
        this.loadAddress = l;
    }

    public final String getCodeIdentifier() {
        return this.codeIdentifier;
    }

    public final void setCodeIdentifier(String str) {
        this.codeIdentifier = str;
    }

    /* JADX INFO: renamed from: isPC, reason: from getter */
    public final Boolean getIsPC() {
        return this.isPC;
    }

    public final void setPC(Boolean bool) {
        this.isPC = bool;
    }

    public final ErrorType getType() {
        return this.type;
    }

    public final void setType(ErrorType errorType) {
        this.type = errorType;
    }

    public /* synthetic */ Stackframe(String str, String str2, Number number, Boolean bool, Map map, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, number, bool, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : number2);
    }

    public Stackframe(String str, String str2, Number number, Boolean bool, Map<String, String> map, Number number2) {
        this.method = str;
        this.file = str2;
        this.lineNumber = number;
        this.inProject = bool;
        this.code = map;
        this.columnNumber = number2;
    }

    public Stackframe(NativeStackframe nativeStackframe) {
        this(nativeStackframe.getMethod(), nativeStackframe.getFile(), nativeStackframe.getLineNumber(), null, null, null, 32, null);
        this.frameAddress = nativeStackframe.getFrameAddress();
        this.symbolAddress = nativeStackframe.getSymbolAddress();
        this.loadAddress = nativeStackframe.getLoadAddress();
        this.codeIdentifier = nativeStackframe.getCodeIdentifier();
        this.isPC = nativeStackframe.getIsPC();
        this.type = nativeStackframe.getType();
    }

    public Stackframe(Map<String, ? extends Object> map) {
        Object obj = map.get("method");
        this.method = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("file");
        this.file = obj2 instanceof String ? (String) obj2 : null;
        this.lineNumber = JsonHelper.INSTANCE.jsonToLong(map.get("lineNumber"));
        Object obj3 = map.get("inProject");
        this.inProject = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        Object obj4 = map.get("columnNumber");
        this.columnNumber = obj4 instanceof Number ? (Number) obj4 : null;
        this.frameAddress = JsonHelper.INSTANCE.jsonToLong(map.get("frameAddress"));
        this.symbolAddress = JsonHelper.INSTANCE.jsonToLong(map.get("symbolAddress"));
        this.loadAddress = JsonHelper.INSTANCE.jsonToLong(map.get("loadAddress"));
        Object obj5 = map.get("codeIdentifier");
        this.codeIdentifier = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = map.get("isPC");
        this.isPC = obj6 instanceof Boolean ? (Boolean) obj6 : null;
        Object obj7 = map.get(ResponseTypeValues.CODE);
        this.code = obj7 instanceof Map ? (Map) obj7 : null;
        Object obj8 = map.get("type");
        String str = obj8 instanceof String ? (String) obj8 : null;
        this.type = str != null ? ErrorType.INSTANCE.fromDescriptor(str) : null;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws IOException {
        writer.beginObject();
        writer.name("method").value(this.method);
        writer.name("file").value(this.file);
        writer.name("lineNumber").value(this.lineNumber);
        Boolean bool = this.inProject;
        if (bool != null) {
            writer.name("inProject").value(bool.booleanValue());
        }
        writer.name("columnNumber").value(this.columnNumber);
        Long l = this.frameAddress;
        if (l != null) {
            l.longValue();
            writer.name("frameAddress").value(JsonHelper.INSTANCE.ulongToHex(getFrameAddress()));
        }
        Long l2 = this.symbolAddress;
        if (l2 != null) {
            l2.longValue();
            writer.name("symbolAddress").value(JsonHelper.INSTANCE.ulongToHex(getSymbolAddress()));
        }
        Long l3 = this.loadAddress;
        if (l3 != null) {
            l3.longValue();
            writer.name("loadAddress").value(JsonHelper.INSTANCE.ulongToHex(getLoadAddress()));
        }
        String str = this.codeIdentifier;
        if (str != null) {
            writer.name("codeIdentifier").value(str);
        }
        Boolean bool2 = this.isPC;
        if (bool2 != null) {
            writer.name("isPC").value(bool2.booleanValue());
        }
        ErrorType errorType = this.type;
        if (errorType != null) {
            writer.name("type").value(errorType.getDesc());
        }
        Map<String, String> map = this.code;
        if (map != null) {
            writer.name(ResponseTypeValues.CODE);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.beginObject();
                writer.name(entry.getKey());
                writer.value(entry.getValue());
                writer.endObject();
            }
        }
        writer.endObject();
    }
}
