package net.siegerpg.siege.core.crates.crates;

public class NormalCrate extends CosmeticCrate {
    /**
     * A key is needed to pick a random item from the drop table's list using each item's weight
     */
    public NormalCrate() {
        key = null;
        dropTable = null;
    }
}
