

@SpringBootTest
public class CommandControllerCreateLeadTest {

	@MockBean
	private EventStore eventStore;

	private CommandController testSubject;

	@BeforeEach
	void setup() {
		testSubject = new CommandController(eventStore);
	}

	@Test
	void testCrateLeadCreatesGeneratedValue() {
		CreateLead createLeadCommand = new CreateLead("Valid Name");
		Mockito.doNothing().when(this.eventStore).save(any(LeadCreated.class));
		testSubject.crateLead(createLeadCommand);
		Mockito.verify(this.eventStore, times(1)).save(any(LeadCreated.class));
	}

	@Test
	void testCrateLeadNullParameter() {
		assertThrows(NullPointerException.class, () -> {
			testSubject.crateLead(null);
		});
	}

	@Test
	void testCrateLeadInvalidParameter() {
		CreateLead createLeadCommand = new CreateLead(""); // invalid name
		assertThrows(IllegalArgumentException.class, () -> {
			testSubject.crateLead(createLeadCommand);
		});
	}

}
