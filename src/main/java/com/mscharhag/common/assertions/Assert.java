package com.mscharhag.common.assertions;


import java.util.function.Supplier;

public abstract class Assert {

    private Assert() {
        // no instance creation -> use static methods
    }

    /**
     * Assert a boolean expression, throwing an {@code AssertionError}
     * if the expression evaluates to {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0);</pre>
     * @param expression a boolean expression
     * @throws AssertionError if {@code expression} is {@code false}
     */
    public static boolean isTrue(boolean expression) {
        return isTrue(expression, "[Assertion failed] - expression must be true");
    }

    /**
     * Assert a boolean expression, throwing an {@code AssertionError}
     * if the expression evaluates to {@code false}.
     * <pre class="code">Assert.isTrue(value, "value");</pre>
     * @param expression a boolean expression
     * @param name the (field, expression, etc.) name that is added to the exception message.
     * @throws AssertionError if {@code expression} is {@code false}
     */
    public static boolean isTrue(boolean expression, String name) {
        if (!expression) {
            throw new AssertionError("[Assertion failed] - " + name + " must be true");
        }
        return true;
    }

    /**
     * Assert a boolean expression, throwing an {@code AssertionError}
     * if the expression evaluates to {@code false}.
     * <pre class="code">
     * Assert.isTrue(i &gt; 0, () -&gt; "The value '" + i + "' must be greater than zero");
     * </pre>
     * @param expression a boolean expression
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws AssertionError if {@code expression} is {@code false}
     */
    public static boolean isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new AssertionError(nullSafeGet(messageSupplier));
        }
        return true;
    }

    /**
     * Assert that an object is not {@code null}.
     * <pre class="code">Assert.notNull(obj);</pre>
     * @param object the object to check
     * @throws AssertionError if the object is {@code null}
     */
    public static <T> T notNull(T object) {
        return notNull(object, "[Assertion failed] - The given object must not be null");
    }

    /**
     * Assert that an object is not {@code null}.
     * <pre class="code">Assert.notNull(obj, "obj");</pre>
     * @param object the object to check
     * @param name the (field, expression, etc.) name that is added to the exception message.
     * @throws AssertionError if the object is {@code null}
     */
    public static <T> T notNull(T object, String name) {
        if (object == null) {
            throw new AssertionError("[Assertion failed] - " + name + " must be null");
        }
        return object;
    }

    /**
     * Assert that an object is not {@code null}.
     * <pre class="code">
     * Assert.notNull(clazz, () -&gt; "The class '" + clazz.getName() + "' must not be null");
     * </pre>
     * @param object the object to check
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws AssertionError if the object is {@code null}
     * @since 5.0
     */
    public static <T> T notNull(T object, Supplier<String> messageSupplier) {
        if (object == null) {
            throw new AssertionError(nullSafeGet(messageSupplier));
        }
        return object;
    }

    /**
     * Assert a boolean expression, throwing an {@code AssertionError}
     * if the expression evaluates to {@code false}.
     * <pre class="code">Assert.state(id == null, "The id property must not already be initialized");</pre>
     * @param expression a boolean expression
     * @param message the exception message to use if the assertion fails
     * @throws AssertionError if {@code expression} is {@code false}
     */
    public static boolean state(boolean expression, String message) {
        if (!expression) {
            throw new AssertionError("[Assertion failed] - " + message);
        }
        return true;
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalStateException}
     * if the expression evaluates to {@code false}.
     * <pre class="code">
     * Assert.state(id == null,
     *     () -&gt; "ID for " + entity.getName() + " must not already be initialized");
     * </pre>
     * @param expression a boolean expression
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws AssertionError if {@code expression} is {@code false}
     */
    public static boolean state(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new AssertionError(nullSafeGet(messageSupplier));
        }
        return true;
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">Assert.notEmpty(name);</pre>
     * @param text the String to check
     * @throws AssertionError if the text is empty
     */
    public static String notEmpty(String text) {
        return notEmpty(text, "[Assertion failed] - text must not be null or empty");
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">Assert.notEmpty(name, "name");</pre>
     * @param text the String to check
     * @param name the (field, expression, etc.) name that is added to the exception message.
     * @throws AssertionError if the text is empty
     */
    public static String notEmpty(String text, String name) {
        if (text == null || text.isEmpty()) {
            throw new AssertionError("[Assertion failed] - " + name + " must not be null or empty");
        }
        return text;
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">
     * Assert.notEmpty(name, () -&gt; "Name for account '" + account.getId() + "' must not be empty");
     * </pre>
     * @param text the String to check
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws AssertionError if the text is empty
     */
    public static String notEmpty(String text, Supplier<String> messageSupplier) {
        if (text == null || text.isEmpty()) {
            throw new AssertionError(nullSafeGet(messageSupplier));
        }
        return text;
    }

    private static String nullSafeGet(Supplier<String> messageSupplier) {
        return "[Assertion failed] - " + (messageSupplier != null ? messageSupplier.get() : "No details provided");
    }

}

