package vn.techmaster.Lab8;

public class Ticket {
    private static int _count = 0;
    private int _id;
    private boolean _active;

    int total() {
        return _count;
    }

    private int _newId() {
        return _count++;
    }

    private void setActive(boolean active) {
        this._active = active;
    }

    int getId() {
        return this._id;
    }

    boolean isActive() {
        return this._active;
    }

    void deactive() {
        this.setActive(false);
    }

    void active() {
        this.setActive(true);
    }

    Ticket() {
        this._id = this._newId();
    }
}
