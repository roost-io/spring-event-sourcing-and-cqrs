

package com.baeldung.write.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import javax.validation.constraints.NotNull;
import com.baeldung.infra.command.Command;

public class CreateLeadHashCodeTest {

	private final String name = "CreateLead";

	@Test
	public void testHashCodeWithNonNullName() {
		CreateLead createLead = new CreateLead();
		createLead.setName(this.name);
		int expectedHash = 31 + this.name.hashCode();
		Assertions.assertEquals(expectedHash, createLead.hashCode());
	}

	@Test
	public void testHashCodeWithNullName() {
		CreateLead createLead = new CreateLead();
		createLead.setName(null);
		int expectedHash = 31;
		Assertions.assertEquals(expectedHash, createLead.hashCode());
	}

	@Test
	public void testHashCodeConsistency() {
		CreateLead createLead = new CreateLead();
		createLead.setName(this.name);
		int expectedHash = createLead.hashCode();
		for (int i = 0; i < 10; i++) {
			Assertions.assertEquals(expectedHash, createLead.hashCode());
		}
	}

	@Test
	public void testHashCodeForEqualObjects() {
		CreateLead createLead1 = new CreateLead();
		CreateLead createLead2 = new CreateLead();
		createLead1.setName(this.name);
		createLead2.setName(this.name);
		Assertions.assertEquals(createLead1.hashCode(), createLead2.hashCode());
	}

}
