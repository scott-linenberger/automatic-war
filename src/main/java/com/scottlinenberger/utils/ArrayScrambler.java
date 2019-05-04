package com.scottlinenberger.utils;

import java.util.Arrays;
import java.util.Random;

public abstract class ArrayScrambler {
	public static Object[] shuffleArray(Object[] array) {
		Object[] result = Arrays.copyOf(array, array.length);
		
		result = swapRandomIndexes(result);
		result = swapHalves(result);
		result = interleafHalves(result);
		
		result = swapRandomIndexes(result);
		result = swapHalves(result);
		result = interleafHalves(result);
		
		return result;
	}
	
	public static Object[] swapRandomIndexes(Object[] array) {
		Object[] result = Arrays.copyOf(array, array.length);
		
		int shuffleOperations = 1024;
		int arraySize = result.length;
		
		for (int i = 0; i < shuffleOperations; i++) {
			/* get a random index */
			int index = new Random().nextInt(arraySize);
			int swapIndex = new Random().nextInt(arraySize);
			
			/* swap the values */
			swapIndexes(
				result, 
				index, 
				swapIndex
			);
		}
		
		return result;		
	}
	
	public static void swapIndexes(Object[] array, int indexA, int indexB) {
		Object objectA = array[indexA];
		Object objectB = array[indexB];
		
		array[indexB] = objectA;
		array[indexA] = objectB;
	}
	
	public static Object[] swapHalves(Object[] array) {
		int length = array.length;
		int half = length / 2; 
		
		Object[] half1 = Arrays.copyOfRange(
			array,
			0,
			half
		);
		
		Object[] half2 = Arrays.copyOfRange(
			array,
			half,
			length
		);
		
		Object[] result = new Object[length];
		int index = 0;
		
		for (int i = 0; i < half2.length; i++) {
			result[index++] = half2[i];
		}
		
		for (int j = 0; j < half1.length; j++) {
			result[index++] = half1[j];
		}
		
		return result;
	}
	
	public static Object[] interleafHalves(Object[] array) {
		int length = array.length;
		int half = length / 2;
		
		Object[] result = new Object[length];
		
		Object[] half1 = Arrays.copyOfRange(
				array,
				0,
				half
			);
			
		Object[] half2 = Arrays.copyOfRange(
			array,
			half,
			length
		);
		
		int index1 = 0;
		int index2 = 0;
		
		for (int i = 0; i < length; i++) {
			Object currentValue = null;
			
			if (i % 2 == 0) {
				currentValue = half2[index2++];
			} else {
				currentValue = half1[index1++];
			}
			
			result[i] = currentValue;
		}
		
		return result;
	}
}
