package vn.techmaster.Lab8;

public class Gate {
    private static int _count = 0;
    private int _id;
    private String _name;
    private boolean _open;

    static int total() {
        return _count;
    }

    private int _newId() {
        return _count++;
    }

    private void setOpen(boolean open) {
        this._open = open;
    }

    int getId() {
        return this._id;
    }

    String getName() {
        return this._name;
    }

    boolean isOpen() {
        return this._open;
    }

    void open() {
        this.setOpen(true);
    }

    void close() {
        this.setOpen(false);
    }

    Gate(String name) {
        this._name = name;
        this._id = this._newId();
    }
}
