package net.sahet.vatinfo.exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://www.infoworld.com/article/3188289/java-9s-other-new-enhancements-part-5-stack-walking-api.html

/**
 * Understanding a design curiosity Each thread has its own execution stack. You
 * might think of this stack as a stable data structure that the JVM modifies
 * only at the top, by adding or removing a single frame each time a method is
 * entered or exited. In reality, the JVM can restructure a thread's stack any
 * time it sees fit, to improve performance.
 *
 */
class JavaDemoStackWalker {

	// The stack is a Last-In-First-Out (LIFO) data structure.
	public static void main(String[] args) {
		// Before Java 9
		/**
		 * Unfortunately, this approach to obtaining a stack trace is rather costly and
		 * impacts performance. The Java Virtual Machine (JVM) eagerly captures a
		 * snapshot of the entire stack (except for hidden stack frames), even when you
		 * only need the first few frames.
		 * 
		 * Till Java 8, StackTraceElement represents a stack frame. To get complete
		 * stack, you had to use Thread.getStackTrace() and Throwable.getStackTrace().
		 * It returned an array of StackTraceElement which you can iterate to get
		 * required information.
		 */
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		System.out.println(Arrays.deepToString(stackTrace));

		// Prints the details of all stack frames of the current thread
		// https://howtodoinjava.com/java9/java9-new-features-enhancements/#stack-walking
		StackWalker.getInstance().forEach(System.out::println);
		System.out.println("---");

		a();
	}

	public static void a() {
		b();
	}

	public static void b() {
		c();
	}

	public static void c() {
		StackWalker sw = StackWalker.getInstance();
		List<StackWalker.StackFrame> frames;

		frames = sw.walk(frames_ -> frames_.collect(Collectors.toList()));
		frames.forEach(System.out::println);
		System.out.println();

		long numFrames = sw.walk(frames_ -> frames_.count());
		System.out.printf("Total number of frames: %d%n%n", numFrames);

		frames = sw.walk(frames_ -> frames_.limit(2).collect(Collectors.toList()));
		frames.forEach(System.out::println);
	}
}