public class Matrix {
	private int[][] array2d;

	public Matrix(int size1, int size2) {
		this.array2d = new int[size1][size2]; 
	}
	
	public int[][] getArray () {
		return array2d;
	}
	
	
	public void setElement(int posX, int posY, int value) {
		int columns = this.array2d.length;
		int rows = this.array2d[0].length;
		if((posX < columns) && (posY < rows)) {
			this.array2d[posX][posY] = value;	
		}
	}
	//Method to set entire row, as specified by user.
	public void setRow(int row, String input) {
		int rowLength = this.array2d.length;
		int rowPos = this.array2d[0].length;
		//Array to hold integers from input.
		int[] rowTemp = new int[rowLength];
		//String to hold only integers from String input.
		String number = ""; 
		String temp = "";
		int count = 0;
		int tempNum = 0;
		if(row < rowPos) {
			for(int i = 0; i < input.length(); i++) {
				temp = input.substring(i, i+1);
				char c = temp.charAt(0);
				if(Character.isDigit(c)) {
					
					if (i == (input.length() - 1)) {
						//temp = input.substring(i-1, i);
						number = number.concat(temp);
						tempNum = Integer.parseInt(number);
						rowTemp[count] = tempNum;
						count++;
					}
					else {
					number = number.concat(temp);
					}
					
				}
				
				else if (temp.equals(",")) {
					// create code to add previous number to row array
					tempNum = Integer.parseInt(number);
					rowTemp[count] = tempNum;
					count++;
					number = "";		
				}
			}
		}
		this.array2d[row] = rowTemp;
	}
	
	public String toString() {
		String output = "[";
		int j, i = 0;
		for(i = 0; i < array2d.length; i++) {
			for(j = 0; j < array2d[0].length; j++) {
				if (j > 0) {
					output = output + ",";
				}
				output = output + array2d[i][j];
			}
			if (i > 0) {
				output = output + "; ";
			}
			output = output + array2d[i][j];
		}
		output = output + "]";
		return output;
	}
}