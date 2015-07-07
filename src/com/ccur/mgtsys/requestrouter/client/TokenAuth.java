package com.ccur.mgtsys.requestrouter.client;

import java.util.List;

public class TokenAuth {

	private Boolean validate;
	private List<String> validate_expressions;

	public Boolean getValidate() {
		return validate;
	}

	public void setValidate(Boolean validate) {
		this.validate = validate;
	}

	public List<String> getValidateExpressions () {
		return validate_expressions;
	}

	public void setValidateExpressions (List<String> validExpressions) {
		this.validate_expressions = validExpressions;
	}

	@Override
	public String toString() {
		return "TokenAuth [validExpressions = "+validate_expressions+" , validate = "+validate+"]";
	}
}
