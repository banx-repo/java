package vn.techmaster.lab8;

public class OneWay extends Ticket {
    private Gate _entry;
    private Gate _destination;

    private void setEntry(Gate entry) {
        this._entry = entry;
    }

    private void setDestination(Gate destination) {
        this._destination = destination;
    }

    Gate getEntry() {
        return this._entry;
    }

    Gate getDestination() {
        return this._destination;
    }

    OneWay(Gate entry, Gate destination) {
        this.setEntry(entry);
        this.setDestination(destination);
    }
}
