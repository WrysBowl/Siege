package net.siegerpg.siege.core.webstore.categories;

import java.util.UUID;

public class WebstorePackage {

	private String[] args;

	public WebstorePackage(String[] args) {

		this.args = args;
	}

	public WebstorePackage() {

	}

	public String[] getArgs() {

		return args;
	}

	public void setArgs(String[] args) {

		this.args = args;
	}

	public void completePurchase(UUID uuid) {

	}

}
