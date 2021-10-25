package net.siegerpg.siege.core.webstore.categories;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class WebstorePackage {
    private String[] args;

    public WebstorePackage(final String[] args) {this.args = args;}
    public WebstorePackage(){}

    private void setArgs(final String[] args) {this.args = args;}
    public String[] getArgs() {return this.args;}
    public void completePurchase(final UUID uuid){}

}
