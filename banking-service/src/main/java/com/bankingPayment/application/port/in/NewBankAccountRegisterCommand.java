package com.bankingPayment.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class NewBankAccountRegisterCommand {

	@NotNull
	private String bankName;
	@NotNull
	private String memberShipId;
	@NotNull
	@NotBlank
	private String bankAccountNumber;
	@NotNull
	@NotBlank
	private boolean accountStatus;

	public NewBankAccountRegisterCommand(String bankName, String memberShipId, String bankAccountNumber,
		boolean accountStatus) {
		this.bankName = bankName;
		this.memberShipId = memberShipId;
		this.bankAccountNumber = bankAccountNumber;
		this.accountStatus = accountStatus;
	}
}

