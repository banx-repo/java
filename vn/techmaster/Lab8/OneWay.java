package vn.techmaster.Lab8;

public class OneWay extends Ticket {
    private Gate _entry;
    private Gate _destination;

    Gate getEntry() {
        return this._entry;
    }

    Gate getDestination() {
        return this._destination;
    }

    OneWay(Gate entry, Gate destination) {
        this._entry = entry;
        this._destination = destination;
    }
}
