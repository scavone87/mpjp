package m2ex;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class S08Test {

	@Test
	void binaryAddition() {
		String actual = S08.binarySum("10", "11");
		assertThat(actual, is("101"));
	}
	
	@Test
	void mergeSorted() {
		int[] left = new int[] {1,2,4,6,7,8,9};
		int[] right = new int[] {3,4,4,6};
		int[] expected = new int[] {1,2,3,4,4,4,6,6,7,8,9};
		int[] actual = S08.mergeSorted(left, right);
		assertThat(actual, is(expected));
	}
	
	@Test
	void findSingleInSortedArray() {
		int[] values = new int[] {1,1,2,2,3,3,4,5,5,6,6};
		int actual = S08.getSingle(values);
		assertThat(actual, is(4));
	}
	
	@Test
	void isNotOnlyUnique() {
		boolean actual = S08.hasOnlyUnique("Hello");
		assertThat(actual, is(false));
	}
	
	@Test
	void isOnlyUnique() {
		boolean actual = S08.hasOnlyUnique("Helo");
		assertThat(actual, is(true));
	}
}