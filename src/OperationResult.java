public class OperationResult {
	private Boolean isSuccess;
	private String errorMsg;

	public OperationResult(Boolean isSuccess, String errorMsg) {
		this.isSuccess = isSuccess;
		this.errorMsg = errorMsg;
	}

	public Boolean getSuccess() {
		return isSuccess;
	}

	public void setSuccess(Boolean success) {
		isSuccess = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
