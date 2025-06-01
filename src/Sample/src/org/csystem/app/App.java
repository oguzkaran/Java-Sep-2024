package org.csystem.app;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.matrix.MatrixUtil;

import java.util.Random;

class App {
	public static void main(String[] args)
	{
		int [][] a = MatrixUtil.randomMatrix(new Random(), 3, 4, 1, 100);

		ArrayUtil.print(a);
	}
}
