

package com.baeldung.write.commands;

import java.util.UUID;
import com.baeldung.infra.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LeadClickOnPromotionalLinkHashCodeTest {

	private LeadClickOnPromotionalLink command;

	@BeforeEach
	void setUp() {
		command = new LeadClickOnPromotionalLink();
	}

	@Test
	void testHashCodeWithNullIdOfLead() {
		command.setIdOfLead(null);
		int expectedHashCode = 1;
		int actualHashCode = command.hashCode();
		assertEquals(expectedHashCode, actualHashCode, "Hash code does not match for null idOfLead");
	}

	@Test
	void testHashCodeWithNonNullIdOfLead() {
		UUID uuid = UUID.randomUUID();
		command.setIdOfLead(uuid);
		int expectedHashCode = 31 + uuid.hashCode();
		int actualHashCode = command.hashCode();
		assertEquals(expectedHashCode, actualHashCode, "Hash code does not match for non-null idOfLead");
	}

	@Test
	void testHashCodeConsistency() {
		UUID uuid = UUID.randomUUID();
		command.setIdOfLead(uuid);
		int hashCode1 = command.hashCode();
		int hashCode2 = command.hashCode();
		assertEquals(hashCode1, hashCode2, "Hash codes are not consistent for the same instance");
	}
	
}
