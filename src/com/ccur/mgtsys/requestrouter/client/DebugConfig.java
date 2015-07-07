package com.ccur.mgtsys.requestrouter.client;

public class DebugConfig {
	
	  private boolean debug;

	    public boolean isDebug () {
	        return debug;
	    }

	    public void setDebug (boolean debug) {
	        this.debug = debug;
	    }

	    @Override
	    public String toString() {
	        return "Debug [debug = "+debug+"]";
	    }
	
}
