package stinc.male.sandbox.ratexecutor;

import java.util.concurrent.atomic.LongAdder;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class LongAdderTicksCounter extends AbstractTicksCounter {
  private final LongAdder adder;

  LongAdderTicksCounter(final long initialValue) {
    adder = new LongAdder();
    adder.add(initialValue);
  }

  @Override
  public final long addAndGet(final long delta) {
    adder.add(delta);
    return adder.sum();
  }

  @Override
  public final void add(final long delta) {
    adder.add(delta);
  }

  @Override
  public final long get() {
    return adder.sum();
  }
}