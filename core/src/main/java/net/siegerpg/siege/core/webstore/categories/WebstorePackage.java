package net.siegerpg.siege.core.webstore.categories;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class WebstorePackage {
    private List<String> args;

    public WebstorePackage(List<String> args) {this.args = args;}
    public WebstorePackage(){}

    private void setArgs(List<String> args) {this.args = args;}
    public List<String> getArgs() {return args;}
    public void completePurchase(UUID uuid){}

}
