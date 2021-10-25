package net.siegerpg.siege.core.webstore.categories;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class WebstorePackage {
    private String[] args;

    public WebstorePackage(String[] args) {this.args = args;}
    public WebstorePackage(){}

    public void setArgs(String[] args) {this.args = args;}
    public String[] getArgs() {return args;}
    public void completePurchase(UUID uuid){}

}
