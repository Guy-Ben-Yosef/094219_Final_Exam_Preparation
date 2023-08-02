class DictionaryIterator implements Iterator<String[]> {
	String[][] stringDict;
	int numOfPairs;
	int counter;
	String referenceKey;
	
	public DictionaryIterator(Dictionary dictionary) {
		this.stringDict = dictionary.dict;
		this.numOfPairs = dictionary.index;
		this.counter = 0;
		this.referenceKey = "";
	}
	
	public boolean hasNext() {
	return counter < numOfPairs;
	}
	
	public String[] next() {
		String[2] pair;
		int nextKeyIndex = findNextKeyIndex(referenceKey);
		String nextKey   = stringDict[0][nextKeyIndex];
		String nextValue = stringDict[1][nextKeyIndex];
		this.referenceKey = nextKey;
		counter++;
		pair[0] = nextKey;
		pair[1] = nextValue;
		
		return pair;
	}	
	private int findNextKeyIndex(String s1) {
	boolean flag = false;
	String minString;
	for (int j = 0; j < numOfPairs; j++){
		String s2 = stringDict[0][j];
		if (s2.compareTo(s1) == 1) { // If not yet returned
			if (!flag) {
				flag = true;
				minString = s2;
			} else {
				if (s2.compareTo(minString) == 1) {
					minString = s2;
			}
		}
		}
	}
		
	return nextKeyIndex;
	}
}


public static int countSubsetSum(int[] arr, int sum){ 
	if (sum == 0) {return 1}
	if (arr.length == 0) {return 0}
	
	int[] newArr = arr.subList(0, ); // New array without the first element
	return ( countSubsetSum(newArr, sum-arr[0]) + countSubsetSum(newArr, sum) )
	
	}