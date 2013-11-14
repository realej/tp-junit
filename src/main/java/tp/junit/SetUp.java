package tp.junit;

import java.util.ArrayList;

public abstract class SetUp {

    ArrayList<Object> attributes;

    public SetUp() {
        attributes = new ArrayList<Object>();
    }

    public void addAttribute(Object atributo) {
        attributes.add(atributo);
    }

    public Object getAttribute(int posicion) {
        return attributes.get(posicion);
    }

    public ArrayList<Object> getArrayList() {
        return attributes;
    }

    public void tearDown() {
        if (attributes != null) {
            attributes.clear();
            addAttributes();
        }
    }

    public abstract void addAttributes();
}
