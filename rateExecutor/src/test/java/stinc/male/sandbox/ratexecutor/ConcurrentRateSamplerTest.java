package stinc.male.sandbox.ratexecutor;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class ConcurrentRateSamplerTest {
	public ConcurrentRateSamplerTest() {
	}

	@Test
	public final void getStartNanos() {
		final long start = 314159;
		assertEquals(start, new ConcurrentRateSampler(start, Duration.ZERO).getStartNanos());
	}

	@Test
	public final void test() {
		final ConcurrentRateSampler rs = new ConcurrentRateSampler(0, Duration.ofSeconds(1));
		rs.tick(2, TimeUnit.SECONDS.toNanos(1));
		assertDoubleEquals(2 / 3, rs.rate(3));
	}

	private static final void assertDoubleEquals(final double d1, final double d2) {
		assertTrue(d1 - d2 <= 0.0000000001);
	}
}