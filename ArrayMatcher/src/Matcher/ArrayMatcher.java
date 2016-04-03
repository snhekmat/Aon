package Matcher;

public class ArrayMatcher {

	/**
	 * This method will find the starting index where the second parameter occurs as a sub-array in 
	 * the array given as the first parameter.
	 * @param mainArray to be search in
	 * @param subArray to be search for
	 * @return Returns the start matching index. If no matching occurred then returns -1. 
	 */
	public static int FindMatchIndex(int[] mainArray, int[] subArray) {
		if(mainArray == null && subArray == null)
			return -1;
		
		if(mainArray.length < subArray.length)
			return -1;
		
		for(int index = 0; index < mainArray.length;) {
			for(int subIndex = 0; subIndex < subArray.length; subIndex++, index++) {
				if(mainArray[index] == subArray[subIndex]) {
					if(subIndex == subArray.length - 1){
						// here, all sub-array is matched 
						return index - subArray.length + 1;
					}
					
				}else{
					// reset the search from the next index of mainArray
					index = index - subIndex + 1; 
					break;
				}				
			}			
		}
		
		return -1;
	}
}
