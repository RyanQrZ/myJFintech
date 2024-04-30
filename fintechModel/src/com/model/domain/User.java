package com.model.domain;

import java.util.UUID;

import com.model.domain.enums.ErrorEnum;
import com.model.domain.enums.UserTypeEnum;
import com.model.domain.exceptions.IdNumberException;

/*
 *
 *
 * This entity represents a generic client
 * It will be instantiate when client use the system
 *
 *
 */

public class User {

	private UUID acID = UUID.randomUUID();
	private String email, password, name;
	private UserTypeEnum type;
	private IdNumber idNumber;

	public User(String id, String name, String passwd, String email, String type)
			throws IdNumberException {

			if (type == "personal") {
				this.type = UserTypeEnum.COMMON;

			} else if (type == "enterprise" && id.replaceAll("[^0-9]", "").length() == 14) {
				this.type = UserTypeEnum.SELLER;

			}

			this.idNumber = new IdNumber(id);
			this.name = name;
			this.password = passwd;
			this.email = email;

	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getUserID() {
		return idNumber.getValue();
	}

	// This method returns serial number of user in system

	private UUID getAccountID() {
		return acID;
	}
	
	// This method should be protected

	public Enum getType() {
		return type;
	}

}
