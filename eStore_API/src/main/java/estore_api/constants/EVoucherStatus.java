package estore_api.constants;

import lombok.ToString;

@ToString
public enum EVoucherStatus {

	VALID(0), USED(1), EXPIRED(2);

	public final int status;

	EVoucherStatus(int status) {
		this.status = status;
	}
}
