package vn.techmaster.lab8;

public class Gate {
    private static int count = 0;
    private int id;
    private String name;
    private boolean open;

    // static
    public static int total() {
        return count;
    }

    // get
    private int newId() {
        return count++;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOpen() {
        return this.open;
    }

    // set
    private void setId(int id) {
        this.id = id;
    }

    private void setOpen(boolean open) {
        this.open = open;
    }

    public void open() {
        this.setOpen(true);
    }

    public void close() {
        this.setOpen(false);
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructor
    Gate(String name) {
        this.setId(this.newId());
        this.setName(name);
    }

    // method
    @Override
    public String toString() {
        return "Gate " + this.getName() + " is " + this.isOpen();
    }

    public void enter(Ticket ticket) {
        if (ticket.isValid()) {
            open();
            ticket.setOrigin(this);
        } else {
            close();
        }
    }

    public void exit(Ticket ticket) {
        Gate origin = ticket.getOrigin();

        if (origin != null) {
            
        }
    }
}
