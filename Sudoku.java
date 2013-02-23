/*
  File: Sudoku.java

  Description: Read in a txt file of a sudoku grid, output whether the grid is valid or not

  Student Name: Steven Lee

  Date Created: 3/28/12

  Date Last Modified: 3/30/12

*/

import java.util.Scanner;
import java.io.*;
public class Sudoku 
{
	public static void main (String[] args) throws IOException
	{
		File file = new File ("sudoku.txt");
		Scanner sc = new Scanner(file);
		int [][] sudo = new int [9][9];
		
		while (sc.hasNext())
		{
			//read sudoku from text file into 9x9 array
			for (int i = 0; i < 9; i ++)
			{
				for (int j = 0; j < 9; j++)
				{
					
					sudo[i][j] = sc.nextInt();
					//output the array
					System.out.print (sudo[i][j] + " ");
				}
				//add new line at the end of each row
				System.out.println();
			}
			
		}
		//output whether it is valid or invalid
		if (!isValid(sudo))
		{
			System.out.println ("\nNot valid Sudoku grid.");
		}
		else
		{
			System.out.println ("\nSudoku grid is valid. GREAT JOB!!!");
		}
	}
	public static boolean isValid (int arr[][])
	{
		//check if rows contain valid numbers 1-9
		for (int i = 0; i < 9; i++)
		{
			if (!portionValid(arr[i]))
			{
				return false;
			}
		}
		//check if columns contain valid numbers 1-9
		for (int i = 0; i < 9; i++)
		{
			//create a single dimensional column array to be passed to the checking method
			int[] column = new int[9];
			for (int j = 0; j < 9; j++)
			{
				column[j] = arr[j][i];
			}
			if (!portionValid(column))
			{
				return false;
			}
		}
		//check if 3x3 box has valid numbers 1-9
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				int k = 0;
				int [] list = new int [9];
				//make the numbers in 3x3 box into a single dimensional array
				for (int row = i * 3; row < i * 3 + 3; row++)
				{
					for (int column = j * 3; column < i * 3 + 3; column++)
					{
						list[k++] = arr[row][column];
					}
				}
				if (!portionValid (list))
				{
					return false;
				}
			}
		}
		return true;
	}
	public static boolean portionValid (int checkArr [])
	{
		//method to check whether a array list of 9 integers has numbers 1-9
		int[]temp = new int[checkArr.length];
		System.arraycopy(checkArr, 0, temp, 0, checkArr.length);
		//sory the copied array
		java.util.Arrays.sort(temp);
		//check that the sorted numbers are in sequential order 1+ for each
		for (int i = 0; i < 9; i++)
		{
			if (temp[i] != i + 1)
			{
				return false;
			}
		}
		return true;
	}

}
