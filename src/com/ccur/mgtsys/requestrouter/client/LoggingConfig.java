package com.ccur.mgtsys.requestrouter.client;

public class LoggingConfig {
	
	  private Boolean logging;

	    public Boolean isLogging () {
	        return logging;
	    }

	    public void setLogging (Boolean logging) {
	        this.logging = logging;
	    }

	    @Override
	    public String toString() {
	        return "Logging [logging = "+logging+"]";
	    }
	
}
