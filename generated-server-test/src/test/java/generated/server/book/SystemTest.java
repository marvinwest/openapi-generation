package generated.server.book;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SystemTest {

	protected BookSystem bookSystem;
	
	@BeforeAll
	void setupSystem() {
		this.bookSystem = new BookSystem();
	}
	
	@AfterAll
	void cleanupSystem() {
		this.bookSystem.close();
	}
}
