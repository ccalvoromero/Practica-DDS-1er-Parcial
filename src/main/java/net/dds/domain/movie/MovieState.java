package net.dds.domain.movie;

public enum MovieState {
    AVAILABLE, RENTED, SOLD;

    public int id() {
        return this.ordinal() + 1;
    }

}