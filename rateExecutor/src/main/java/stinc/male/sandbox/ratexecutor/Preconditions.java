package stinc.male.sandbox.ratexecutor;

import java.util.Locale;

final class Preconditions {
	private static final String format(final String format, final Object... args) {
		return String.format(Locale.ROOT, format, args);
	}

	static final void checkNotNull(
			final Object argument,
			final String paramName) throws NullPointerException {
		if (argument == null) {
			throw new NullPointerException(format("The argument %s must not be null", paramName));
		}
	}

	static final void checkArgument(
			final boolean checkArgumentExpression,
			final String paramName,
			final String paramRestrictionDescription) throws IllegalArgumentException {
		if (!checkArgumentExpression) {
			throw new IllegalArgumentException(
					format("The argument %s is illegal. %s", paramName, paramRestrictionDescription));
		}
	}

	private Preconditions() {
		throw new UnsupportedOperationException("The class isn't designed to be instantiated");
	}
}