package stinc.male.sandbox.ratexecutor;

import java.time.Duration;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class RingBufferRateMeter extends AbstractRingBufferRateMeter<SequentialLongArray> {
  private static final ConcurrentRingBufferRateMeterConfig defaultConfigInstance = ConcurrentRingBufferRateMeterConfig.newBuilder()
      .setTicksCounterSupplier(LongTicksCounter::new)
      .build();

  /**
   * @return A reasonable configuration.
   */
  public static final RateMeterConfig defaultConfig() {
    return defaultConfigInstance;
  }

  /**
   * @param startNanos Starting point that is used to calculate elapsed nanoseconds.
   * @param samplesInterval Size of the samples window.
   * @param config Additional configuration parameters.
   */
  public RingBufferRateMeter(
      final long startNanos,
      final Duration samplesInterval,
      final RateMeterConfig config) {
    super(
        startNanos,
        samplesInterval,
        ConcurrentRingBufferRateMeterConfig.newBuilder(config)
            .setStrictTick(false)
            .build(),
        SequentialLongArray::new,
        true);
  }
}