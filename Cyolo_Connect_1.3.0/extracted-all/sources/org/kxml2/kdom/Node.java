package org.kxml2.kdom;

import java.io.IOException;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class Node {
    public static final int CDSECT = 5;
    public static final int COMMENT = 9;
    public static final int DOCDECL = 10;
    public static final int DOCUMENT = 0;
    public static final int ELEMENT = 2;
    public static final int ENTITY_REF = 6;
    public static final int IGNORABLE_WHITESPACE = 7;
    public static final int PROCESSING_INSTRUCTION = 8;
    public static final int TEXT = 4;
    protected Vector children;
    protected StringBuffer types;

    public void addChild(int i, int i2, Object obj) {
        obj.getClass();
        if (this.children == null) {
            this.children = new Vector();
            this.types = new StringBuffer();
        }
        if (i2 == 2) {
            if (!(obj instanceof Element)) {
                throw new RuntimeException("Element obj expected)");
            }
            ((Element) obj).setParent(this);
        } else if (!(obj instanceof String)) {
            throw new RuntimeException("String expected");
        }
        this.children.insertElementAt(obj, i);
        this.types.insert(i, (char) i2);
    }

    public void addChild(int i, Object obj) {
        addChild(getChildCount(), i, obj);
    }

    public Element createElement(String str, String str2) {
        Element element = new Element();
        if (str == null) {
            str = "";
        }
        element.namespace = str;
        element.name = str2;
        return element;
    }

    public Object getChild(int i) {
        return this.children.elementAt(i);
    }

    public int getChildCount() {
        Vector vector = this.children;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public Element getElement(int i) {
        Object child = getChild(i);
        if (child instanceof Element) {
            return (Element) child;
        }
        return null;
    }

    public Element getElement(String str, String str2) {
        int iIndexOf = indexOf(str, str2, 0);
        int iIndexOf2 = indexOf(str, str2, iIndexOf + 1);
        if (iIndexOf == -1 || iIndexOf2 != -1) {
            throw new RuntimeException(new StringBuffer("Element {").append(str).append("}").append(str2).append(iIndexOf == -1 ? " not found in " : " more than once in ").append(this).toString());
        }
        return getElement(iIndexOf);
    }

    public String getText(int i) {
        if (isText(i)) {
            return (String) getChild(i);
        }
        return null;
    }

    public int getType(int i) {
        return this.types.charAt(i);
    }

    public int indexOf(String str, String str2, int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            Element element = getElement(i);
            if (element != null && str2.equals(element.getName()) && (str == null || str.equals(element.getNamespace()))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean isText(int i) {
        int type = getType(i);
        return type == 4 || type == 7 || type == 5;
    }

    /* JADX WARN: Found duplicated region for block: B:20:0x0046  */
    public void parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z = false;
        do {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 1) {
                z = true;
            } else if (eventType == 2) {
                Element elementCreateElement = createElement(xmlPullParser.getNamespace(), xmlPullParser.getName());
                addChild(2, elementCreateElement);
                elementCreateElement.parse(xmlPullParser);
            } else if (eventType != 3) {
                if (xmlPullParser.getText() != null) {
                    if (eventType == 6) {
                        eventType = 4;
                    }
                    addChild(eventType, xmlPullParser.getText());
                } else if (eventType == 6 && xmlPullParser.getName() != null) {
                    addChild(6, xmlPullParser.getName());
                }
                xmlPullParser.nextToken();
            } else {
                z = true;
            }
        } while (!z);
    }

    public void removeChild(int i) {
        this.children.removeElementAt(i);
        int length = this.types.length() - 1;
        while (i < length) {
            StringBuffer stringBuffer = this.types;
            int i2 = i + 1;
            stringBuffer.setCharAt(i, stringBuffer.charAt(i2));
            i = i2;
        }
        this.types.setLength(length);
    }

    public void write(XmlSerializer xmlSerializer) throws IOException {
        writeChildren(xmlSerializer);
        xmlSerializer.flush();
    }

    public void writeChildren(XmlSerializer xmlSerializer) throws IOException {
        Vector vector = this.children;
        if (vector == null) {
            return;
        }
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            int type = getType(i);
            Object objElementAt = this.children.elementAt(i);
            switch (type) {
                case 2:
                    ((Element) objElementAt).write(xmlSerializer);
                    break;
                case 3:
                default:
                    throw new RuntimeException(new StringBuffer("Illegal type: ").append(type).toString());
                case 4:
                    xmlSerializer.text((String) objElementAt);
                    break;
                case 5:
                    xmlSerializer.cdsect((String) objElementAt);
                    break;
                case 6:
                    xmlSerializer.entityRef((String) objElementAt);
                    break;
                case 7:
                    xmlSerializer.ignorableWhitespace((String) objElementAt);
                    break;
                case 8:
                    xmlSerializer.processingInstruction((String) objElementAt);
                    break;
                case 9:
                    xmlSerializer.comment((String) objElementAt);
                    break;
                case 10:
                    xmlSerializer.docdecl((String) objElementAt);
                    break;
            }
        }
    }
}
