package com.scottlinenberger.utils;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;

import org.junit.Test;

public class ArrayScramblerTest {

	@Test
	public void arrayScrambler_swapHalves_evenNumberOfItems_shouldSwapTopAndBottomHalves() {
		Object[] array = new Object[] {
				1,
				2,
				3,
				4,
		};
		
		Object[] result = ArrayScrambler.swapHalves(array);
//		printArray(result);
		
		/*
		 * Halves should be swapped
		 * 1, 2, 3, 4
		 * Should become
		 * 3, 4, 1, 2
		 */
		
		assertEquals(
			3,
			result[0]
		);
		
		assertEquals(
			4,
			result[1]
		);
		
		assertEquals(
			1,
			result[2]
		);
		
		assertEquals(
			2,
			result[3]
		);
	}
	
	@Test
	public void arrayScrambler_swapHalves_oddNumberOfItems_shouldSwapTopAndBottomHalves() {
		Object[] array = new Object[] {
				1,
				2,
				3,
				4,
				5,
		};
		
		Object[] result = ArrayScrambler.swapHalves(array);
		
		/*
		 * Halves should be swapped
		 * 1, 2, 3, 4
		 * Should become
		 * 3, 4, 1, 2
		 */
		
		System.out.println("");
//		printArray(result);
		
		assertEquals(
			3,
			result[0]
		);
		
		assertEquals(
			4,
			result[1]
		);
		
		assertEquals(
			5,
			result[2]
		);
		
		assertEquals(
			1,
			result[3]
		);
		
		assertEquals(
			2,
			result[4]
		);
		
	}
	
	@Test
	public void arrayScrambler_interleafArrays_evenItems_shouldInterleaveValues() {
		Object[] array = new Object[] {
			0,
			0,
			1,
			1,
		};
		
		Object[] result = ArrayScrambler.interleafHalves(array);
//		printArray(result);
		
		for(int i = 0; i < result.length; i++) {
			if (i % 2 == 0) {
				assertEquals(
					1,
					result[i]
				);
			} else {
				assertEquals(
					0,
					result[i]
				);
			}
		}
	}
	
	@Test
	public void arrayScrambler_interleafArrays_oddItems_shouldInterleaveValues() {
		Object[] array = new Object[] {
			0,
			0,
			1,
			1,
			1,
		};
		
		Object[] result = ArrayScrambler.interleafHalves(array);
//		printArray(result);
		
		for(int i = 0; i < result.length; i++) {
			if (i % 2 == 0) {
				assertEquals(
					1,
					result[i]
				);
			} else {
				assertEquals(
					0,
					result[i]
				);
			}
		}
	}
	
	@Test 
	public void arrayScrambler_shuffleArray_shouldShuffleArray() {
		Object[] array = new Object[] {
				0,
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9
			};
		
		Object[] result = ArrayScrambler.shuffleArray(array);
		String orderOriginal = arrayToString(array);
		String orderShuffled = arrayToString(result);
		
		System.out.println("Original: " + orderOriginal);
		System.out.println("Shuffled: " + orderShuffled);
	}
	
	private static String arrayToString(Object[] array) {
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < array.length; i++) {
			output.append(array[i]);
		}
		
		return output.toString();
	}
	
	private static void printArray(Object[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println("[" + array[i] + "]");
		}
	}

}
